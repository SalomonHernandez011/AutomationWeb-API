package comtest.web;

import PageObjects.GetCareLandingPage;
import PageObjects.LogInPage;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonProperties.USER_EMAIL;
import static org.assertj.core.api.Assertions.assertThat;

public class GetCareTest extends BaseWebTest {
    private LogInPage logInPage;
    private GetCareLandingPage getCareLandingPage;
    Faker faker = new Faker();
    private String invalidEmail = "notValidEmail";
    private String invalidPassword = "Abc@123!";
    @BeforeMethod
    public void setup(){
        Selenide.open("https://qa.parkerandace.com/login");
        logInPage = new LogInPage();
    }

    @Test
    public void verifyLogInPage(){
        enterWrongEmail();
        passwordRequiredError();
        setCorrectCredentials();
        clickLogIn();
    }

    private void enterWrongEmail(){
        logInPage.setLoginEmail(invalidEmail);
        assertThat(logInPage.invalidEmailErrorMessage())
                .as("Error message is displayed")
                .isTrue();
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is disabled")
                .isFalse();
    }

    private void passwordRequiredError(){
        logInPage.setPassword("a");
        assertThat(logInPage.passwordErrorMessage())
                .as("Error message is displayed")
                .isTrue();
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is disabled")
                .isFalse();
    }
    private void setCorrectCredentials(){
        logInPage.clearEmailField();
        logInPage.clearPasswordField();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@");
        assertThat(logInPage.logInButtonEnabled())
                .as("Button is enabled")
                .isTrue();
    }
    private void clickLogIn(){
        logInPage.clickLogIn();
        Selenide.sleep(3000);
        getCareLandingPage = new GetCareLandingPage();
    }
}
