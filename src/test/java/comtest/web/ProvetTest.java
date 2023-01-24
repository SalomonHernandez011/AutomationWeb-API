package comtest.web;

import PageObjects.ProVetCloudLogInPage;
import PageObjects.ProvetDashboardPage;
import comtest.BaseWebTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProvetTest extends BaseWebTest {
    private ProVetCloudLogInPage proVetCloudLogInPage;
    private ProvetDashboardPage provetDashboardPage;

    @BeforeMethod
    public void setup(){
        openProVetBrowser();
    }
    @Test
    public void provetTest(){
        openProvetAndLogIn();
    }

    private void openProvetAndLogIn(){
        proVetCloudLogInPage = new ProVetCloudLogInPage();
        proVetCloudLogInPage.enterUsername("salomon.hernandez@parkerandace.com")
                .enterPassword("salomones100%cabron")
                .clickLogIn()
                .selectDashboardOption()
                .searchCreatedAppointment("salomon cancel");
        TakeScreenshot("Provet");
    }
}
