package comtest.web;

import PageObjects.*;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;
import static constants.CommonTexts.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DentalReviewTest extends BaseWebTest {
    private LogInPage logInPage;
    private DentalPage dentalPage;

    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@")
                .clickLogIn()
                .clickBookVisit()
                .clickDental();
        dentalPage = new DentalPage();

    }

    @Test
    public void verifyDentalPage()  {
        enterDentalSection();
    }

    private void enterDentalSection(){
        assertThat(dentalPage.getDentalTitleText(DENTAL_TITLE.getCommonTexts()))
                .as("Text should match", DENTAL_TITLE.getCommonTexts())
                .isEqualTo(DENTAL_TITLE.getCommonTexts());

        assertThat(dentalPage.getDentalSubTitleText(DENTAL_SUBTITLE.getCommonTexts()))
                .as("Text should match", DENTAL_SUBTITLE.getCommonTexts())
                .isEqualTo(DENTAL_SUBTITLE.getCommonTexts());

        assertThat(dentalPage.getDentalQuestionText(DENTAL_QUESTION.getCommonTexts()))
                .as("Text should match", DENTAL_QUESTION.getCommonTexts())
                .isEqualTo(DENTAL_QUESTION.getCommonTexts());

        assertThat(dentalPage.getDentalOptionsText(DENTAL_FIRST_OPTION.getCommonTexts()))
                .as("Text should match", DENTAL_FIRST_OPTION.getCommonTexts())
                .isEqualTo(DENTAL_FIRST_OPTION.getCommonTexts());

        assertThat(dentalPage.getDentalOptionsText(DENTAL_SECOND_OPTION.getCommonTexts()))
                .as("Text should match", DENTAL_SECOND_OPTION.getCommonTexts())
                .isEqualTo(DENTAL_SECOND_OPTION.getCommonTexts());

        assertThat(dentalPage.getDentalOptionsText(DENTAL_THIRD_OPTION.getCommonTexts()))
                .as("Text should match", DENTAL_THIRD_OPTION.getCommonTexts())
                .isEqualTo(DENTAL_THIRD_OPTION.getCommonTexts());

        assertThat(dentalPage.getDentalOptionsText(DENTAL_FOURTH_OPTION.getCommonTexts()))
                .as("Text should match", DENTAL_FOURTH_OPTION.getCommonTexts())
                .isEqualTo(DENTAL_FOURTH_OPTION.getCommonTexts());

        assertThat(dentalPage.getDentalSubText(DENTAL_FIRST_SUBTEXT.getCommonTexts()))
                .as("Text should match", DENTAL_FIRST_SUBTEXT.getCommonTexts())
                .isEqualTo(DENTAL_FIRST_SUBTEXT.getCommonTexts());

        assertThat(dentalPage.getDentalSubText(DENTAL_SECOND_SUBTEXT.getCommonTexts()))
                .as("Text should match", DENTAL_SECOND_SUBTEXT.getCommonTexts())
                .isEqualTo(DENTAL_SECOND_SUBTEXT.getCommonTexts());

        assertThat(dentalPage.getDentalSubText(DENTAL_THIRD_SUBTEXT.getCommonTexts()))
                .as("Text should match", DENTAL_THIRD_SUBTEXT.getCommonTexts())
                .isEqualTo(DENTAL_THIRD_SUBTEXT.getCommonTexts());

        assertThat(dentalPage.getDentalSubText(DENTAL_FOURTH_SUBTEXT.getCommonTexts()))
                .as("Text should match", DENTAL_FOURTH_SUBTEXT.getCommonTexts())
                .isEqualTo(DENTAL_FOURTH_SUBTEXT.getCommonTexts());

        TakeScreenshot("Dental");

    }
}
