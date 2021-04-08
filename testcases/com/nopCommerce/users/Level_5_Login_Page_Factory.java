package com.nopCommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.nopcommerce.HomePageObject;
import pageFactory.nopcommerce.LoginPageObject;
import pageFactory.nopcommerce.RegisterPageObject;

import java.util.concurrent.TimeUnit;

public class Level_5_Login_Page_Factory extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		homePage = new HomePageObject(driver);
	}


	public void User_01_Register_To_System() {
		homePage.clickToResgisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.sleepInSeconds(2);
		registerPage.inputToFirstNameTextbox("Earn");
		registerPage.inputToLastNameTextbox("Shaw");
		registerPage.inputToEmailTextbox("earnshaw@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		registerPage.clickToLogoutLink();

		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_02_Login_To_System() {
		homePage.clickToResgisterLink();

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
//		loginPage.sleepInSeconds(2);
		loginPage.isBeingLoginPage();
		loginPage.inputToEmailTextbox("earnshaw@gmail.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
