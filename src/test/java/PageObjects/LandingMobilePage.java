package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class LandingMobilePage {
    private final SelenideElement swipeStart = $("div[class^='swiper-pagination']");

    private final SelenideElement imageLanding = $x("//img[contains(@src, 'da')]");
    private final SelenideElement secondOption = $x("/html/body/div/div/div/div/div[2]/span[2]");

    private final SelenideElement secondTextOption = $("div[class^='text-container']");
    private final SelenideElement thirdOption = $x("/html/body/div/div/div/div/div[2]/span[3]");
    private final SelenideElement getStarted = $("div[class^='link']");
    private final SelenideElement thirdTextOption = $("div[class^='text-sm']");
    private final SelenideElement virtualAccessText = $("div[class=' w600 text-2xl']");
    private final SelenideElement noExams = $("div[class='w600 text-2xl']");
    private final SelenideElement skipOption = $("span[class='skip-action']");

    public void clickNext(){
        secondOption.click();
    }

    public String getTextFromSecondScreen(){
        return secondTextOption.getText();
    }

    public LandingMobilePage clickThirdOption(){
        thirdOption.click();
        return this;
    }

    public LocationPage getStartedSelect(){
        getStarted.click();
        return new LocationPage();
    }

    public String getTextFromLastScreen(){
        return thirdTextOption.getText();
    }

    public String getCaruselText(String text){
        return virtualAccessText.getText();
    }

    public String getCaruselTextSecond(String text){
        return noExams.getText();
    }

    public LocationPage clickSkip(){
        skipOption.click();
        return new LocationPage();
    }
}
