package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import constants.CommonTexts;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class WellnessPage extends BasePageObject {

    private final SelenideElement wellnessTitle = $x("//div[@class='top-welcome text-3-xl-highway-series-9' and text()='Wellness']");
    private final SelenideElement wellnessSubTitle = $("div[class='welcome-text text-sm-inter-font-normal']");
    private final SelenideElement wellnessQuestion = $("div[class$='section-title text-base-highway-series-7']");
    private final SelenideElement wellnessOptionList = $("div[class='options-list']");
    private final SelenideElement wellnessVisitOption = $x("//div[@class='text-lg-highway-series-7 undefined' and text()='Wellness visit']");

    private static final String WELLNESS_MENU_TITLE = "//div[@class='text-lg-highway-series-7 undefined' and text()='%s']";
    private static final String WELLNESS_MENU_SUBTITLE = "//div[@class='text-sm-inter-font-normal undefined' and text()='%s']";


    public WellnessPage() {
        assertTrue(isOpened(), "Wellness Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(wellnessTitle, wellnessOptionList);
    }

    public void titleDisplay(){
        wellnessTitle.scrollIntoView(true);
    }

    public String wellnessTitleText(){
        return wellnessTitle.getText();
    }

    public String wellnessSubTitleText(){
        return wellnessSubTitle.getText();
    }

    public String wellnessQuestionText(){
        return wellnessQuestion.getText();
    }
    public void clickAnnualWellNessVisit(){
        wellnessVisitOption.click();
    }

    public boolean wellnessTitlesText(CommonTexts label) {
        return $x(format(WELLNESS_MENU_TITLE, label.getCommonTexts())).isDisplayed();
    }
    public boolean wellnessSubTitlesText(CommonTexts label) {
        return $x(format(WELLNESS_MENU_SUBTITLE, label.getCommonTexts())).isDisplayed();
    }

}
