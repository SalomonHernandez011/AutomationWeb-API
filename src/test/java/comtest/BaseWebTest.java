package comtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import dataProvider.ConfigFileReader;

import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;

import static com.codeborne.selenide.Selenide.screenshot;
import static constants.CommonProperties.URL;

public class BaseWebTest {

    ConfigFileReader configFileReader;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
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

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
        Configuration.reportsFolder = "test-result/reports";
    }
}
