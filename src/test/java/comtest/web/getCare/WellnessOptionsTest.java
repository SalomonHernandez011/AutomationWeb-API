package comtest.web.getCare;

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
        wellnessPage.titleDisplay();
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

        assertThat(wellnessPage.wellnessTitlesText(WELLNESS_OPTION_ONE))
                .as("text should match",  WELLNESS_OPTION_ONE.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessTitlesText(WELLNESS_OPTION_TWO))
                .as("text should match", WELLNESS_OPTION_TWO.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessTitlesText(WELLNESS_OPTION_THREE))
                .as("text should match", WELLNESS_OPTION_THREE.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessTitlesText(WELLNESS_OPTION_FOUR))
                .as("text should match", WELLNESS_OPTION_FOUR.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessTitlesText(WELLNESS_OPTION_FIVE))
                .as("text should match", WELLNESS_OPTION_FIVE.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessTitlesText(WELLNESS_OPTION_SIX))
                .as("text should match", WELLNESS_OPTION_SIX.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessTitlesText(WELLNESS_OPTION_SEVEN))
                .as("Text Should Match", WELLNESS_OPTION_SEVEN.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessSubTitlesText(WELLNESS_SUBTEXT_ONE))
                .as("Text Should Match", WELLNESS_SUBTEXT_ONE.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessSubTitlesText(WELLNESS_SUBTEXT_TWO))
                .as("Text Should Match", WELLNESS_SUBTEXT_TWO.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessSubTitlesText(WELLNESS_SUBTEXT_THREE))
                .as("Text Should Match", WELLNESS_SUBTEXT_THREE.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessSubTitlesText(WELLNESS_SUBTEXT_FOUR))
                .as("Text Should Match", WELLNESS_SUBTEXT_FOUR.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessSubTitlesText(WELLNESS_SUBTEXT_FIVE))
                .as("Text Should Match", WELLNESS_SUBTEXT_FIVE.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessSubTitlesText(WELLNESS_SUBTEXT_SIX))
                .as("Text Should Match", WELLNESS_SUBTEXT_SIX.getCommonTexts())
                .isTrue();

        assertThat(wellnessPage.wellnessSubTitlesText(WELLNESS_SUBTEXT_SEVEN))
                .as("Text Should Match", WELLNESS_SUBTEXT_SEVEN.getCommonTexts())
                .isTrue();

        TakeScreenshot("GetCare_Wellness");
    }
}
