package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import comtest.BaseWebTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class AppointmentPage extends BasePageObject {
    private final SelenideElement upcomingAppointmentsTitle = $x("//div[@class='section-title text-base' and text()='Upcomming appointments']");
    private final SelenideElement pastAppointmentsTitle = $x("//div[@class='section-title text-base' and text()='Past Appointments']");
    public AppointmentPage() {
        assertTrue(isOpened(), "Appointment Sectio is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(upcomingAppointmentsTitle, pastAppointmentsTitle);
    }
}
