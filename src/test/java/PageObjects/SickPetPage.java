package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class SickPetPage extends BasePageObject {
    private final SelenideElement sickImage = $x("//img");
    private final SelenideElement sickButton = $("#almayp-continue-button");
    public SickPetPage() {
        assertTrue(isOpened(), "Registered Sick Pet Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(sickImage, sickButton);
    }

    public void clickSickButton(){
        sickButton.click();
    }
}
