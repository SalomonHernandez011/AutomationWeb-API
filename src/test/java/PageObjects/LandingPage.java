package PageObjects;

import comtest.BasePageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class LandingPage extends BasePageObject {

    private final SelenideElement swipeStart = $("div[class^='swiper-pagination']");

    private final SelenideElement imageLanding = $x("//img[contains(@src, 'da')]");
    private final SelenideElement secondOption = $x("//body/div[@id='root']/div[1]/div[1]/div[2]/span[2]");

    private final SelenideElement secondTextOption = $("div[class^='text-container']");
    private final SelenideElement thirdOption = $x("/html/body/div/div/div/div[2]/span[3]");
    private final SelenideElement getStarted = $("div.link");
    private final SelenideElement thirdTextOption = $("div[class^='text-sm']");

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

    public RegistrationPage  getStartedSelect(){
        getStarted.click();
        return new RegistrationPage();
    }

    public String getTextFromLastScreen(){
        waitUntilElementCondition(thirdTextOption, Condition.visible, longWait);
        return thirdTextOption.getText();
    }


    
}
