package comtest;

import constants.CommonProperties;
import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseMobileTest {

    public WebDriver driver;
    public static final String USERNAME = "derekmoore_XagfzT";
    public static final String AUTOMATE_KEY = "17akuxoZzzczxsFvyWqL";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @BeforeSuite
    public void setUp() {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browsername", "ios");
        caps.setCapability("device", "iPhone 14 Pro Max");
        caps.setCapability("realMobile", true);
        caps.setCapability("osVersion", "16");
        caps.setCapability("browserstack.debug", true);

        try {
            WebDriverManager.chromedriver().setup();
            caps.setCapability("browser", "Chrome");
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(ConfigFileReader.getProperty(CommonProperties.URL));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
