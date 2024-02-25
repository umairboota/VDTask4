package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.pages.taskFourPage;
import com.qa.base.TestBase;


public class TaskFourTests extends TestBase {
	
	taskFourPage taskFour;
	
	public TaskFourTests() {
		super();
	}

	@BeforeClass
	public void setUp() {
		intialization();
		taskFour = new taskFourPage();
		
	}
	
	@Test(priority = 1)
	public void pageTitleNameTest() {
		String title = taskFour.validatePageTitle();
		Assert.assertEquals(title, "A place to practice your automation skills!");
	}
	
	@Test(priority = 2)
	public void scenario_one() {

		taskFour.clickManueButton();
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		taskFour.enterUsername_task4(username);
		taskFour.enterPassword_task4(password);

		taskFour.clickLoginButton_task4();
		
		taskFour.clickHomeButton_task4();

		taskFour.clickBrandNameButton_task4();

		String option = "Date New > Old";

		taskFour.selectOptionFromDropdown(option);

		taskFour.clickAddtoCart();
		
		taskFour.gotTocart();

	}
	
	@Test (priority = 2)
	public void scenario_two() {
		taskFour.gotToapparals();
		taskFour.goToTshirtSection();
		
		String option = "Price Low > High";

		taskFour.selectOptionFromDropdown(option);
		taskFour.clickGoAddtoCartShirt();
		taskFour.clickAddtoCartShirt();
		
////		adding shoes
		taskFour.gotToapparals();
		taskFour.clicktoShoes();
		String optionShoes = "Price High > Low";

		taskFour.selectOptionFromDropdown(optionShoes);
		taskFour.clickGoToCartshoes();
		taskFour.enterQuntity();
		taskFour.clickAddtoCart();
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
