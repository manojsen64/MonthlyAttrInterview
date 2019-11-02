/**
 * 
 */
package com.wns.mai.batch.config;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import com.wns.mai.entity.Candidate;

/**
 * <P>The {@code CandidateInterviewWriter} class helping to write the data 
 * @author Manoj
 *
 */
@Component
public class CandidateInterviewWriter implements ItemWriter<Candidate> {
	
	
	@Override
	public void write(List<? extends Candidate> arg0) throws Exception {
	//log the data
	}

}
