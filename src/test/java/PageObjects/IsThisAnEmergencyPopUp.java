package PageObjects;

import comtest.BasePageObject;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class IsThisAnEmergencyPopUp extends BasePageObject {
    private final SelenideElement notAnEmergencyButton = $("button[class^='btn-not-emergency']");
    private final SelenideElement emergencyIcon = $("div[class='icon-urgent-emergency']");
    public IsThisAnEmergencyPopUp() {
        assertTrue(isOpened(), "Landing Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(notAnEmergencyButton, emergencyIcon);
    }

    public ALittleAboutYouPage clickNotAnEmergency(){
        notAnEmergencyButton.click();
        return new ALittleAboutYouPage();
    }
}
