package PageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import constants.CommonTexts;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class BookVisitPage extends BasePageObject {
    private final SelenideElement bookVisitTitle = $("div[class='top-welcome text-3-xl-highway-series-9']");
    private final SelenideElement reasonForVisitQuestion = $x("//div[@class='section-title text-base-highway-series-7' and text()=' What is the reason for your appointment?']");
    private final SelenideElement wellnessOption = $x("//div[@class='text-lg-highway-series-7 false' and text()='Wellness']");
    private final SelenideElement travelCertificateOption = $x("//div[@class='text-lg-highway-series-7 false' and text()='Travel']");
    private final SelenideElement dentalOption = $x("//div[@class='text-lg-highway-series-7 false' and text()='Dental']");
    private final SelenideElement bookingImage = $("div[class='image-bottom'] img");
    private static final String BOOKVISIT_MENU_TITLE = "//div[@class='text-lg-highway-series-7 false' and text()='%s']";
    private static final String BOOKVISIT_MENU_SUBTITLE = "//div[@class='text-sm-inter-font-normal false' and text()='%s']";
    public BookVisitPage() {
        assertTrue(isOpened(), "Book Visit Page is opened");
    }

    public boolean isOpened() {
        bookVisitTitle.scrollIntoView(true);
        return isPageObjectLoaded(bookVisitTitle, reasonForVisitQuestion);
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
    public void clickDental(){
        dentalOption.click();
    }

    public boolean bookVisitTitlesText(CommonTexts label) {
        return $x(format(BOOKVISIT_MENU_TITLE, label.getCommonTexts())).isDisplayed();
    }
    public boolean bookVisitSubTitlesText(CommonTexts label) {
        return $x(format(BOOKVISIT_MENU_SUBTITLE, label.getCommonTexts())).isDisplayed();
    }


}
