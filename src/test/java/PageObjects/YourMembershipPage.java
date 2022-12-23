package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class YourMembershipPage extends BasePageObject {
    private final SelenideElement billingInfo = $("div[class='bill default']");
    private final SelenideElement billingContinue = $("#mpp-continue-button");
    private final SelenideElement billingTimer = $("div[class='time-remaining']");

    public YourMembershipPage() {
        assertTrue(isOpened(), "Your Membership Page is opened");
    }

    public boolean isOpened() {
        isElementDisplayed(billingTimer);
        return isPageObjectLoaded(billingInfo, billingContinue);
    }

    public void continueToPayment(){
        billingContinue.click();
    }
}
