package comtest.web;

import PageObjects.GetCareLandingPage;
import PageObjects.LogInPage;
import Util.GmailHandler;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;

public class ResetPassword extends BaseWebTest {
    private LogInPage logInPage;
    private GetCareLandingPage getCareLandingPage;
    Faker faker = new Faker();
    private String invalidEmail = "notValidEmail";
    private String invalidPassword = "Abc@123!";
    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
    }

    @Test
    public void verifyLogInPage() throws IOException, GeneralSecurityException {
        selectForgotPassword();
    }

    private void selectForgotPassword() throws IOException, GeneralSecurityException {
        logInPage.selectResetPassword();
        logInPage.setForgotEmail(ConfigFileReader.getProperty(USER_EMAIL));
        logInPage.clickResetButton();
        Selenide.sleep(4000);
        logInPage.setResetCode(GmailHandler.getResetCode());
        TakeScreenshot("ResetPasswordCode"+ LocalDate.now());
    }

}
