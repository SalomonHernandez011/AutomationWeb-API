package comtest.web.getCare;

import PageObjects.*;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;

public class ChatNowTest extends BaseWebTest {
    private LogInPage logInPage;
    private GetCareLandingPage getCareLandingPage;
    private ChatNowPage chatNowPage;
    private ChatPage chatPage;

    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("Abc@123!")
                .clickLogIn();
        getCareLandingPage = new GetCareLandingPage();
        getCareLandingPage.clickChatNow()
                .clickButton();
        chatPage = new ChatPage();
        TakeScreenshot("ChatNow");
    }

    @Test
    public void verifyDentalPage()  {
        chatVisible();
    }

    public void chatVisible(){
        chatPage.chatText("Testing");
        TakeScreenshot("ChatNow");
        chatPage.sendMessage();
        TakeScreenshot("ChatNow");
    }
}
