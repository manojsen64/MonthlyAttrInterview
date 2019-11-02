/**
 * 
 */
package com.wns.mai.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wns.mai.batch.mapper.CandidateInterviewRowMapper;
import com.wns.mai.entity.Candidate;

/**
 * <P>The {@code MonthlyInterviewValidatioJob} class representing configuration of process batch job
 * @author Manoj
 *
 */
@Configuration
@EnableBatchProcessing
public class MonthlyInterviewValidatioJob {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Autowired
	public CandidateInterviewProcessor processor;

	@Autowired
	private CandidateInterviewWriter writer;

	@Value("${get.monthly.interview.sql}")
	private String getMonthlyInterviewDataQuery;

	@Bean
	ItemReader<Candidate> itemReader(DataSource dataSource) {
		JdbcCursorItemReader<Candidate> databaseReader = new JdbcCursorItemReader<>();
		databaseReader.setDataSource(dataSource);
		databaseReader.setSql(getMonthlyInterviewDataQuery);
		databaseReader.setRowMapper(new CandidateInterviewRowMapper());
		return databaseReader;
	}

	@Bean
	public Job monthlyMasterBkChangedJob() {
		return jobBuilderFactory.get("MONTHLY_MASTER_BK_CHANGED_JOB").incrementer(new RunIdIncrementer()).flow(step1())
				.end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Candidate, Candidate>chunk(10)
				.reader(itemReader(dataSource)).processor(processor).writer(writer).build();
	}

}
