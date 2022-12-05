package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordPage extends BasePageObject {

    private final SelenideElement userEmail = $("input[name='email']");
    private final SelenideElement resetPasswordButton = $("button[type='submit']");
    private final SelenideElement pageTitle = $("div[class$='title']");
    public ForgotPasswordPage() {
        assertTrue(isOpened(), "ForgotPassword Page is opened");
    }

    public boolean isOpened() {
        isElementDisplayed(userEmail);
        return isPageObjectLoaded(resetPasswordButton, userEmail);
    }
}
