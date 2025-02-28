package org.openmrs.demo.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBaseClass {

	@Test
	public void test1() {
		System.out.println("This is Test1");
		Assert.assertEquals(true, true);
	}

	@Test
	public void test2() { // this is pass
		System.out.println("This is Test2");
		Assert.assertTrue(true);
	}

	@Test
	public void test3() {
		System.out.println("This is Test3");
		Assert.assertTrue(true);
	}

	@BeforeSuite(alwaysRun= true)
	public void beforeSuite() {
		System.out.println("This is Before suit");
	}

	@AfterSuite(alwaysRun= true)
	public void afterSuite() {
		System.out.println("This is After suit");
	}

	@BeforeTest(alwaysRun= true)
	public void beforeTest() {
		System.out.println("This is Before Test");
	}

	@AfterTest(alwaysRun= true)
	public void afterTest() {
		System.out.println("This is After Test");
	}

	@BeforeClass(alwaysRun= true)
	public void beforeClass() {
		System.out.println("This is Before Class");
	}

	@AfterClass(alwaysRun= true)
	public void afterClass() {
		System.out.println("This is After Class");
	}

	@BeforeMethod(alwaysRun= true)
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}

	@AfterMethod(alwaysRun= true)
	public void afterMethod() {
		System.out.println("This is After Method");
	}

}
