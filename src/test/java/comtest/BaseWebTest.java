package comtest;

import Util.AllureScreenShooter;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static constants.CommonProperties.URL;
@Listeners(AllureScreenShooter.class)
public class BaseWebTest {

    ConfigFileReader configFileReader;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
//        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 390);
        deviceMetrics.put("height", 844);
        deviceMetrics.put("pixelRatio", 1.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 11; Pixel 5 Build/RQ3A.210805.001.A1; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/92.0.4515.159 Mobile Safari/537.36");
        ChromeOptions options = new ChromeOptions()
                .setExperimentalOption("mobileEmulation", mobileEmulation)
                .addArguments("--lang=en-US")
                .addArguments("--disable-geolocation")
                .addArguments("--incognito")
                .addArguments("--deny-permission-prompts");
        Configuration.browserCapabilities = options;
        configFileReader = new ConfigFileReader();
        Selenide.open(ConfigFileReader.getProperty(URL));
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }
    public static void TakeScreenshot(String folderName){
//        TakesScreenshot Sc = (TakesScreenshot)WebDriverRunner.getWebDriver();
//        File SourceImg = Sc.getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(SourceImg, new File(".\\screenshots\\"+folderName+"_"+LocalDate.now()+"\\" + FileName + ".png"));
        Shutterbug.shootPage(WebDriverRunner.getWebDriver(), Capture.FULL_SCROLL, false).save(".\\screenshots\\"+folderName+"_"+LocalDate.now()+"\\");
    }



    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
    }
}
