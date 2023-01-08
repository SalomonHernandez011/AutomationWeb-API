package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class GetCareLandingPage extends BasePageObject {
    private final SelenideElement welcomeText = $("div[class*='welcome-text']");
    private final SelenideElement optionsList = $("div[class='options-list']");
    private final SelenideElement bookVisitOption = $x("//div[@class='text-base w400 title false' and text()='Book visit']");

    public GetCareLandingPage() {
        assertTrue(isOpened(), "Get Care Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(welcomeText, optionsList);
    }

    public BookVisitPage clickBookVisit(){
        bookVisitOption.click();
        return new BookVisitPage();
    }
}
