package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class GetCareLandingPage extends BasePageObject {
    private final SelenideElement welcomeText = $("div[class^='top-welcome text-3-xl-highway-series-9']");
    private final SelenideElement optionsList = $("div[class='options-list']");
    private final SelenideElement bookVisitOption = $x("//div[@class='text-lg-highway-series-7 false' and text()='Book visit']");
    private final SelenideElement chatNow = $x("//div[@class='text-lg-highway-series-7 undefined' and text()='Chat now']");


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

    public ChatNowPage clickChatNow(){
        chatNow.click();
        return new ChatNowPage();
    }
}
