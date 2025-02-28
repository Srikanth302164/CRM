package org.openmrs.demo.bdd.stepDefinations;

public class LoginStepDefination {
	
	@Given("Launch OpenMRs Login Page")
	public void launchApplication() {
		System.out.println("Open Mrs Application Launched");
	}
	
	@Given("User is on OpenMrs Login Page")
	public void userIsOnTheOpenMrsLoginPage() {
		System.out.println("User is on Login Page");

}
	@When("user logins with Username {string} and Password{string}")
	public void userLoginsWithUserNameAndPassword(String userName, String password) {
		System.out.println("User Name: "+userName+" and Password: "+password);
		
   } 
	@When("Clicks Login button")
	public void clickLoginButton() {
		System.out.println("Clicked Login Button");
	
    }
	@Then("Login should Successuful")
	public void verifyLoginShouldSuccessful() {
		System.out.println("Login Success");

    }
}

