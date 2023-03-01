package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import comtest.BaseWebTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class AppointmentPage extends BasePageObject {
    private final SelenideElement upcomingAppointmentsTitle = $x("//div[@class='section-title text-base-highway-series-7' and text()='Upcoming appointments']");
    private final SelenideElement pastAppointmentsTitle = $x("//div[@class='section-title text-base-highway-series-7' and text()='Past Appointments']");
    private final SelenideElement bottomImage = $("div[class='image-bottom'] img");
    private final SelenideElement topImage = $("div[class='logo'] img");
    private final SelenideElement titleText = $("div[class^='top-welcome text-3-xl-highway-series-9']");
    public AppointmentPage() {
        assertTrue(isOpened(), "Appointment Section is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(upcomingAppointmentsTitle, pastAppointmentsTitle);
    }

    public String appointmentTitleText(){
        return upcomingAppointmentsTitle.getText();
    }

    public String pastAppointmentText(){
        return pastAppointmentsTitle.getText();
    }

    public boolean imagePresent(){
        bottomImage.scrollIntoView(true);
        return bottomImage.isDisplayed();
    }
    public boolean topImagePresent(){
        topImage.scrollIntoView(true);
        return topImage.isDisplayed();
    }

    public String welcomeText(){
        return titleText.getText();
    }
}
