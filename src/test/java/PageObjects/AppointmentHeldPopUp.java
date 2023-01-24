package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class AppointmentHeldPopUp extends BasePageObject {

    private final SelenideElement iUnderstandButton = $x("//button[@id='edit-membership-cancel-button' and text()='i understand']");
    private final SelenideElement backButton = $x("//button[@id='edit-membership-cancel-button' and text()='back']");





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
