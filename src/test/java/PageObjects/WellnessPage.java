package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class WellnessPage extends BasePageObject {

    private final SelenideElement wellnessTitle = $x("//div[@class='welcome-text text-3xl w400' and text()='Wellness']");
    private final SelenideElement wellnessSubTitle = $("div[class='welcome-text text-sm w400']");
    private final SelenideElement wellnessQuestion = $("div[class$='text-base']");
    private final SelenideElement wellnessOptionList = $("div[class='options-list']");
    private final SelenideElement annualWellnessVisitOption = $x("//div[@class='text-base w400 title false' and text()='Annual wellness visit']");
    private final SelenideElement travelAnxietyOption = $x("//div[@class='text-base w400 title false' and text()='Travel anxiety']");
    private final SelenideElement vaccinationOption = $x("//div[@class='text-base w400 title false' and text()='Vaccinations']");
    private final SelenideElement motionSicknessOption = $x("//div[@class='text-base w400 title false' and text()='Motion sickness']");
    private final SelenideElement weightManagementOption = $x("//div[@class='text-base w400 title false' and text()='Weight management']");
    private final SelenideElement behaviourIssuesOption = $x("//div[@class='text-base w400 title false' and text()='Behavioral issues']");
    private final SelenideElement separationAnxietyOption = $x("//div[@class='text-base w400 title false' and text()='Separation anxiety']");
    private final SelenideElement otherOnsiteOption = $x("//div[@class='text-base w400 title false' and text()='Other Onsite services']");
    private final SelenideElement wellnessSubTextOne = $x("//div[contains(text(),'Schedule your pet’s annual wellness visit')]");
    private final SelenideElement wellnessSubTextTwo = $x("//div[contains(text(),'Schedule your pet’s annual wellness visit')]");



    public WellnessPage() {
        assertTrue(isOpened(), "Wellness Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(wellnessTitle, wellnessOptionList);
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
    public String annualWellnessText(){
        return annualWellnessVisitOption.getText();
    }
    public String travelAnxietyText(){
        return travelAnxietyOption.getText();
    }
    public String vaccinationText(){
        return vaccinationOption.getText();
    }
    public String motionSicknessText(){
        return motionSicknessOption.getText();
    }
    public String weightManagementText(){
        return weightManagementOption.getText();
    }
    public String behaviourIssuesText(){
        return behaviourIssuesOption.getText();
    }
    public String separationAnxietyText(){
        return separationAnxietyOption.getText();
    }
    public String otherOnSiteText(){
        return otherOnsiteOption.getText();
    }
    public void clickAnnualWellNessVisit(){
        annualWellnessVisitOption.click();
    }




}
