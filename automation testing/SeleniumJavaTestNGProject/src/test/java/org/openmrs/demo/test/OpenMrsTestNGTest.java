package org.openmrs.demo.test;

import org.testng.annotations.Test;

public class OpenMrsTestNGTest {
 // dependsOnMethod = To avoid the script 
 // Enabled False = it will not Run only that script 
// invocationCount 4= it will Run script 4 times 
	@Test(priority = 0)
	public void registerpatient() {
		System.out.println("This is register Patient");

	}

	@Test(priority = 1, dependsOnMethods ="registerpatient")
	public void findPatient() {
		System.out.println("This is Find Patient");

	}

	@Test(priority = 2, enabled = false)
	public void activateVisitsAndAddAttachments() {
		System.out.println("This is Activate Visits and Add Attachments");

	}

	@Test(priority = 3, invocationCount = 4)
	public void deletePatient() {
		System.out.println("This is delete Patient");

	}

}
