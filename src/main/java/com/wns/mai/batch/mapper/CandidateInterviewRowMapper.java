/**
 * 
 */
package com.wns.mai.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.wns.mai.entity.Candidate;
/**
 * <P>The {@code CandidateInterviewRowMapper} class mapping data from database into java entity 
 * @author Manoj
 *
 */
public class CandidateInterviewRowMapper  implements RowMapper<Candidate>{

	
	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate = new Candidate();
		candidate.setNvic(rs.getString("nvic"));
		candidate.setFamily(rs.getString("family"));
		candidate.setYear(rs.getString("year"));
		candidate.setBodyStyle(rs.getString("bodystyle"));
		candidate.setCountry(rs.getString("country"));
		candidate.setTurbo(rs.getString("turbo"));
		candidate.setFuel(rs.getString("fuel"));
		candidate.setDrive(rs.getString("drive"));
		candidate.setId(rs.getInt("ID"));
		return candidate;
	}
}
