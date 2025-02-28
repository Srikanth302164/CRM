package org.openmrs.demo.bdd.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	
	features ="Features",
	glue ="org.openmrs.demo.bdd.stepDefinations",
	tags="@LoginWithValidCredentials"
	
		
)
public class BDDTestRunner { 

}
