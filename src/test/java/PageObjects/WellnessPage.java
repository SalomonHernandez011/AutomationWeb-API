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

    private final SelenideElement wellnessTitle = $x("//div[@class='welcome-text text-3xl w400' and text()='Wellness']");
    private final SelenideElement wellnessSubTitle = $("div[class='welcome-text text-sm w400']");
    private final SelenideElement wellnessQuestion = $("div[class$='text-base']");
    private final SelenideElement wellnessOptionList = $("div[class='options-list']");
    private final SelenideElement annualWellnessVisitOption = $x("//div[@class='text-base w400 title false' and text()='Wellness visit']");

    private static final String WELLNESS_MENU_TITLE = "//div[@class='text-base w400 title false' and text()='%s']";
    private static final String WELLNESS_MENU_SUBTITLE = "//div[@class='subtitle text-sm w400 false' and text()='%s']";


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
        annualWellnessVisitOption.click();
    }

    public boolean wellnessTitlesText(CommonTexts label) {
        return $x(format(WELLNESS_MENU_TITLE, label.getCommonTexts())).isDisplayed();
    }
    public boolean wellnessSubTitlesText(CommonTexts label) {
        return $x(format(WELLNESS_MENU_SUBTITLE, label.getCommonTexts())).isDisplayed();
    }

}
