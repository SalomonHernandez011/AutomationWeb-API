package comtest.web;

import PageObjects.BookVisitPage;
import PageObjects.GetCareLandingPage;
import PageObjects.LogInPage;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;
import static constants.CommonTexts.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BookVisitTest extends BaseWebTest {
    private LogInPage logInPage;
    private GetCareLandingPage getCareLandingPage;
    private BookVisitPage bookVisitPage;

    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@")
                .clickLogIn();
    }

    @Test
    public void verifyBookVisitPage(){
        navigateToBookVisit();
    }

    private void navigateToBookVisit(){
        getCareLandingPage = new GetCareLandingPage();
        getCareLandingPage.clickBookVisit();
        bookVisitPage = new BookVisitPage();
        TakeScreenshot("BookVisit");

        assertThat(bookVisitPage.getWellnessText())
                .as("Text should match", BOOKVISIT_WELLNESS.getCommonTexts())
                .isEqualTo(BOOKVISIT_WELLNESS.getCommonTexts());

        assertThat(bookVisitPage.getWellnessSubText())
                .as("Text should match", BOOKVISIT_WELLNESS_SUBTEXT.getCommonTexts())
                .isEqualTo(BOOKVISIT_WELLNESS_SUBTEXT.getCommonTexts());

        assertThat(bookVisitPage.getSickText())
                .as("Text should match", BOOKVISIT_SICK.getCommonTexts())
                .isEqualTo(BOOKVISIT_SICK.getCommonTexts());

        assertThat(bookVisitPage.getSickSubText())
                .as("Text should match", BOOKVISIT_SICK_SUBTEXT.getCommonTexts())
                .isEqualTo(BOOKVISIT_SICK_SUBTEXT.getCommonTexts());

        assertThat(bookVisitPage.getTravelText())
                .as("Text should match", BOOKVISIT_TRAVEL.getCommonTexts())
                .isEqualTo(BOOKVISIT_TRAVEL.getCommonTexts());

        assertThat(bookVisitPage.getTravelSubText())
                .as("Text should match", BOOKVISIT_TRAVEL_SUBTEXT.getCommonTexts())
                .isEqualTo(BOOKVISIT_TRAVEL_SUBTEXT.getCommonTexts());

        assertThat(bookVisitPage.getSpayNeuterText())
                .as("Text should match", BOOKVISIT_SPAYNEUTER.getCommonTexts())
                .isEqualTo(BOOKVISIT_SPAYNEUTER.getCommonTexts());

        assertThat(bookVisitPage.getSpayNeuterSubText())
                .as("Text should match", BOOKVISIT_SPAYNEUTER_SUBTEXT.getCommonTexts())
                .isEqualTo(BOOKVISIT_SPAYNEUTER_SUBTEXT.getCommonTexts());

        assertThat(bookVisitPage.getDentalText())
                .as("Text should match", BOOKVISIT_DENTAL.getCommonTexts())
                .isEqualTo(BOOKVISIT_DENTAL.getCommonTexts());

        assertThat(bookVisitPage.getDentalSubText())
                .as("Text should match", BOOKVISIT_DENTAL_SUBTEXT.getCommonTexts())
                .isEqualTo(BOOKVISIT_DENTAL_SUBTEXT.getCommonTexts());

        assertThat(bookVisitPage.getOtherText())
                .as("Text should match", BOOKVISIT_OTHER.getCommonTexts())
                .isEqualTo(BOOKVISIT_OTHER.getCommonTexts());

        assertThat(bookVisitPage.getOtherSubText())
                .as("Text should match", BOOKVISIT_OTHER_SUBTEXT.getCommonTexts())
                .isEqualTo(BOOKVISIT_OTHER_SUBTEXT.getCommonTexts());

        assertThat(bookVisitPage.imgPresent())
                .as("should be displayed")
                .isTrue();
        TakeScreenshot("BookVisit");
    }
}
