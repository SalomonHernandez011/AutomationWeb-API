package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class AppointmentHeldPopUp extends BasePageObject {

    private final SelenideElement iUnderstandButton = $("button[class='btn btn-primary-rounded btn-undefined undefined']");
    private final SelenideElement backButton = $("button[class='btn btn-secondary btn-undefined undefined']");





    public AppointmentHeldPopUp() {
        assertTrue(isOpened(), "Appointment held popup is open");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(iUnderstandButton, backButton);
    }

    public void clickUnderstand(){
        iUnderstandButton.click();
    }

    public void selectBackButton(){
        backButton.click();
    }
}
