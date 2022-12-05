package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class LogInPage extends BasePageObject {

    private final SelenideElement logInButton = $("button[type='submit']");
    private final SelenideElement userEmail = $("input[name='USERNAME']");
    private final SelenideElement userPassword = $("input[name='PASSWORD']");

    public LogInPage() {
        assertTrue(isOpened(), "LogIn Page is opened");
    }

    public boolean isOpened() {
        isElementDisplayed(userEmail);
        isElementDisplayed(userPassword);
        return isPageObjectLoaded(logInButton, userEmail);
    }
}
