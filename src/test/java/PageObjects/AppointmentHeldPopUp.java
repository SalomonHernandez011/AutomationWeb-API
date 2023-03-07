package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class AppointmentHeldPopUp extends BasePageObject {

    private final SelenideElement iUnderstandButton = $("#edit-membership-cancel-button");
    private final SelenideElement backButton = $("#edit-membership-cancel-button");





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
