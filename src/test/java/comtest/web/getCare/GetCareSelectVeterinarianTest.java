package comtest.web.getCare;

import PageObjects.*;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;
import static org.assertj.core.api.Assertions.assertThat;

public class GetCareSelectVeterinarianTest extends BaseWebTest {
    private LogInPage logInPage;
    private GetCareLandingPage getCareLandingPage;
    private BookVisitPage bookVisitPage;
    private WellnessPage wellnessPage;
    private AnnualVisitPage AnnualVisitPage;

    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@")
                .clickLogIn();
        getCareLandingPage = new GetCareLandingPage();
        getCareLandingPage.clickBookVisit();
        bookVisitPage = new BookVisitPage();
        bookVisitPage.clickWellnessOption();
        wellnessPage = new WellnessPage();
        wellnessPage.clickAnnualWellNessVisit();
        TakeScreenshot("WellnessAnnualVisit");
    }

    @Test
    public void verifyBookVisitPage(){
        reviewAnnualWellnessPage();
    }

    private void reviewAnnualWellnessPage(){
        AnnualVisitPage = new AnnualVisitPage();
        assertThat(AnnualVisitPage.wellnessVeterinarianText())
                .as("Text Should Match", "Select veterinarian")
                .isEqualTo("Select veterinarian");

        assertThat(AnnualVisitPage.subVeterinarianPageText())
                .as("Text Should Match", "To find the location nearest to you, please enter your zip code or enable location services on your device.")
                .isEqualTo("To find the location nearest to you, please enter your zip code or enable location services on your device.");

        assertThat(AnnualVisitPage.allAvailableText())
                .as("Text Should Match", "All availability:")
                .isEqualTo("All availability:");

        assertThat(AnnualVisitPage.bottomImagePresent())
                .as("Image should be visible")
                        .isTrue();
        TakeScreenshot("WellnessAnnualVisit");
    }
}
