package comtest.web;

import PageObjects.LogInPage;
import PageObjects.NavigationMenu;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;

public class ReviewAppointmentPageTest extends BaseWebTest {
    private LogInPage logInPage;
    private NavigationMenu navigationMenu;

    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@")
                .clickLogIn();
    }

    @Test
    public void verifyAppointmentPage() throws IOException {
        navigateToAppointments();
    }

    private void navigateToAppointments() throws IOException {
        navigationMenu = new NavigationMenu();
        navigationMenu.clickAppointment();
        TakeScreenshot("Appointments");
    }
}
