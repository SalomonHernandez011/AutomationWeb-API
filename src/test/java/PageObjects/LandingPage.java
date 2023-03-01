package PageObjects;

import comtest.BasePageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.CommonTexts;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class LandingPage extends BasePageObject {

    private final SelenideElement swipeStart = $("span[class^='swiper-pagination-bullet']");

    private final SelenideElement imageLanding = $x("//img[contains(@src, 'bf')]");
    private final SelenideElement secondOption = $x("/html/body/div/div/div/div/div[2]/span[2]");

    private final SelenideElement secondTextOption = $("div[class^='text-container']");
    private final SelenideElement thirdOption = $x("/html/body/div/div/div/div/div[2]/span[3]");
    private final SelenideElement getStarted = $("#slider-get-started");
    private final SelenideElement thirdTextOption = $("div[class^='text-sm']");
    private final SelenideElement virtualAccessText = $("span[class='text-2-xl-highway-series-9']");
    private final SelenideElement noExams = $("div[class='text-2-xl-highway-series-9']");
    private final SelenideElement skipOption = $("span[class='skip-action']");

    private static final String LAST_SCREEN_TEXT = "//span[text()='%s']";


    public LandingPage() {
        assertTrue(isOpened(), "Landing Page is opened");
    }

    public boolean isOpened() {
        isElementDisplayed(swipeStart);
        isElementDisplayed(imageLanding);
        return isPageObjectLoaded(swipeStart, imageLanding);
    }

    public void clickNext(){
        secondOption.click();
        waitUntilElementCondition(secondTextOption, Condition.visible, longWait);
    }

    public String getTextFromSecondScreen(){
        waitUntilElementCondition(secondTextOption, Condition.visible, longWait);
        return secondTextOption.getText();
    }

    public LandingPage clickThirdOption(){
        thirdOption.click();
        return this;
    }

    public LocationPage getStartedSelect(){
        getStarted.click();
        return new LocationPage();
    }

    public String getTextFromLastScreen(){
        waitUntilElementCondition(thirdTextOption, Condition.visible, longWait);
        return thirdTextOption.getText();
    }

    public String getCaruselText(String text){
        waitUntilElementCondition(virtualAccessText, Condition.exactText(text), longWait);
        return virtualAccessText.getText();
    }

    public String getCaruselTextSecond(String text){
        waitUntilElementCondition(noExams, Condition.exactText(text), longWait);
        return noExams.getText();
    }

    public LocationPage clickSkip(){
        skipOption.click();
        return new LocationPage();
    }

    public String labsText(CommonTexts label) {
        return $x(format(LAST_SCREEN_TEXT, label.getCommonTexts())).getText();
    }
}
