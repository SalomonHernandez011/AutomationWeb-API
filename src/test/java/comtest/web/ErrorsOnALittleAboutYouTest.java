package comtest.web;

import PageObjects.ALittleAboutYouPage;
import PageObjects.LandingPage;
import PageObjects.RegistrationPage;
import comtest.BaseWebTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ErrorsOnALittleAboutYouTest extends BaseWebTest {
    private LandingPage landingPage;
    private RegistrationPage registrationPage;
    private ALittleAboutYouPage aLittleAboutYouPage;
    private final String errorEmailText = "invalid email address";
    @BeforeMethod
    public void setup(){
        landingPage = new LandingPage();
        landingPage.clickNext();
        landingPage.clickThirdOption();
        registrationPage = landingPage.getStartedSelect()
                .clearZipField()
                .setTextToZip("20002");
       registrationPage.clickLocationCard()
               .clickNotAnEmergency();
        aLittleAboutYouPage = new ALittleAboutYouPage();
    }

    @Test
    public void verifyLandingPage(){
        invalidEmail();

    }

    private void invalidEmail() {
        aLittleAboutYouPage.setUserEmail("invalid email");
        assertThat(aLittleAboutYouPage.errorEmailMsg())
                .as("Error Text Should Match", errorEmailText)
                .containsIgnoringCase(errorEmailText);
    }
}
