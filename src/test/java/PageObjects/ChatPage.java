package PageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import comtest.BasePageObject;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class ChatPage extends BasePageObject {
    private final SelenideElement frame = $x("//iframe[@title='Messaging window']");
    private final SelenideElement chatQuestion = $x("//h2 [starts-with(@class, \"sc-vrqbdz\")]");
    private final SelenideElement chatBox = $x("//textarea");
    private final SelenideElement sendMessage = $x("//*[@id='Send-icon']");
    public ChatPage() {
        assertTrue(isOpened(), "Chat window is open");
    }

    public boolean isOpened() {
        switchTo().frame(frame);
        isElementDisplayed(chatBox);
        return isPageObjectLoaded(chatBox, chatQuestion);
    }

    public void chatText(String text){
        isElementDisplayed(chatBox);
        chatBox.setValue(text);
        Selenide.sleep(2000);
    }

    public void sendMessage(){
       chatBox.sendKeys(Keys.RETURN);
        Selenide.sleep(2000);
    }
}
