package comtest.web;

import PageObjects.BookVisitPage;
import PageObjects.GetCareLandingPage;
import PageObjects.LogInPage;
import PageObjects.WellnessPage;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;
import static org.assertj.core.api.Assertions.assertThat;

public class WellnessOptionsTest extends BaseWebTest {
    private LogInPage logInPage;
    private GetCareLandingPage getCareLandingPage;
    private BookVisitPage bookVisitPage;
    private WellnessPage wellnessPage;

    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@")
                .clickLogIn()
                .clickBookVisit()
                .clickWellnessOption();
    }

    @Test
    public void verifyWellnessPage() throws IOException {
        navigateToWellness();
    }

    private void navigateToWellness() throws IOException {
        wellnessPage = new WellnessPage();
        assertThat(wellnessPage.annualWellnessText())
                .as("text should match", "Annual wellness visit")
                .isEqualTo("Annual wellness visit");

        assertThat(wellnessPage.travelAnxietyText())
                .as("text should match", "Travel anxiety")
                .isEqualTo("Travel anxiety");

        assertThat(wellnessPage.vaccinationText())
                .as("text should match", "Vaccinations")
                .isEqualTo("Vaccinations");

        assertThat(wellnessPage.motionSicknessText())
                .as("text should match", "Motion sickness")
                .isEqualTo("Motion sickness");

        assertThat(wellnessPage.weightManagementText())
                .as("text should match", "Weight management")
                .isEqualTo("Weight management");

        assertThat(wellnessPage.behaviourIssuesText())
                .as("text should match", "Behavioral issues")
                .isEqualTo("Behavioral issues");

        assertThat(wellnessPage.separationAnxietyText())
                .as("text should match", "Separation anxiety")
                .isEqualTo("Separation anxiety");

        assertThat(wellnessPage.otherOnSiteText())
                .as("text should match", "Other Onsite services")
                .isEqualTo("Other Onsite services");
        TakeScreenshot("GetCare");
    }
}
