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
    private final SelenideElement wellnessSubText = $x("//div[@class='subtitle text-sm w400 false' and text()='Healthy pet wellness exams and services']");
    private final SelenideElement sickOption = $x("//div[@class='text-base w400 title false' and text()='Sick']");
    private final SelenideElement sickSubText = $x("//div[@class='subtitle text-sm w400 false' and text()='If your pet is unwell']");
    private final SelenideElement travelCertificateOption = $x("//div[@class='text-base w400 title false' and text()='Travel']");
    private final SelenideElement travelSubText = $x("//div[@class='subtitle text-sm w400 false' and text()='Health certificates, anxiety, and motion...']");
    private final SelenideElement spayNeuterOption = $x("//div[@class='text-base w400 title false' and text()='Spay / Neuter']");
    private final SelenideElement spayNeuterSubText = $x("//div[@class='subtitle text-sm w400 false' and text()='Reproductive Health']");
    private final SelenideElement dentalOption = $x("//div[@class='text-base w400 title false' and text()='Dental']");
    private final SelenideElement dentalSubText = $x("//div[@class='subtitle text-sm w400 false' and text()='Exams, cleaning, extractions']");
    private final SelenideElement otherOption = $x("//div[@class='text-base w400 title false' and text()='Other']");
    private final SelenideElement otherSubText = $x("//div[@class='subtitle text-sm w400 false' and text()='Tell us what you need']");
    private final SelenideElement bookingImage = $("div[class='image-bottom'] img");

    private final SelenideElement backBookVisit = $x("//div[contains(@style, 'cursor:')]");
    public BookVisitPage() {
        assertTrue(isOpened(), "Book Visit Page is opened");
    }

    public boolean isOpened() {
        bookVisitTitle.scrollIntoView(true);
        return isPageObjectLoaded(bookVisitTitle, reasonForVisitQuestion);
    }

    public String getWellnessText(){
        return wellnessOption.getText();
    }

    public String getWellnessSubText(){
        return wellnessSubText.getText();
    }

    public String getSickText(){
        return sickOption.getText();
    }

    public String getSickSubText(){
        return sickSubText.getText();
    }

    public String getTravelText(){
        return travelCertificateOption.getText();
    }

    public String getTravelSubText(){
        return travelSubText.getText();
    }

    public String getSpayNeuterText(){
        return spayNeuterOption.getText();
    }

    public String getSpayNeuterSubText(){
        return spayNeuterSubText.getText();
    }

    public String getDentalText(){
        return dentalOption.getText();
    }

    public String getDentalSubText(){
        return dentalSubText.getText();
    }

    public String getOtherText(){
        return otherOption.getText();
    }

    public String getOtherSubText(){
        return otherSubText.getText();
    }

    public WellnessPage clickWellnessOption(){
        wellnessOption.click();
        return new WellnessPage();
    }

    public boolean imgPresent(){
        bookingImage.scrollIntoView(true);
        return bookingImage.isDisplayed();
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
