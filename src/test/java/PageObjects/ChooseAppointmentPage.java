package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import comtest.BasePageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class ChooseAppointmentPage extends BasePageObject {

    private final SelenideElement healthyOption = $("#option-healthy-feeling");
    private final SelenideElement chooseContinue = $("#cap-continue-button");
    private final SelenideElement sickOption = $("#option-sick");
    private final ElementsCollection datePicker = $$x("//div[starts-with(@id,'calendar-day')]");
    private final SelenideElement timePicker = $x("//div[starts-with(@id,'time-picker')]");

    private final SelenideElement noAppoinemtn = $("div[class*='text-sm']");
    private final SelenideElement appointmentContinue = $("#cap-continue-button");
    public ChooseAppointmentPage() {
        assertTrue(isOpened(), "Appointment screen is open");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(healthyOption, chooseContinue);
    }

    public List<String> getAppointmentOptions() {
        List<String> options = new ArrayList<>();
        for (int i = 0; i < datePicker.size(); i++) {
            options.add(datePicker.get(i).getText());
            datePicker.get(i).click();
        }
        return options;
    }

    public ElementsCollection getAppointmentCollection(){
        return datePicker;
    }

    public ChooseAppointmentPage setAppointment(){
        timePicker.click();
        return this;
    }

    public boolean noAppointmentDisplayed(){
    waitUntilElementCondition(noAppoinemtn, Condition.visible, shortWait);
    return noAppoinemtn.isDisplayed();
    }

    public void continueAppointment(){
        appointmentContinue.click();
    }
}
