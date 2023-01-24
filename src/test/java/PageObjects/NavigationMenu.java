package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class NavigationMenu extends BasePageObject {
    private final SelenideElement careOption = $("#bottom-menu-care");
    private final SelenideElement appointmentOption = $("#bottom-menu-appointments");
    private final SelenideElement petsOption = $("#bottom-menu-pets");
    private final SelenideElement settingsOptions = $("#bottom-menu-settings");

    public NavigationMenu() {
        assertTrue(isOpened(), "Navigation Menu is present");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(careOption, appointmentOption);
    }

    public AppointmentPage clickAppointment(){
        appointmentOption.click();
        return  new AppointmentPage();
    }

    public SettingsSectionPage clickSettings(){
        settingsOptions.click();
        return new SettingsSectionPage();
    }
}
