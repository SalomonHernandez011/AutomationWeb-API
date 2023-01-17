package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class TravelPage extends BasePageObject {
    private final SelenideElement travelTitle = $("div[class='welcome-text text-3xl w400']");
    private final SelenideElement bottomTravelImage = $("div[class='image-bottom'] img");
    private final SelenideElement subTitleText = $("div[class='welcome-text text-sm w400']");
    private final SelenideElement travelWhereText = $("div[class$='text-base']");
    private final SelenideElement optionOne = $x("//div[contains(text(),'Domestic')]");
    private final SelenideElement optionTwo = $x("//div[contains(text(),'International')]");
    private final SelenideElement optionThree = $x("//div[contains(text(),'Hawaii')]");
    private final SelenideElement subTextOne = $x("//div[contains(text(),'Travel within the Continental United States')]");
    private final SelenideElement subTextTwo = $x("//div[contains(text(),'International destinations')]");
    private final SelenideElement subTextThree = $x("//div[contains(text(),'Hawaiian Islands')]");

    public TravelPage() {
        assertTrue(isOpened(), "Travel Section is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(travelTitle, bottomTravelImage);
    }

    public String getTravelTitleText(){
        return travelTitle.getText();
    }

    public String getSubTitleText(){
        return subTitleText.getText();
    }

    public String getQuestionText(){
        return travelWhereText.getText();
    }

    public String getFirstOptionText(){
        return optionOne.getText();
    }

    public String getSecondOptionText(){
        return optionTwo.getText();
    }

    public String getOptionThreeText(){
        return optionThree.getText();
    }

    public String getSubTextOne(){
        return subTextOne.getText();
    }

    public String getSubTextTwo(){
        return subTextTwo.getText();
    }

    public String getSubTextThree(){
        return subTextThree.getText();
    }

    public String getTravelTitlesText(String text){
        return  $x(format("//div[@class='text-base w400 title false' and text()='%s']", text)).getText();

    }
}
