package org.openmrs.demo.pageobjects;



import java.awt.Desktop.Action;
import java.time.Duration;
// selenium Handling web tables in Find Patient 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPatientPage extends BasePage {

	private final String FindpatientTableFirstRecord = null;

	public FindPatientPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "patient-search") // search button verify
	WebElement searchfieldElement;

	@FindBy(xpath = "//table[@id='patient-search-results-table']//thead/tr/th/div")
	static List<WebElement> allFindPatientColumnNameElements;

	@FindBy(xpath = "//table[@id='patient-search-results-table']//tbody/tr[1]")
	WebElement FindPatientTableFirstRecord;

	public boolean FindPatientPage(String pageName) {
		return driver.findElement(By.xpath("//h2[normalize-space(text())='" + pageName + "']")).isDisplayed(); // find
																												// patient
																												// display
																												// or
																												// not

	}

	public WebElement getSearchFieldElement() {
		return searchfieldElement;
	}

	public void setpatientIdserachField(String patientId) {
		try {
			getSearchFieldElement().sendKeys(patientId);
			Thread.sleep(10000);
		}catch(Exception e) {
			
		}
	}

	public static List<WebElement> getAllFindPatientColumnNameElements() {
		return allFindPatientColumnNameElements;
	}

	public static Map<String, Integer> getFindPatientTableColumnNamesMap() {
// List<WebElement> allFindpatientColumnNameElement = driver.findElement(by.xpath("//table[@id="patient-search-results-table"]//thead/tr/th/div"));

		Map<String, Integer> allColumnNamesMap = new HashMap<>();
		int i = 1;
		for (WebElement eachElement : getAllFindPatientColumnNameElements()) {
			allColumnNamesMap.put(eachElement.getText().trim(), i);
			i++;
		}

		return allColumnNamesMap;
	}

	public static int getFindpatientTableColumnNameIndex(String ColumnName) {
		return getFindPatientTableColumnNamesMap().get(ColumnName);
	}

	public static String getFindPatientTableColumnValue(String columnName) {
		int index = getFindpatientTableColumnNameIndex(columnName);
		return driver.findElement(By.xpath("//table[@id=\"patient-search-results-table\"]//tbody/tr/td[" + index + "]"))
				.getText().trim();
	}

	public WebElement getFindPatientTableFirstRecordElement() {
		return FindPatientTableFirstRecord;
	}

	public void clickSearchRecord() {
		// getFindPatientTableFirstRecordElement().click();
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(getFindPatientTableFirstRecordElement()));
			wait.until(ExpectedConditions.elementToBeClickable(getFindPatientTableFirstRecordElement()));
//			wait.until(ExpectedConditions.stalenessOf(getFindPatientTableFirstRecordElement()));
			Thread.sleep(5000);

//			FluentWait wait1 = new FluentWait(driver);
//			wait1.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5))
//					.ignoring(NoSuchElementException.class);
//			Thread.sleep(5000);
//
//			Actions actions = new Actions(driver);
//			actions.moveToElement(getFindPatientTableFirstRecordElement())
//					.click(getFindPatientTableFirstRecordElement()).build();
//			actions.perform();
			getFindPatientTableFirstRecordElement().click();

//	  WebElement searchedRecord = (WebElement)wait1.until(new Function<WebDriver, WebElement>() {
//		  @Override
//	 public WebElement apply(WebDriver t) {
//	  return getFindPatientTableFirstRecordElement();
//	 }
//    });
//			WebElement searchedRecord = (WebElement) wait1.until(driver -> getFindPatientTableFirstRecordElement());
//			searchedRecord.click();

		} catch (Exception e) {
			System.out.println("Execution Occured click operations on searched record: " + e.getCause());
		}

	}
// code Enough find patient 

	public static void clickSearchedRecord() {
		// TODO Auto-generated method stub

	}

	public static void setPatientIdInSearchFiled(String patientId) {
		// TODO Auto-generated method stub

	}

	public static boolean verifyFindPatientPage(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
