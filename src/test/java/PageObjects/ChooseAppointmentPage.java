package PageObjects;

import comtest.BasePageObject;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ChooseAppointmentPage extends BasePageObject {

    private final SelenideElement healthyOption = $("#option-healthy");
    private final SelenideElement chooseContinue = $("#cap-continue-button");
    private final SelenideElement sickOption = $("#option-sick");
    private final SelenideElement datePicker = $(".container-date-picker");
    public ChooseAppointmentPage() {
        assertTrue(isOpened(), "Landing Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(healthyOption, chooseContinue);
    }
}
