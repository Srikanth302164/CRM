package org.openmrs.demo.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openmrs.demo.Commons;
import org.openmrs.demo.LoginPage;
import org.openmrs.demo.pageobjects.ExcelUtils;
import org.openmrs.demo.pageobjects.FindPatientPage;
import org.openmrs.demo.pageobjects.HomePage;
import org.openmrs.demo.pageobjects.RegisteredPatientDetailsPage;
import org.openmrs.demo.pageobjects.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class OpenMrsBaseTest {

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public RegistrationPage registrationPage;
	public RegisteredPatientDetailsPage patientDetailsPage;
	public FindPatientPage findpatientPage;
	public String patientId;

	@BeforeSuite(alwaysRun = true) // Open the Browser 
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//main//resources//DriverFiles//chrome//130//chromedriver.exe");
	}

	@BeforeTest(alwaysRun = true) 
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Commons.getPropertyInTestProperties("url"));
	}

	@BeforeClass(alwaysRun = true) // Navigate to my Url
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		patientDetailsPage = new RegisteredPatientDetailsPage(driver);
		findpatientPage = new FindPatientPage(driver);

	}

	@BeforeMethod(alwaysRun = true) // Login 
	@Parameters({ "UserName", "Password", "Module" })
	public void beforeMethod(String userName, String password, String module) {
		loginPage.loginToOpenMrs(userName, password, module);
	}

	@AfterMethod(alwaysRun = true) // Login
	public void afterMethod() {
		try {
			Thread.sleep(10000);
			homePage.clickLogout();
			Thread.sleep(5000);
		Assert.assertTrue((boolean) loginPage.verifyLoginPage());
		} catch (Exception e) {
			System.out.println("Exception Occured while clicking Logout:" + e.getMessage());
		}

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		loginPage = null;
		homePage = null;
		registrationPage = null;
		patientDetailsPage = null;
		findpatientPage = null;
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("Test Ended");
	}

	@DataProvider(name = "RegisterPatientData")
	public Iterator<String[]> registerPatientData() {
		List<String[]> testData = (List<String[]>) ExcelUtils.readDataFromExcel(
				System.getProperty("user.dir") + Commons.getPropertyInTestProperties("test.data.excel.file"),
				"RegisterPatientDetails");
		return testData.iterator();
	}

}
