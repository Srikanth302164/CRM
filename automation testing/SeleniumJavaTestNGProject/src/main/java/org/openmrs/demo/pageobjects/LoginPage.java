package org.openmrs.demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage  {
	
	   public LoginPage(WebDriver driver) {
		   super(driver);
		   
	   }
	   
	   @FindBy(id= "username")
	   private WebElement userNameElement;
	   
	   @FindBy(id= "password")
	  private WebElement passwordElement;
	   
	   @FindBy(css = "input[value='Log In']")
	   private WebElement loginButtonElement;
	   

	public WebElement getUserNameElement() { // Methods 
		return userNameElement;
	}

	public WebElement getPasswordElement() {
		return passwordElement;
	}

	public WebElement getLoginButtonElement() {
		return loginButtonElement;
	}

	public void SetUserName(String userName) {
		getUserNameElement().sendKeys(userName);
	   }
	   
	   public void setpassword(String password) {
		   getPasswordElement().sendKeys(password);
	   }

	public void clickModule(String moduleName) {
		driver.findElement(By.id(moduleName)).click();
	}
	
	public void clickLoginButton() {
		getLoginButtonElement().click();
	}
	
	
    public void loginToOpenMrs(String userName, String password, String moduleName ) { // Pom divided 
//    	 driver.findElement(By.id("username")).sendKeys(userName);
//		 driver.findElement(By.id("password")).sendKeys(password); 
//		 driver.findElement(By.id(moduleName)).click();
//		 driver.findElement(By.cssSelector("input[value='Log In']")).click();
		 
		 SetUserName(userName);
		 setpassword(password);
		 clickModule(moduleName);
		 clickLoginButton();
    }
    public boolean verifyLoginPage() {
    	return driver.getTitle().trim().equalsIgnoreCase("Login");


}
}
