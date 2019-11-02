/**
 * 
 */
package com.wns.mai.batch.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.wns.mai.entity.Candidate;
import com.wns.mai.validation.util.ValidationUtil;



/**
 * <P>The {@code CandidateInterviewProcessor} class helping to write the data into database after validating interview data
 * @author Manoj
 *
 */
@Component
public class CandidateInterviewProcessor implements ItemProcessor<Candidate,Candidate> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${update.monthly.interview.sql}")
	private String updateMonthlyInterviewQuery;
	
	@Override
	public Candidate process(Candidate candidate) throws Exception {
		boolean flag =ValidationUtil.validate(candidate);
		if(flag==false) {
			jdbcTemplate.update(updateMonthlyInterviewQuery, candidate.getId());	
		}
		return candidate;
	}

}
