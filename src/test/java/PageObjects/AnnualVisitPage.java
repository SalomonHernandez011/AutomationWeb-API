package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class AnnualVisitPage extends BasePageObject {

    private final SelenideElement selectVeterinarianText = $("div[class='top-welcome text-3-xl-highway-series-9']");
    private final SelenideElement allAvailableText = $("div[class='section-title text-base-highway-series-7']");
    private final SelenideElement subVeterinarianPageText = $("div[class='welcome-text text-sm-inter-font-normal']");
    private final SelenideElement bottomImage = $x("//img[contains(@src, 'ottom')]");

    public AnnualVisitPage() {
        assertTrue(isOpened(), "Wellness Veterinarian Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(selectVeterinarianText, allAvailableText);
    }

    public String wellnessVeterinarianText(){
        return selectVeterinarianText.getText();
    }

    public String allAvailableText(){
        return allAvailableText.getText();
    }

    public String subVeterinarianPageText(){
        return subVeterinarianPageText.getText();
    }

    public boolean bottomImagePresent(){
        return bottomImage.isDisplayed();
    }

}
