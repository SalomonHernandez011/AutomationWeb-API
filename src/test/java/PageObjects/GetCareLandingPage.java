package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class GetCareLandingPage extends BasePageObject {
    private final SelenideElement welcomeText = $("div[class*='welcome-text']");
    private final SelenideElement optionsList = $("div[class='options-list']");

    public GetCareLandingPage() {
        assertTrue(isOpened(), "Get Care Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(welcomeText, optionsList);
    }
}
