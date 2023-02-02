package comtest.web.getCare;

import PageObjects.*;
import com.codeborne.selenide.Selenide;
import com.twilio.Twilio;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;

public class LogOutTest extends BaseWebTest {
    private LogInPage logInPage;
    private GetCareLandingPage getCareLandingPage;
    private NavigationMenu navigationMenu;
    private SettingsSectionPage settingsSectionPage;

    @BeforeMethod
    public void setup() {
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
    logInPage = new LogInPage();
    logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
            .setPassword("1234asdF@")
            .clickLogIn();
    getCareLandingPage = new GetCareLandingPage();
    navigationMenu = new NavigationMenu();
    navigationMenu.clickSettings();
    settingsSectionPage = new SettingsSectionPage();
        TakeScreenshot("LogOut");
    }

    @Test
    public void verifyOnBoardingFlowPage() {
        logOut();
    }

    private void logOut(){
        settingsSectionPage.clickLogOut();
        TakeScreenshot("LogOut");
    }
}