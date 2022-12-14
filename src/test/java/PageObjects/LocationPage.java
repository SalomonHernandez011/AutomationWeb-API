package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class LocationPage extends BasePageObject {

    private final SelenideElement locationText = $("div[class^='highway-9']");
    private final SelenideElement zipInput = $("#slp-zip-code-input");
    private final SelenideElement locationCard = $("#location-image-1");
    private final SelenideElement insLocText = $("div[class$='subtext']");
    private final SelenideElement zipText = $("span[class$='description-block']");


    public LocationPage() {
        assertTrue(isOpened(), "Registration Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(locationText, zipInput);
    }

    public LocationPage setTextToZip(String zip){
        zipInput.setValue(zip);
        return this;
    }

    public boolean locationCard(){
        waitUntilElementCondition(locationCard, Condition.visible, longWait);
        return locationCard.isDisplayed();
    }

    public LocationPage clearZipField(){
        zipInput.sendKeys(Keys.CONTROL + "a");
        zipInput.sendKeys(Keys.DELETE);
        return this;
    }

    public IsThisAnEmergencyPopUp clickLocationCard(){
        locationCard.click();
        return new IsThisAnEmergencyPopUp();
    }

    public String subLocText(){
        return insLocText.getText();
    }

    public String subZipText(){
        return zipText.getText();
    }


}
