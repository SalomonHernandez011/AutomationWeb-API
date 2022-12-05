package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class RegistrationPage extends BasePageObject {

    private final SelenideElement locationText = $("div[class^='highway-9']");
    private final SelenideElement zipInput = $("#slp-zip-code-input");
    private final SelenideElement locationCard = $("#location-image-1");


    public RegistrationPage() {
        assertTrue(isOpened(), "Landing Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(locationText, zipInput);
    }

    public RegistrationPage setTextToZip(String zip){
        zipInput.setValue(zip);
        return this;
    }

    public boolean locationCard(){
        waitUntilElementCondition(locationCard, Condition.visible, longWait);
        return locationCard.isDisplayed();
    }

    public RegistrationPage clearZipField(){
        zipInput.sendKeys(Keys.CONTROL + "a");
        zipInput.sendKeys(Keys.DELETE);
        return this;
    }

    public IsThisAnEmergencyPopUp clickLocationCard(){
        locationCard.click();
        return new IsThisAnEmergencyPopUp();
    }


}
