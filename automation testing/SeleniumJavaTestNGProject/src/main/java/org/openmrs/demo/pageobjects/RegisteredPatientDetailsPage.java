package org.openmrs.demo.pageobjects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisteredPatientDetailsPage extends BasePage {

	   public  RegisteredPatientDetailsPage(WebDriver driver) {
		   super(driver);
	   }
   
	   @FindBy(xpath = "//div[contains(text(),'Start Visit')]//ancestor::a")  // start visits 
	   WebElement activeVistsLinkElement;
	   
	   @FindBy(xpath= "//h3[normalize-space(text())='Start a visit']//ancestor::div[contains(@id,'quick-visit-creation-dialog')]//button[normalize-space(text())='Confirm']")
	   WebElement activeVisitConfirmButtonElement; // confirm box start vists 
	   
	   @FindBy(xpath="//div[@class='action-section']//h3[text()='Current Visit Actions']//following-sibling::li//div[contains(text(),'End Visit')]//ancestor::a[contains(@id,'endVisit')]")
	   WebElement endVisitLinkElement; // End visit link element Link inspect
	   
	   @FindBy(xpath="//div[@class='action-section']//h3[text()='Current Visit Actions']//following-sibling::li//div[contains(text(),'Attachments')]//ancestor::a")
	   WebElement attachmentsLinkElement; // Attachments Link click element 
	   
	   @FindBy(xpath="//div[text()='Click or drop a file here.']")
	   WebElement clickDropElement; // // get click DropElement
	   
	   @FindBy(xpath="//textarea[@placeholder='Enter a caption']")
	   WebElement captionElement; // caption Element
	   
	   @FindBy(xpath="//button[text()='Upload file']")
	   WebElement uploadButtonElement; // upload file Button 
	   
	   @FindBy(xpath="//div[contains(text(),'Delete Patient')]//ancestor::a")
	   WebElement deletepatientLink; // delete patient Link Element 
	   
	   @FindBy(xpath= "[id='delete-reason']")
	   WebElement DeleteReasonInputElement;
	   
	   @FindBy(xpath="//h3[contains(text(),'Delete Patient')]//ancestor::div[contains(@id,'delete-patient-creation-dialog')]//button[normalize-space(text())='Confirm']")
	   WebElement deletepatientConfirmButton; // delete patient 
	   
	   @FindBy(xpath="//td[text()='No matching records found']")
	   WebElement errorMessageElement; // No Matching Record Found
	   
	   public boolean verifyRegisteredpatientDetails(String name) {
		   WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
			 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//em[text()='Given']//preceding-sibling::span[normalize-space(text())='" +name + "']"))));
	    	return driver.findElement(By.xpath("//em[text()='Given']//preceding-sibling::span[normalize-space(text())='" +name + "']")).isDisplayed();
	    	
	    }
	   
	   public boolean verifyRegisteredpatientName(String name) {
		   WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
			 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//em[text()='Given']//preceding-sibling::span[normalize-space(text())='" +name + "']"))));
	    	return driver.findElement(By.xpath("//em[text()='Given']//preceding-sibling::span")).getText().trim().contains(name.split(",")[0].trim());
	    	
	    }
	     
	    public  String getpatientId() {
	    	return driver.findElement(By.xpath("//em[text()='Patient ID']//following-sibling::span")).getText().trim();
	    	
	    }
	    
	    public WebElement getActiveVisitsLinkElement() {
	    	return activeVistsLinkElement;
	    }
	    
	    public void clickActiveVisits() {
			getActiveVisitsLinkElement().click();
		}
	 
	    public WebElement getActiveVisitsConfirmButtonElement() {
			return activeVisitConfirmButtonElement;
		}
	  		

	public void clickActiveVisitsConfirmButton() {
		   getActiveVisitsConfirmButtonElement().click();
   }
	   
	public WebElement getEndVistsLinkElement() {
		return endVisitLinkElement;
	}

	public boolean verifyEndVisitsLink() {
		return getEndVistsLinkElement().isDisplayed();
	}
	    
	    public WebElement getAttachmentsLinkElement() {
	    	return attachmentsLinkElement;
	    	
	    }
	    
	    public void clickAttachmentsLink() {
			getAttachmentsLinkElement().click();
		}

	    
	    public WebElement getClickDropElement() {
	    	return clickDropElement;
	    }
	    
	    public boolean verifyClickDropButton() {
	    	return getClickDropElement().isDisplayed();
	    }
	    	public void clickDropButton() {
	    		getClickDropElement().click();
	    	}
	    	
	    	public void uploadFileFormWindowpopup(String filePath) {
	    		try {
	    			Robot robot = new Robot();
	    			
	    			StringSelection stringSelection = new StringSelection(filePath);
	    			Toolkit.getDefaultToolkit().getSystemClipboard().getContents(stringSelection);
	    			
	    			robot.keyPress(KeyEvent.VK_CONTROL);
	    			robot.keyPress(KeyEvent.VK_V);
	    			robot.keyPress(KeyEvent.VK_CONTROL);
	    			robot.keyPress(KeyEvent.VK_V);
	    			
	    			Thread.sleep(5000);
	    		    robot.keyPress(KeyEvent.VK_ENTER);
	    		    robot.keyRelease(KeyEvent.VK_ENTER);
	    		    Thread.sleep(5000);
	    			
	    		} catch(Exception e) {
	    			System.out.println("Exception Occured during file upload: "+e.getMessage());
	    			
	    		}
	    	}
	    	public WebElement getCaptionElement() {
	    		return captionElement;
	    	}
	    	public void setCaption(String caption) {
	    		getCaptionElement().sendKeys(caption);
	    	}
	    	
	    	public WebElement getUploadButtonElement() {
	    		return uploadButtonElement;
	    	}
	    	
	    	public void clickUploadButton() { // you can see once page object model to same code line:
	    		try {
	    			getUploadButtonElement().click();
	    			Thread.sleep(10000);
	    		} catch(Exception e) {
	    			System.out.println("Exception is Occured while file Upload:"+e.getMessage());
	    		}
	    		
	    	}
	    
	    	public boolean verifyUploadedFile(String fileCaption) { // doubt ask Raju sir
	    		return driver.findElement(By.xpath("//p[text()='" +fileCaption +"']//ancestor::div//preceding-sibling::div[contains(@class,'att_thumbnail-container')]")).isDisplayed();
	    		
	    	}
	    	
	    	public WebElement getDeletepatientLinkElement() {
	    		return deletepatientLink;
	    	}
	    	
	    	public void clickDeletepatientLink() {
	    		getDeletepatientLinkElement().click();
	    	}
	    	
	    	public WebElement getDeleteReasonInputElement() {
	    		return DeleteReasonInputElement;
	    	}
	    	
	    	public void setDeleteReason(String reason) {
	    		getDeleteReasonInputElement().sendKeys(reason);
	    	}
	    	
	    	public WebElement getDeletepatientConfirmButtonElement () {
	    		return getDeletepatientConfirmButtonElement();
	    	}
	    	
	    	public void clickDeletePatientConfirmButton() {
	    		getDeletepatientConfirmButtonElement().click();
	    	}
	    	
	    	public WebElement getErrorMessageElement() {
	    		return getErrorMessageElement();
	    	}
	    	
	    	public boolean verifyErrorMessage() {
	    		try {
	    		 FluentWait wait1 = new FluentWait(driver);
	    		 wait1.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
	    		 Thread.sleep(5000);
	    		 WebElement searchedRecord = (WebElement)wait1.until(driver-> getErrorMessageElement());
	    		return searchedRecord.isDisplayed();
	    		} catch(Exception e) {
	    			System.out.println("Exception Occured while verifying the error message: "+ e.getMessage());
	    			return false;
	    		}
	    	}
	    	

			public void setPatientIdInSearchFiled1(String patientId) {
				// TODO Auto-generated method stub
				
			}

			public void clickSearchedRecord() {
				// TODO Auto-generated method stub
				
			}

			public boolean verifyEndVistsLink() {
				// TODO Auto-generated method stub
				return false;
			}

			public void setPatientIdInSearchFiled11(String propertyInTestProperties) {
				// TODO Auto-generated method stub
				
			}

			public void setPatientIdInSearchFiled(String propertyInTestProperties) {
				// TODO Auto-generated method stub
				
			}

				
			}
	  	
