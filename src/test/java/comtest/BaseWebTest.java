package comtest;

import Util.BrowserOptions;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static constants.CommonProperties.PROVET_URL;
import static constants.CommonProperties.URL;
public class BaseWebTest {
    ConfigFileReader configFileReader;
    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        Configuration.browserCapabilities = BrowserOptions.getChromeOptions();
        configFileReader = new ConfigFileReader();
        Selenide.open(ConfigFileReader.getProperty(URL));
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    public void openProVetBrowser(){
        WebDriverRunner.getWebDriver().quit();
        ChromeOptions options = new ChromeOptions()
                .addArguments("--lang=en-US")
                .addArguments("--disable-geolocation")
                .addArguments("--incognito")
                .addArguments("--deny-permission-prompts");
        Configuration.browserCapabilities = options;
        Selenide.open(ConfigFileReader.getProperty(PROVET_URL));
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    public static void TakeScreenshot(String folderName){
        Shutterbug.shootPage(WebDriverRunner.getWebDriver(), Capture.FULL_SCROLL, true).save(".\\screenshots\\"+folderName+"_"+LocalDate.now()+"\\");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
    }
}
