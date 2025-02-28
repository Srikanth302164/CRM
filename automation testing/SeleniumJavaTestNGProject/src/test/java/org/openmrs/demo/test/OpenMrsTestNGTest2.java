package org.openmrs.demo.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenMrsTestNGTest2 {
	
 // dependsOnMethod = To avoid the script 
 // Enabled False = it will not Run only that script 
// invocationCount 4= it will Run script 4 times 
	
	@Test(groups = {"SmokeTest","SanityTest","RegressionTest"},priority = 0)
	@Parameters({"UserName","Password"})
	public void registerpatient(String userName, String password) {
		System.out.println("This is register Patient");
		System.out.println("UserName: "+userName);
		System.out.println("password: "+password);
		Assert.assertEquals(true, true);

	}

	@Test(groups = {"SanityTest","RegressionTest"},priority = 1)
	public void findPatient() {
		System.out.println("This is Find Patient");
		Assert.assertEquals(true, true);


	}

	@Test(groups = "RegressionTest", priority = 2)
	public void activateVisitsAndAddAttachments() {
		System.out.println("This is Activate Visits and Add Attachments");
		Assert.assertEquals(true, true);


	}

	@Test(groups = "RegressionTest", priority = 3)
	public void deletePatient() {
		System.out.println("This is delete Patient");
		Assert.assertEquals(true, true);


	}

}
