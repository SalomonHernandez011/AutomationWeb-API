package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class ALittleMoreAboutPage extends BasePageObject {
    private final SelenideElement phoneNumber = $("#almayp-phone-number-input");
    private final SelenideElement continueButton = $("#almayp-continue-button");
    private final SelenideElement textMeAppointmentsCheckBox = $x("/html/body/div/div/div/div[2]/div/form/div/label[1]/span[1]");
    private final SelenideElement textMeDiscountsCheckBox = $x("/html/body/div/div/div/div[2]/div/form/div/label[2]/span[1]");
    private final SelenideElement timeRemaining = $("div[class='time-remaining']");
    public ALittleMoreAboutPage() {
        assertTrue(isOpened(), "A Little More About You Page is open");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(phoneNumber, timeRemaining);
    }

    public ALittleMoreAboutPage setPhoneNumber(String number){
        phoneNumber.setValue(number);
        return this;
    }

    public ALittleMoreAboutPage checkAppointmentCheckbox(){
        textMeAppointmentsCheckBox.click();
        return this;
    }

    public ALittleMoreAboutPage checkDiscountCheckBox(){
        textMeDiscountsCheckBox.click();
        return this;
    }

    public void selectContinue(){
        continueButton.click();
    }

}
