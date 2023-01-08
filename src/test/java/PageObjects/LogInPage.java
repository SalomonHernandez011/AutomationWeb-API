package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class LogInPage extends BasePageObject {

    private final SelenideElement logInButton = $("button[class*='btn-primary']");
    private final SelenideElement userEmail = $("input[name='USERNAME']");
    private final SelenideElement userPassword = $("input[name='PASSWORD']");
    private final SelenideElement passwordErrorMessage = $x("//*[contains(text(),'password is required')]");
    private final SelenideElement emailErrorMessage = $x("//*[contains(text(),'Invalid email address')]");
    private final SelenideElement forgotPasswordLink = $x("//a[@href='/fogot-password']");

    public LogInPage() {
        assertTrue(isOpened(), "LogIn Page is opened");
    }

    public boolean isOpened() {
        isElementDisplayed(userEmail);
        isElementDisplayed(userPassword);
        return isPageObjectLoaded(logInButton, userEmail);
    }

    public LogInPage setLoginEmail(String email){
        userEmail.setValue(email);
        return this;
    }

    public LogInPage setPassword(String password){
        userPassword.setValue(password);
        return this;
    }

    public GetCareLandingPage clickLogIn(){
        logInButton.click();
        return new GetCareLandingPage();
    }

    public boolean passwordErrorMessage(){
     return passwordErrorMessage.isDisplayed();
    }

    public boolean invalidEmailErrorMessage(){
        return emailErrorMessage.isDisplayed();
    }

    public boolean logInButtonEnabled(){
        return logInButton.isEnabled();
    }
    public void clearEmailField(){
            sendSelectAllKeys(userEmail);
        userEmail.sendKeys(Keys.DELETE);
    }
    public void clearPasswordField(){
        sendSelectAllKeys(userPassword);
        userPassword.sendKeys(Keys.DELETE);
    }
    public void selectResetPassword(){
        forgotPasswordLink.click();
    }


}
