package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class DidYouGetOurTextPage extends BasePageObject {
    private final SelenideElement smsTextCode = $("#dygotp-sms-code-input");
    private final SelenideElement smsContinue = $("#dygot-send-again-button");
    private final SelenideElement timeRemaining = $("div[class='time-remaining']");

    public DidYouGetOurTextPage() {
        assertTrue(isOpened(), "Landing Page is opened");
    }

    public boolean isOpened() {
        isElementDisplayed(timeRemaining);
        return isPageObjectLoaded(smsTextCode, smsContinue);
    }

    public DidYouGetOurTextPage setSmsCode(String sms){
        smsTextCode.setValue(sms);
        return this;
    }

    public void clickContinueSMS(){
        smsContinue.click();
    }
}
