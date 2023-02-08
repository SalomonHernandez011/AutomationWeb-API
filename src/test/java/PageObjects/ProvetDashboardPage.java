package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class ProvetDashboardPage extends BasePageObject {
    private final SelenideElement appointmentSearch = $("#scheduled_searchbox");
    private final SelenideElement recentConsultation = $("#recent_searchbox");
    private final SelenideElement allConsulatationOption = $("#scheduled-timespan-btn-group > button.btn.btn-default.scheduled_timespan.no-pc-active-filter");
    private static final String PET_PARENT_APPOINTMENT = "//a[contains(text(),'%s')]";
    public ProvetDashboardPage() {
        assertTrue(isOpened(), "ProvetCloud Dashboard page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(appointmentSearch, recentConsultation);
    }

    public void searchCreatedAppointment(String user){
        appointmentSearch.scrollIntoView(true);
        appointmentSearch.setValue(user);
    }

    public void allAppointments(){
        allConsulatationOption.click();
    }

    public void clickPetParent(String firstName, String lastName){
        $x(format(PET_PARENT_APPOINTMENT, firstName+" "+lastName)).click();
    }
}
