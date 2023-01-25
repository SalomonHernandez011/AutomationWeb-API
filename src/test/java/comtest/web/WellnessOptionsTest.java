package comtest.web;

import PageObjects.BookVisitPage;
import PageObjects.GetCareLandingPage;
import PageObjects.LogInPage;
import PageObjects.WellnessPage;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;
import static constants.CommonTexts.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WellnessOptionsTest extends BaseWebTest {
    private LogInPage logInPage;
    private GetCareLandingPage getCareLandingPage;
    private BookVisitPage bookVisitPage;
    private WellnessPage wellnessPage;

    @BeforeMethod
    public void setup(){
        Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
        logInPage = new LogInPage();
        logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                .setPassword("1234asdF@")
                .clickLogIn();
        getCareLandingPage = new GetCareLandingPage();
        getCareLandingPage.clickBookVisit()
                .clickWellnessOption();
        wellnessPage = new WellnessPage();
    }

    @Test
    public void verifyWellnessPage()  {
        navigateToWellness();
    }

    private void navigateToWellness() {
        TakeScreenshot("GetCare_Wellness");

        assertThat(wellnessPage.wellnessTitleText())
                .as("text should match",  WELLNESS_TITLE.getCommonTexts())
                .isEqualTo(WELLNESS_TITLE.getCommonTexts());

        assertThat(wellnessPage.wellnessSubTitleText())
                .as("text should match", WELLNESS_SUBTEXT.getCommonTexts())
                .isEqualTo(WELLNESS_SUBTEXT.getCommonTexts());

        assertThat(wellnessPage.wellnessQuestionText())
                .as("text should match", WELLNESS_QUESTION.getCommonTexts())
                .isEqualTo(WELLNESS_QUESTION.getCommonTexts());



        assertThat(wellnessPage.annualWellnessText())
                .as("text should match",  WELLNESS_OPTION_ONE.getCommonTexts())
                .isEqualTo(WELLNESS_OPTION_ONE.getCommonTexts());

        assertThat(wellnessPage.travelAnxietyText())
                .as("text should match", WELLNESS_OPTION_TWO.getCommonTexts())
                .isEqualTo(WELLNESS_OPTION_TWO.getCommonTexts());

        assertThat(wellnessPage.vaccinationText())
                .as("text should match", WELLNESS_OPTION_THREE.getCommonTexts())
                .isEqualTo(WELLNESS_OPTION_THREE.getCommonTexts());

        assertThat(wellnessPage.motionSicknessText())
                .as("text should match", WELLNESS_OPTION_FOUR.getCommonTexts())
                .isEqualTo(WELLNESS_OPTION_FOUR.getCommonTexts());

        assertThat(wellnessPage.weightManagementText())
                .as("text should match", WELLNESS_OPTION_FIVE.getCommonTexts())
                .isEqualTo(WELLNESS_OPTION_FIVE.getCommonTexts());

        assertThat(wellnessPage.behaviourIssuesText())
                .as("text should match", WELLNESS_OPTION_SIX.getCommonTexts())
                .isEqualTo(WELLNESS_OPTION_SIX.getCommonTexts());

        assertThat(wellnessPage.separationAnxietyText())
                .as("text should match", WELLNESS_OPTION_SEVEN.getCommonTexts())
                .isEqualTo(WELLNESS_OPTION_SEVEN.getCommonTexts());

        assertThat(wellnessPage.otherOnSiteText())
                .as("text should match", WELLNESS_OPTION_EIGHT.getCommonTexts())
                .isEqualTo(WELLNESS_OPTION_EIGHT.getCommonTexts());

        TakeScreenshot("GetCare_Wellness");
    }
}
