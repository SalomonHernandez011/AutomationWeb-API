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
        TakeScreenshot("BookVisit");
        getCareLandingPage.clickBookVisit();
        TakeScreenshot("BookVisit");
        bookVisitPage = new BookVisitPage();
        bookVisitPage.clickTravel();
        TakeScreenshot("BookVisit");
        bookVisitPage.clickBookVisit();
        bookVisitPage.clickDental();
        TakeScreenshot("BookVisit");
    }
}
