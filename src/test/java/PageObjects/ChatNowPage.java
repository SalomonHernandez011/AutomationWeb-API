package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ChatNowPage extends BasePageObject {
    private final SelenideElement pageTitle = $("div[class='welcome-text text-3xl w400']");
    private final SelenideElement pageButton = $("button[class*='btn-primary']");
    public ChatNowPage() {
        assertTrue(isOpened(), "Payment Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(pageTitle, pageButton);
    }

    public void clickButton(){
        pageButton.click();
    }
}
