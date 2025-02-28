package org.openmrs.demo.test;
import org.openmrs.demo.Commons;
import org.openmrs.demo.HomePage;
import org.openmrs.demo.RegisteredPatientDetailsPage;
import org.openmrs.demo.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

//If you have less functionlaities and if you want to test those functionalities with different sets of data
//ten we need to implement Data Driven Framework

public class OpenMrsDataDrivenFramework extends OpenMrsBaseTest {

	@Test(dataProvider = "RegisterPatientData")
	public void registerpatient(String name, String Gender, String dateOfBirth, String addrees, String phoneNumber) {
		System.out.println("-------------------------Register patient---------------");
		Assert.assertTrue(HomePage.verifyTile("Register a patient"), "Register patient Tile is not displayed");
		HomePage.clickTile("Register a patient");
		Assert.assertTrue(RegistrationPage.verifyRegisterPatientPage("Register a patient"),
				"Register patient page is not displayed");

		RegistrationPage.setpatientName(name);
		RegistrationPage.ClickNextButton();
		RegistrationPage.selectGenderByVisibleText(Gender);
		RegistrationPage.ClickNextButton();
		RegistrationPage.setdateofBirth(dateOfBirth);
		RegistrationPage.ClickNextButton();
		RegistrationPage.setAddress(addrees);
		RegistrationPage.ClickNextButton();
		RegistrationPage.setPhoneNumber(phoneNumber);
		RegistrationPage.ClickNextButton();
		RegistrationPage.ClickNextButton();
		Assert.assertTrue(RegistrationPage.verifyConfirmPage(name, Gender, dateOfBirth, "Hyderabad", phoneNumber),
				"Register details are not displaying properly, Cancelling the register");
		RegistrationPage.clickConfirm();
		Assert.assertTrue(patientDetailsPage.verifyRegisteredpatientName(name));
		String patientId = RegisteredPatientDetailsPage.getpatientId();
		System.out.println(patientId);
		Commons.setPropertyInTestProperties("patient.id", patientId);
	}

}
