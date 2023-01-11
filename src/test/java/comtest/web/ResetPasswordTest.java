package comtest.web;

import PageObjects.EnterResetCodePage;
import PageObjects.ForgotYourPasswordPage;
import PageObjects.GetCareLandingPage;
import PageObjects.LogInPage;
import Util.GmailHandler;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;

public class ResetPasswordTest extends BaseWebTest {
    private LogInPage logInPage;
    private ForgotYourPasswordPage forgotYourPasswordPage;
    private GetCareLandingPage getCareLandingPage;
    private EnterResetCodePage enterResetCodePage;
    Faker faker = new Faker();
    private String invalidEmail = "notValidEmail";
    private String invalidPassword = "Abc@123!";
    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
    }

    @Test
    public void verifyForgotPasswordPage() throws IOException{
        selectForgotPassword();
    }

    private void selectForgotPassword() throws IOException{
        logInPage.selectResetPassword();
        forgotYourPasswordPage = new ForgotYourPasswordPage();
        forgotYourPasswordPage.setForgotEmail(ConfigFileReader.getProperty(USER_EMAIL));
        forgotYourPasswordPage.clickResetButton();
        enterResetCodePage = new EnterResetCodePage();
        Selenide.sleep(7000);
        enterResetCodePage.setResetCode(GmailHandler.getResetCode());
        TakeScreenshot("LogIn");
    }

}
