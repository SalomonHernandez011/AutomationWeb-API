package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class SignUpPage extends BasePageObject {
    private final SelenideElement userEmail = $("input[name='email']");
    private final SelenideElement userPassword = $("input[name='password']");
    private final SelenideElement signUpButton = $("button[type='submit']");
    public SignUpPage() {
        assertTrue(isOpened(), "SignUp Page is opened");
    }

    public boolean isOpened() {
        isElementDisplayed(userEmail);
        isElementDisplayed(userPassword);
        return isPageObjectLoaded(signUpButton, userEmail);
    }
}
