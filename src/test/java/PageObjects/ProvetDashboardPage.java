package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ProvetDashboardPage extends BasePageObject {
    private final SelenideElement appointmentSearch = $("#scheduled_searchbox");
    private final SelenideElement recentConsultation = $("#recent_searchbox");
    public ProvetDashboardPage() {
        assertTrue(isOpened(), "ProvetCloud Dashboard page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(appointmentSearch, recentConsultation);
    }

    public void searchCreatedAppointment(String user){
        appointmentSearch.setValue(user);
    }

}
