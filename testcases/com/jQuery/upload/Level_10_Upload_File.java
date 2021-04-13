package com.jQuery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;
import pageUIs.jQuery.HomePageUI;

public class Level_10_Upload_File extends BaseTest {

    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
//        pageGenerator = PageGeneratorManager.getPageGenerator();
        homePage = PageGeneratorManager.getHomePage(driver);

    }

    @Test
    public void Upload_01_One_File_Per_Time() {
        String[] fileNames = {"whale.jpg"};

        homePage.uploadFiles(fileNames);

        Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));

        homePage.clickToStartUploadButton();

        Assert.assertTrue(homePage.areFileUploadedSuccess(fileNames));
    }

    @Test
    public void Upload_02_Multiple_File_Per_Time() {
        homePage.refreshPage(driver);

        String[] fileNames = {"whale.jpg", "wolf.jpg", "snake.jpg"};

        homePage.uploadFiles(fileNames);

        Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));

        homePage.clickToStartUploadButton();

        Assert.assertTrue(homePage.areFileUploadedSuccess(fileNames));
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
