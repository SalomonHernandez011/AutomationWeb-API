package comtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dataProvider.ConfigFileReader;


import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    }
}
