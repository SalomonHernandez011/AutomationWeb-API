package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ProVetCloudLogInPage extends BasePageObject {
    private final SelenideElement provetEmail = $("#id_username");
    private final SelenideElement provetPassword = $("#id_password");
    private final SelenideElement provetLogInButton = $("#id_btn_login");
    private final SelenideElement dashboard = $("li[data-subnav='dashboard-subnav']");
    public ProVetCloudLogInPage() {
        assertTrue(isOpened(), "ProvetCloud page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(provetEmail, provetPassword);
    }

    public ProVetCloudLogInPage enterUsername(String email){
        provetEmail.setValue(email);
        return this;
    }

    public ProVetCloudLogInPage enterPassword(String password){
        provetPassword.setValue(password);
        return this;
    }

    public ProVetCloudLogInPage clickLogIn(){
        provetLogInButton.click();
        return this;
    }

    public ProvetDashboardPage selectDashboardOption(){
        dashboard.click();
        return new ProvetDashboardPage();
    }
}
