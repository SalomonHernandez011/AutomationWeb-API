package comtest;

import Util.AllureScreenShooter;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import dataProvider.ConfigFileReader;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

import static constants.CommonProperties.URL;
@Listeners(AllureScreenShooter.class)
public class BaseWebTest {

    ConfigFileReader configFileReader;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
//        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        ChromeOptions options = new ChromeOptions()
                .addArguments("--lang=en-US")
                .addArguments("--disable-geolocation")
                .addArguments("--incognito")
                .addArguments("--deny-permission-prompts");
        Configuration.browserCapabilities = options;
        configFileReader = new ConfigFileReader();
        Selenide.open(ConfigFileReader.getProperty(URL));
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }
    public static void TakeScreenshot(String FileName) throws IOException {
        TakesScreenshot Sc = (TakesScreenshot)WebDriverRunner.getWebDriver();
        File SourceImg = Sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SourceImg, new File("C:\\Users\\Salomon\\Pictures\\Screenshots\\"+FileName+".png"));
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
    }
}
