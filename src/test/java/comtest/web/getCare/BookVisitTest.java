package comtest.web.getCare;

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

        assertThat(bookVisitPage.bookVisitTitlesText(BOOKVISIT_WELLNESS))
                .as("Text should match", BOOKVISIT_WELLNESS.getCommonTexts())
                .isTrue();

        assertThat(bookVisitPage.bookVisitSubTitlesText(BOOKVISIT_WELLNESS_SUBTEXT))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitTitlesText(BOOKVISIT_SICK))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitSubTitlesText(BOOKVISIT_SICK_SUBTEXT))
                .as("Text should match", BOOKVISIT_SICK_SUBTEXT.getCommonTexts())
                .isTrue();

        assertThat(bookVisitPage.bookVisitTitlesText(BOOKVISIT_TRAVEL))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitSubTitlesText(BOOKVISIT_TRAVEL_SUBTEXT))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitTitlesText(BOOKVISIT_SPAYNEUTER))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitSubTitlesText(BOOKVISIT_SPAYNEUTER_SUBTEXT))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitTitlesText(BOOKVISIT_DENTAL))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitSubTitlesText(BOOKVISIT_DENTAL_SUBTEXT))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitTitlesText(BOOKVISIT_OTHER))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.bookVisitSubTitlesText(BOOKVISIT_OTHER_SUBTEXT))
                .as("Text should match")
                .isTrue();

        assertThat(bookVisitPage.imgPresent())
                .as("should be displayed")
                .isTrue();
        TakeScreenshot("BookVisit");
    }
}
