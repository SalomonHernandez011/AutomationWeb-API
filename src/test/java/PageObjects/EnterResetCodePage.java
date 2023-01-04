package PageObjects;

import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class EnterResetCodePage extends BasePageObject {
    private final SelenideElement resetCode = $("input[name='code']");
    private final SelenideElement continueReset = $("button[class*='btn-primary']");

    public EnterResetCodePage() {
        assertTrue(isOpened(), "Reset code Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(resetCode, continueReset);
    }
    public void setResetCode(String code){
        resetCode.setValue(code);
    }

}
