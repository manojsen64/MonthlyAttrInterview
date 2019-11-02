package com.wns.mai.validation.util.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.wns.mai.entity.Candidate;
import com.wns.mai.validation.util.ValidationUtil;

public class ValidationUtilTest {

	@Test
	public void test_nvic_case_01() {
		Candidate candidate = getCondidateData();
		candidate.setNvic("");
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setNvic(null);
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setNvic("330416");
		assertTrue(ValidationUtil.validate(candidate));
	}

	@Test
	public void test_year_case_01() {
		Candidate candidate = getCondidateData();
		candidate.setYear("");
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setYear(null);
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setYear("2016");
		assertTrue(ValidationUtil.validate(candidate));
	}

	@Test
	public void test_year_case_02() {
		Candidate candidate = getCondidateData();
		candidate.setYear("1955");
		assertFalse(ValidationUtil.validate(candidate));
	}

	@Test
	public void test_year_case_03() {
		Candidate candidate = getCondidateData();
		candidate.setYear("2055");
		assertFalse(ValidationUtil.validate(candidate));
	}

	@Test
	public void test_family_case_01() {
		Candidate candidate = getCondidateData();
		candidate.setFamily("");
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setFamily(null);
		assertFalse(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_family_case_02() {
		Candidate candidate = getCondidateData();
		candidate.setFamily("125cc");
		assertTrue(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_family_case_03() {
		Candidate candidate = getCondidateData();
		candidate.setFamily("125ccdfsjhdfjhsdfhjhhkhjhjsdfsfsjdfh");
		assertFalse(ValidationUtil.validate(candidate));
	}

	@Test
	public void test_drive_case_01() {
		Candidate candidate = getCondidateData();
		candidate.setDrive("");
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setDrive(null);
		assertFalse(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_drive_case_02() {
		Candidate candidate = getCondidateData();
		candidate.setDrive("RWD");
		assertTrue(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_drive_case_03() {
		Candidate candidate = getCondidateData();
		candidate.setDrive("XXX");
		assertFalse(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_fuel_case_01() {
		Candidate candidate = getCondidateData();
		candidate.setFuel("");
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setFuel(null);
		assertFalse(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_fuel_case_02() {
		Candidate candidate = getCondidateData();
		candidate.setFuel("O");
		assertFalse(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_fuel_case_03() {
		Candidate candidate = getCondidateData();
		assertTrue(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_turbo_case_01() {
		Candidate candidate = getCondidateData();
		candidate.setTurbo("");
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setTurbo(null);
		assertFalse(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_turbo_case_02() {
		Candidate candidate = getCondidateData();
		candidate.setTurbo("Z");
		assertFalse(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_turbo_case_03() {
		Candidate candidate = getCondidateData();
		assertTrue(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_country_case_01() {
		Candidate candidate = getCondidateData();
		candidate.setCountry("");
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setCountry(null);
		assertFalse(ValidationUtil.validate(candidate));

	}

	@Test
	public void test_country_case_02() {
		Candidate candidate = getCondidateData();
		candidate.setCountry("INDIA");
		assertFalse(ValidationUtil.validate(candidate));
	}

	@Test
	public void test_country_case_03() {
		Candidate candidate = getCondidateData();
		assertTrue(ValidationUtil.validate(candidate));
	}

	
	@Test
	public void test_bodystyle_case_01() {
		Candidate candidate = getCondidateData();
		candidate.setBodyStyle("");
		assertFalse(ValidationUtil.validate(candidate));
		candidate.setCountry(null);
		assertFalse(ValidationUtil.validate(candidate));

	}
	
	@Test
	public void test_bodystyle_case_02() {
		Candidate candidate = getCondidateData();
		candidate.setBodyStyle("MMMMMKKKKKKKYYYYYYYYYYYSYSYSYSYSYSYSYSYS");
		assertFalse(ValidationUtil.validate(candidate));

	}
	
	@Test
	public void test_bodystyle_case_03() {
		Candidate candidate = getCondidateData();
		assertTrue(ValidationUtil.validate(candidate));

	}
	private Candidate getCondidateData() {
		Candidate candidate = new Candidate();
		candidate.setNvic("330416");
		candidate.setOldNewFlag("NEW");
		candidate.setFamily("125cc");
		candidate.setYear("2016");
		candidate.setBodyStyle("Minibike");
		candidate.setCountry("AUS");
		candidate.setTurbo("N");
		candidate.setFuel("P");
		candidate.setDrive("RWD");
		return candidate;
	}
}
