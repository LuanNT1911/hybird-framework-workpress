package com.jQuery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

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
        String[] file = {"whale11.jpg"};

        log.info("Upload a file- Step 01: Upload a file to UI");
        homePage.uploadFiles(fileNames);

        log.info("Upload a file: Step 02: Verify file is loaded to UI");
        verifyTrue(homePage.areFilenameLoadedSuccess(file));

        log.info("Upload a file: Step 03: Click Start Upload button");
        homePage.clickToStartUploadButton();

        log.info("Upload a file: Step 04: Verify file is uploaded to server");
        verifyTrue(homePage.areFileUploadedSuccess(fileNames));
    }

    @Test
    public void Upload_02_Multiple_File_Per_Time() {
        log.info("Upload multiple files- Step 00: Refresh the page");
        homePage.refreshPage(driver);

        String[] fileNames = {"whale.jpg", "wolf.jpg", "snake.jpg"};

        log.info("Upload multiple files- Step 01: Upload multiple files to UI");
        homePage.uploadFiles(fileNames);

        log.info("Upload multiple files: Step 02: Verify files are loaded to UI");
        verifyTrue(homePage.areFilenameLoadedSuccess(fileNames));

        log.info("Upload multiple files: Step 03: Click Start Upload button");
        homePage.clickToStartUploadButton();

        log.info("Upload multiple files: Step 04: Verify files are uploaded to server");
        verifyTrue(homePage.areFileUploadedSuccess(fileNames));
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
