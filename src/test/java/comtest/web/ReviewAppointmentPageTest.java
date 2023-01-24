package comtest.web;

import PageObjects.AppointmentPage;
import PageObjects.LogInPage;
import PageObjects.NavigationMenu;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;
import static org.assertj.core.api.Assertions.assertThat;

public class ReviewAppointmentPageTest extends BaseWebTest {
    private LogInPage logInPage;
    private NavigationMenu navigationMenu;
    private AppointmentPage appointmentPage;

    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@")
                .clickLogIn();
        navigationMenu = new NavigationMenu();
        navigationMenu.clickAppointment();
        appointmentPage = new AppointmentPage();
    }

    @Test
    public void verifyAppointmentPage() {
        navigateToAppointments();
    }

    private void navigateToAppointments() {

        assertThat(appointmentPage.topImagePresent())
                .as("Image should be present")
                .isTrue();

        TakeScreenshot("Appointments");
        assertThat(appointmentPage.welcomeText())
                .as("Title should match", "Appointments")
                .isEqualTo("Appointments");

        assertThat(appointmentPage.appointmentTitleText())
                .as("Text should match", "Upcoming appointments")
                .isEqualTo("Upcoming appointments");

        assertThat(appointmentPage.pastAppointmentText())
                .as("Text should match", "Past Appointments")
                .isEqualTo("Past Appointments");

        assertThat(appointmentPage.imagePresent())
                .as("Image should be present")
                .isTrue();
        TakeScreenshot("Appointments");
    }
}
