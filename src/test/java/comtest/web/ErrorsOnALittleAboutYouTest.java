package comtest.web;

import PageObjects.ALittleAboutYouPage;
import PageObjects.LandingPage;
import PageObjects.LocationPage;
import comtest.BaseWebTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ErrorsOnALittleAboutYouTest extends BaseWebTest {
    private LandingPage landingPage;
    private LocationPage locationPage;
    private ALittleAboutYouPage aLittleAboutYouPage;
    private final String errorEmailText = "invalid email address";
    @BeforeMethod
    public void setup(){
        landingPage = new LandingPage();
        landingPage.clickNext();
        landingPage.clickThirdOption();
        locationPage = landingPage.getStartedSelect()
                .clearZipField()
                .setTextToZip("20002");
       locationPage.clickLocationCard()
               .clickNotAnEmergency();
        aLittleAboutYouPage = new ALittleAboutYouPage();
    }

    @Test
    public void verifyErrorsOnALittleAboutYouPage(){
        invalidEmail();
    }
    private void invalidEmail() {
        aLittleAboutYouPage.setUserEmail("invalid email");
        assertThat(aLittleAboutYouPage.errorEmailMsg())
                .as("Error Text Should Match", errorEmailText)
                .containsIgnoringCase(errorEmailText);
    }
}
