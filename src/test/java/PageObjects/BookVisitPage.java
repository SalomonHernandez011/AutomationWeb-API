package PageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertTrue;

public class BookVisitPage extends BasePageObject {
    private final SelenideElement bookVisitTitle = $("div[class='welcome-text text-3xl w400']");
    private final SelenideElement reasonForVisitQuestion = $x("//div[@class='section-title text-base' and text()=' What is the reason for your appointment?']");
    private final SelenideElement wellnessOption = $x("//div[@class='text-base w400 title false' and text()='Wellness']");
    private final SelenideElement travelCertificateOption = $x("//div[@class='text-base w400 title false' and text()='Travel Certificate']");
    private final SelenideElement spayNeuterOption = $x("//div[@class='text-base w400 title false' and text()='Spay/ Neuter']");
    private final SelenideElement dentalOption = $x("//div[@class='text-base w400 title false' and text()='Dental']");
    private final SelenideElement otherOption = $x("//div[@class='text-base w400 title false' and text()='Other']");
    private final SelenideElement backBookVisit = $x("//div[contains(@style, 'cursor:')]");
    public BookVisitPage() {
        assertTrue(isOpened(), "Book Visit Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(bookVisitTitle, reasonForVisitQuestion);
    }

    public WellnessPage clickWellnessOption(){
        wellnessOption.click();
        return new WellnessPage();
    }

    public void clickTravel(){
        travelCertificateOption.click();
    }

    public void clickBookVisit(){
        backBookVisit.click();
    }

    public void clickDental(){
        dentalOption.click();
    }
}
