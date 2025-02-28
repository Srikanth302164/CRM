package org.openmrs.demo.test;

import org.openmrs.demo.Commons;

//If you have more functionalities and if you need to test those functionalities with one set of data
//then we impliment Keyword Driven Framework.

import org.openmrs.demo.FindPatientPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenMrsKeywordDrivenFramework extends OpenMrsBaseTest {
	
	@Test()
	public void registerpatient() {
		System.out.println("-------------------------Register patient---------------");
		Assert.assertTrue(homePage.verifyTile("Register a patient"),"Register patient Tile is not displayed");
			homePage.clickTile("Register a patient");
			Assert.assertTrue(registrationPage.verifyRegisterPatientPage("Register a patient"),"Register patient page is not displayed");

				registrationPage.setpatientName("Ganesh, M");
				registrationPage.ClickNextButton();
				registrationPage.selectGenderByVisibleText("Male");
				registrationPage.ClickNextButton();
				registrationPage.setdateofBirth("1,January,1990");
				registrationPage.ClickNextButton();
				registrationPage.setAddress("Do.No -8/168, S R Nagar", "Hyderabad", "Telangana", "India", "50038");
				registrationPage.ClickNextButton();
				registrationPage.setPhoneNumber("9876543210");
				registrationPage.ClickNextButton();
				registrationPage.ClickNextButton();
				Assert.assertTrue(registrationPage.verifyConfirmPage("Ganesh", "Male", "1990", "Hyderabad", "9876543210"),"Register details are not displaying properly, Cancelling the register");
					registrationPage.clickConfirm();
					Assert.assertTrue(patientDetailsPage.verifyRegisteredpatientDetails("Ganesh")) ;	
					patientId = patientDetailsPage.getpatientId();
						System.out.println(patientId);
						Commons.setPropertyInTestProperties("patient.id", patientId);
					}
		

	@Test()
	public void findPatient() {
		System.out.println("--------------------------Find Patient-----------------");
		Assert.assertTrue(homePage.verifyTile("Find Patient Record"),"Find Patient Record Tile is not available");

		
			homePage.clickTile("Find Patient Record");
			Assert.assertTrue(findpatientPage.verifyFindPatientPage("Find Patient Record"),"Find Patient Page is not displayed");
			
			String patientId = Commons.getPropertyInTestProperties("patient.Id");
			findpatientPage.setpatientIdserachField(patientId);
			String searchedPatientID = FindPatientPage.getFindPatientTableColumnValue("Identifier");
			
			Assert.assertTrue(searchedPatientID.contains(patientId),"Searched record is displaying wrong");
				findpatientPage.clickSearchRecord();
				String actualPatientId = patientDetailsPage.getpatientId();
			Assert.assertTrue(actualPatientId.equals(patientId),"Patient Deatils are incorrect");

	
	}

	@Test()
	public void activateVisitsAndAddAttachments() {	
		System.out.println("---------------Active visits and add attchments----------");
		patientDetailsPage.clickActiveVisits();
		patientDetailsPage.clickActiveVisitsConfirmButton();
		Assert.assertTrue(patientDetailsPage.verifyEndVistsLink(),"start Visits Not Activated");
			patientDetailsPage.clickAttachmentsLink();
			Assert.assertTrue(patientDetailsPage.verifyClickDropButton(),"Click Drop button is not displayed");
				patientDetailsPage.clickDropButton();
				patientDetailsPage.uploadFileFormWindowpopup("UploadFile.pdf");
				patientDetailsPage.setCaption("File1");
				patientDetailsPage.clickUploadButton();
				Assert.assertTrue(patientDetailsPage.verifyUploadedFile("File1"),"File Upload Failed");
				}

	@Test()
	public void deletePatient() {
		System.out.println("-----------Delete patient-----------");
		homePage.clickTile("Find patient Record");
		patientDetailsPage.setPatientIdInSearchFiled1(Commons.getPropertyInTestProperties("Patient.id"));
		patientDetailsPage.clickSearchedRecord();
		patientDetailsPage.clickDeletepatientLink();
	    patientDetailsPage.setDeleteReason("Other");
		patientDetailsPage.clickDeletePatientConfirmButton();
	    patientDetailsPage.setPatientIdInSearchFiled1(Commons.getPropertyInTestProperties("Patient.id"));
	    Assert.assertTrue(patientDetailsPage.verifyErrorMessage(),"Patient Record is not deleted");
		

	}

	}




