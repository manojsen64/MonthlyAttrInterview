/**
 * 
 */
package com.wns.mai.validation.util;

import java.time.Year;

import com.wns.mai.constant.Drive;
import com.wns.mai.constant.Fuel;
import com.wns.mai.constant.Turbo;
import com.wns.mai.entity.Candidate;

/**
 * <P>
 * The {@code ValidationUtil} class helping to validate the candidate Data
 * 
 * @author Manoj
 *
 */
public final class ValidationUtil {

	private ValidationUtil() {
	}

	/**
	 * Compares this string to the null and empty
	 * 
	 * @param val
	 *            The object to compare this {@code String} against
	 *
	 * @return {@code true} if the given object represents a {@code String}
	 *         equivalent to this string, {@code false} otherwise
	 */
	private static boolean checkNotNull(String val) {
		return null == val || "".equals(val);
	}

	/**
	 * To check the user supplied data nvic is valid or not
	 * 
	 * @param val
	 * 
	 * @return {@code true} if the given object represents a {@code String}
	 *         equivalent to this string, {@code false} otherwise
	 */
	private static boolean checkNvic(String nvic) {
		return checkNotNullAndLength(nvic, 6);
	}

	/**
	 * To check the given object length
	 * 
	 * @param val
	 * @param length
	 * @return {@code true} if the given object represents a {@code String}
	 *         equivalent to this string, {@code false} otherwise
	 */
	private static boolean checkNotNullAndLength(String val, int length) {
		return (checkNotNull(val) == false) && !(checkLength(val, length));
	}

	/**
	 * To check the user supplied data Year is valid or not
	 * 
	 * @param val
	 * 
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	private static boolean checkYear(String val) {

		if (checkNotNull(val) == false) {
			int year = Integer.valueOf(val);
			return !(year < 1960 || year > getCurrentYear());
		} else {
			return false;
		}

	}

	/**
	 * To get current year
	 * 
	 * @return {@code int}
	 */
	private static int getCurrentYear() {
		return Year.now().getValue();
	}

	/**
	 * validate the length of given string
	 * 
	 * @param val
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	private static boolean checkLength(String val, int length) {
		return val.length() > length;
	}

	/**
	 * To check the user supplied data Fuel type is valid or not
	 * 
	 * @param val
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	private static boolean checkFuelType(String val) {
		return Fuel.P.name().equals(val) || Fuel.D.name().equals(val) || Fuel.E.name().equals(val);
	}

	/**
	 * To check the user supplied data Drive type is valid or not
	 * 
	 * @param val
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	private static boolean checkDriveType(String driveValue) {
		return Drive.RWD.Value().equals(driveValue) || Drive.FWD.Value().equals(driveValue)
				|| Drive._4WD.Value().equals(driveValue) || Drive.AWD.Value().equals(driveValue)
				|| Drive._4X4.Value().equals(driveValue) || Drive._8X4.Value().equals(driveValue)
				|| Drive._6X2.Value().equals(driveValue) || Drive._6X6.Value().equals(driveValue)
				|| Drive._8X8.Value().equals(driveValue) || Drive._2WD.Value().equals(driveValue);
	}

	/**
	 * To check the user supplied data Turbo type is valid or not
	 * 
	 * @param val
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	private static boolean checkTurboType(String turbo) {
		return Turbo.S.name().equals(turbo) || Turbo.Y.name().equals(turbo) || Turbo.T.name().equals(turbo)
				|| Turbo.N.name().equals(turbo) || Turbo.Q.name().equals(turbo);
	}

	/**
	 * To check the user supplied data Family type is valid or not
	 * 
	 * @param val
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	private static boolean checkFamily(String val) {

		return checkNotNull(val) == false && !checkLength(val, 24);
	}

	/**
	 * To check the user supplied data Country is valid or not
	 * 
	 * @param val
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	private static boolean checkCountry(String country) {
		return checkNotNullAndLength(country, 3);
	}

	/**
	 * To check the user supplied data BodyStyle is valid or not
	 * 
	 * @param val
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	private static boolean checkBodyStyle(String bodystyle) {
		return checkNotNullAndLength(bodystyle, 22);
	}

	/**
	 * Validate Candidate information
	 * 
	 * @param candidate
	 * @return {@code true} if the given object represents a {@code String} matching
	 *         the criteria. {@code false} otherwise
	 */
	public static boolean validate(Candidate candidate) {
		boolean flag = false;
		if (checkNvic(candidate.getNvic()) == false) {
			return flag;
		}
		if (checkYear(candidate.getYear()) == false) {
			return flag;
		}
		if (checkFamily(candidate.getFamily()) == false) {
			return flag;
		}
		if (checkDriveType(candidate.getDrive()) == false) {
			return flag;
		}
		if (checkFuelType(candidate.getFuel()) == false) {
			return flag;
		}
		if (checkTurboType(candidate.getTurbo()) == false) {
			return flag;
		}
		if (checkCountry(candidate.getCountry()) == false) {
			return flag;
		}
		if (checkBodyStyle(candidate.getBodyStyle()) == false) {
			return flag;
		}
		return true;
	}

}
