package com.wns.mai.constant;

/**
 * <P>The {@code Drive} class representing drive type
 * @author Manoj
 *
 */
public enum Drive {

	RWD("RWD"),
	FWD("FWD"),
	_4WD("4WD"),
	AWD("AWD"),
	_4X4("4X4"),
	_8X4("8X4"),
	_6X2("6X2"),
	_6X6("6X6"),
	_8X8("8X8"),
	_2WD("_2WD");
	
	
	private String value;

	private Drive(String value) {
		this.value = value;
	}

	public String Value() {
		return value;
	}
	
}
