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
import java.time.LocalDate;

import static constants.CommonProperties.*;
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
    public void verifyLogInPage() throws IOException {
        enterWrongEmail();
        passwordRequiredError();
        setCorrectCredentials();
        clickLogIn();
    }

    private void enterWrongEmail() throws IOException {
        logInPage.setLoginEmail(invalidEmail);
        assertThat(logInPage.invalidEmailErrorMessage())
                .as("Error message is displayed", INVALID_EMAIL)
                .isTrue();
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is disabled")
                .isFalse();
        TakeScreenshot("WrongEmail"+ LocalDate.now());
    }

    private void passwordRequiredError() throws IOException {
        logInPage.setPassword("a");
        assertThat(logInPage.passwordErrorMessage())
                .as("Error message is displayed", PASSWORD_REQUIRED)
                .isTrue();
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is disabled")
                .isFalse();
        TakeScreenshot("PasswordIsRequired"+LocalDate.now());
    }
    private void setCorrectCredentials() throws IOException {
        logInPage.clearEmailField();
        logInPage.clearPasswordField();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@");
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is enabled")
                .isTrue();
        TakeScreenshot("ButtonIsEnabled"+LocalDate.now());
    }
    private void clickLogIn() throws IOException {
        logInPage.clickLogIn();
        Selenide.sleep(3000);
        getCareLandingPage = new GetCareLandingPage();
        TakeScreenshot("GetCarePageIsDisplayed"+LocalDate.now());
    }
}
