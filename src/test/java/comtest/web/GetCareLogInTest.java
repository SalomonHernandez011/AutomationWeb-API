package comtest.web;

import PageObjects.GetCareLandingPage;
import PageObjects.LogInPage;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;
import static constants.CommonTexts.INVALID_EMAIL;
import static constants.CommonTexts.PASSWORD_REQUIRED;
import static org.assertj.core.api.Assertions.assertThat;

public class GetCareLogInTest extends BaseWebTest {
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
    public void verifyGetCareLogInPage() {
        enterWrongEmail();
        passwordRequiredError();
        setCorrectCredentials();
        clickLogIn();
    }

    private void enterWrongEmail() {
        logInPage.setLoginEmail(invalidEmail);
        assertThat(logInPage.invalidEmailErrorMessage())
                .as("Error message is displayed", INVALID_EMAIL)
                .isTrue();
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is disabled")
                .isFalse();
        TakeScreenshot("LogIn");
    }

    private void passwordRequiredError() {
        logInPage.setPassword("a");
        assertThat(logInPage.passwordErrorMessage())
                .as("Error message is displayed", PASSWORD_REQUIRED)
                .isTrue();
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is disabled")
                .isFalse();
        TakeScreenshot("LogIn");
    }
    private void setCorrectCredentials() {
        logInPage.clearEmailField();
        logInPage.clearPasswordField();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@");
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is enabled")
                .isTrue();
        TakeScreenshot("LogIn");
    }
    private void clickLogIn() {
        logInPage.clickLogIn();
        Selenide.sleep(3000);
        TakeScreenshot("LogIn");
        getCareLandingPage = new GetCareLandingPage();
        TakeScreenshot("LogIn");
    }
}
