package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class AnnualVisitPage extends BasePageObject {

    private final SelenideElement selectVeterinarianText = $("div[class='welcome-text text-3xl w400']");
    private final SelenideElement allAvailableText = $("div[class='section-title text-base']");
    private final SelenideElement subVeterinarianPageText = $("div[class='welcome-text text-sm w400']");
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
