/**
 * 
 */
package com.wns.mai.entity;

import lombok.Data;

/**
 * <P>The {@code Candidate} class helping to binding the database table data
 * @author Manoj
 *
 */

@Data
public class Candidate {

	private int id;
	private String nvic;
	private String oldNewFlag;
	private String family;
	private String year;
	private String bodyStyle;
	private String country;
	private String turbo;
	private String fuel;
	private String drive;
	private int validData;

}
