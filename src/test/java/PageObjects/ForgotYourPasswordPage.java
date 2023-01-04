package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class ForgotYourPasswordPage extends BasePageObject {
    private final SelenideElement forgotPasswordEmail = $("input[name='email']");
    private final SelenideElement resetButton = $("button[class*='btn-primary']");

    public ForgotYourPasswordPage() {
        assertTrue(isOpened(), "Forgot password Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(forgotPasswordEmail, resetButton);
    }

    public void setForgotEmail(String email){
        forgotPasswordEmail.setValue(email);
    }

    public void clickResetButton(){
        resetButton.click();
    }
}
