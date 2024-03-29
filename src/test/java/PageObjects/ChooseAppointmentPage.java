package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import comtest.BasePageObject;
import com.codeborne.selenide.SelenideElement;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class ChooseAppointmentPage extends BasePageObject {

    private final SelenideElement healthyOption = $("#option-healthy-feeling");
    private final SelenideElement chooseContinue = $("#cap-continue-button");
    private final SelenideElement sickOption = $("#option-sick-feeling");
    private final ElementsCollection datePicker = $$x("//div[starts-with(@id,'calendar-day')]");
    private final SelenideElement timePicker = $("#time-picker-1-option");

    private final SelenideElement noAppoinemtn = $("div[class*='text-sm']");
    private final SelenideElement appointmentContinue = $("#cap-continue-button");
    public ChooseAppointmentPage() {
        assertTrue(isOpened(), "Appointment screen is open");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(healthyOption, chooseContinue);
    }

    public ElementsCollection getAppointmentOptions() {
        isElementDisplayed(timePicker);
        ElementsCollection options = getAppointmentCollection();
        for (int i = 0; i < options.size(); i++) {
            options.get(i).click();
            Selenide.sleep(1000);
            if (timePicker.isDisplayed()) {
                break;
            }
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
    waitUntilElementCondition(noAppoinemtn, Condition.visible, longWait);
    return noAppoinemtn.isDisplayed();
    }

    public AppointmentHeldPopUp continueAppointment(){
        appointmentContinue.click();
        return new AppointmentHeldPopUp();
    }

    public ChooseAppointmentPage sickOption(boolean sick){
         if (sick == true){
            sickOption.click();
        }else{
            healthyOption.click();
        }
         return this;
    }
//    public boolean isSickSelected(){
//            var element = $x(format(daysOnCalendar, date));
//            return isElementCondition(element, attribute("aria-selected", "true"), shortWait);
//
//    }
}
