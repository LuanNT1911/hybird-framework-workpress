package com.nopCommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

import java.util.concurrent.TimeUnit;

public class Level_3_Login_Page_Object {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_01_Register_To_System() {
		homePage.clickToResgisterLink();

		registerPage = new RegisterPageObject(driver);
//		registerPage.sleepInSeconds(2);
		registerPage.inputToFirstNameTextbox("Earn");
		registerPage.inputToLastNameTextbox("Shaw");
		registerPage.inputToEmailTextbox("earnshaw@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		registerPage.clickToLogoutLink(driver);

		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_02_Login_To_System() {
		homePage.clickToLoginLink(driver);

		loginPage = new LoginPageObject(driver);
		loginPage.sleepInSeconds(2);
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
