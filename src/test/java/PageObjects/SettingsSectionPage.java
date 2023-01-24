package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class SettingsSectionPage extends BasePageObject {
    private final SelenideElement pageTitle = $("div[class^='welcome-text']");
    private final SelenideElement questionSettings = $("div[class^='title']");
    private final ElementsCollection listOptions = $$("div[class='options-list']");
    private final SelenideElement logOutOption = $x("//div[@class='text-base w400 title false' and text()='Sign out']");

    public SettingsSectionPage() {
        assertTrue(isOpened(), "Settings Section is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(pageTitle, questionSettings);
    }
    public LogInPage clickLogOut(){
        logOutOption.click();
        return new LogInPage();
    }
}
