package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class CreatePasswordPage extends BasePageObject {

    private final SelenideElement setPassword = $("#cpp-password-input");
    private final SelenideElement confirmPassword = $("#cpp-repeated-password-input");
    private final SelenideElement continueButton = $("#cpp-continue-button");
    public CreatePasswordPage() {
        assertTrue(isOpened(), "A Little More About You Page is open");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(setPassword, confirmPassword);
    }

    public CreatePasswordPage setPassword(String pass){
        setPassword.setValue(pass);
        return this;
    }

    public CreatePasswordPage confirmPassword(String pass){
        confirmPassword.setValue(pass);
        return this;
    }

    public void nextPageContinue(){
        continueButton.click();
    }

}
