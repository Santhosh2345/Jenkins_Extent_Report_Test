package com.jenkins_Test;

import org.projectSpecific.base.ProjectSpecificMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jenkins.Extent_Report_Checking_For_Jenkins;

public class Extent_Report_Checking_For_Jenkins_Test extends ProjectSpecificMethods{

	
	@BeforeTest
	public void setValues() {
		testCaseName = "F_01_01 Launching Website";
		category = "Smoke";
		authors = "Santhosh";
	}
	
	@Test
	public void launching_Website() throws InterruptedException {
		node = test.createNode("F_01_01 Launching Website");
		extent.attachReporter(spark);
		Extent_Report_Checking_For_Jenkins a = new Extent_Report_Checking_For_Jenkins(driver, node, prop, Environment, StageURL, Stage1URL);
		a.launchWebsite();
		a.navigateTo_Another_Website();
	}
}
