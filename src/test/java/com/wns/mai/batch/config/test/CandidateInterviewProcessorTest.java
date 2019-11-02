package com.wns.mai.batch.config.test;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import com.wns.mai.batch.config.CandidateInterviewProcessor;
import com.wns.mai.entity.Candidate;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CandidateInterviewProcessorTest {

	@InjectMocks
	@Spy
	private CandidateInterviewProcessor processor;
	

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Before
	public void init() {
		ReflectionTestUtils.setField(processor, "jdbcTemplate", jdbcTemplate);
		ReflectionTestUtils.setField(processor, "updateMonthlyInterviewQuery", "");

	}

	@Test
	public void testProcess() throws Exception {
		Candidate candidate = new Candidate();
		Mockito.when(jdbcTemplate.update("", 1)).thenReturn(1);
		processor.process(candidate);
		Mockito.verify(processor, times(1)).process(candidate);

	}
}
