package PageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class DentalPage extends BasePageObject {

    private final SelenideElement dentalPoint = $("div[class='welcome-text text-3xl w400']");
    private final SelenideElement dentalTitle = $x("//div[@class='welcome-text text-3xl w400' and text()='%s']");
    private final SelenideElement dentalBottomImage = $("div[class='image-bottom'] img");
    public DentalPage() {
        assertTrue(isOpened(), "Dental Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(dentalPoint, dentalBottomImage);
    }

    public String getDentalTitleText(String text){
        return  $x(format("//div[@class='welcome-text text-3xl w400' and text()='%s']", text)).getText();
    }

    public String getDentalSubTitleText(String text){
        return  $x(format("//div[@class='welcome-text text-sm w400' and text()='%s']", text)).getText();
    }

    public String getDentalQuestionText(String text){
        return  $x(format("//div[@class='section-title text-base' and text()='%s']", text)).getText();
    }

    public String getDentalOptionsText(String text){
        return  $x(format("//div[@class='text-base w400 title false' and text()='%s']", text)).getText();
    }

    public String getDentalSubText(String text){
        return  $x(format("//div[@class='text-sm w400 false' and text()='%s']", text)).getText();
    }


}
