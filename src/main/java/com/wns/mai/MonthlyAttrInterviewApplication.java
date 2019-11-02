/**
 * 
 */
package com.wns.mai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <P>The {@code MonthlyAttrInterviewApplication} class is main class which start the applcation
 * @author Manoj
 *
 */

@SpringBootApplication
@EnableScheduling
public class MonthlyAttrInterviewApplication   {


	public static void main(String[] args) {
		SpringApplication.run(MonthlyAttrInterviewApplication.class, args);
	}


}
