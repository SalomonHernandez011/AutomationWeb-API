package comtest.web;

import PageObjects.*;
import com.codeborne.selenide.Selenide;
import comtest.BaseWebTest;
import dataProvider.ConfigFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonProperties.LOGIN_URL;
import static constants.CommonProperties.USER_EMAIL;
import static constants.CommonTexts.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ReviewTravelSectionTest extends BaseWebTest {
        private LogInPage logInPage;
        private BookVisitPage bookVisitPage;
        private TravelPage travelPage;

        @BeforeMethod
        public void setup() {
            Selenide.open(ConfigFileReader.getProperty(LOGIN_URL));
            logInPage = new LogInPage();
            logInPage.setLoginEmail(ConfigFileReader.getProperty(USER_EMAIL))
                    .setPassword("1234asdF@")
                    .clickLogIn()
                    .clickBookVisit();
            bookVisitPage = new BookVisitPage();
            bookVisitPage.clickTravel();
            travelPage = new TravelPage();
        }

        @Test
        public void verifyTravelPage() {
            reviewPageText();
        }

        private void reviewPageText(){
           assertThat(travelPage.getTravelTitleText())
                   .as("Text should match", TRAVEL_TITLE.getCommonTexts())
                   .isEqualTo(TRAVEL_TITLE.getCommonTexts());

            assertThat(travelPage.getSubTitleText())
                    .as("Text should match", TRAVEL_SUBTITLE.getCommonTexts())
                    .isEqualTo(TRAVEL_SUBTITLE.getCommonTexts());

            assertThat(travelPage.getQuestionText())
                    .as("Text should match", TRAVEL_QUESTION.getCommonTexts())
                    .isEqualTo(TRAVEL_QUESTION.getCommonTexts());



            assertThat(travelPage.getFirstOptionText())
                    .as("Text should match", FIRST_TRAVEL_OPTION_TEXT.getCommonTexts())
                    .isEqualTo(FIRST_TRAVEL_OPTION_TEXT.getCommonTexts());

            assertThat(travelPage.getSubTextOne())
                    .as("Text should match", TRAVEL_FIRST_SUBTEXT.getCommonTexts())
                    .isEqualTo(TRAVEL_FIRST_SUBTEXT.getCommonTexts());



            assertThat(travelPage.getSecondOptionText())
                    .as("Text should match", SECOND_TRAVEL_OPTION_TEXT.getCommonTexts())
                    .isEqualTo(SECOND_TRAVEL_OPTION_TEXT.getCommonTexts());

            assertThat(travelPage.getSubTextTwo())
                    .as("Text should match", TRAVEL_SECOND_SUBTEXT.getCommonTexts())
                    .isEqualTo(TRAVEL_SECOND_SUBTEXT.getCommonTexts());



            assertThat(travelPage.getOptionThreeText())
                    .as("Text should match", THIRD_TRAVEL_OPTION_TEXT.getCommonTexts())
                    .isEqualTo(THIRD_TRAVEL_OPTION_TEXT.getCommonTexts());

            assertThat(travelPage.getSubTextThree())
                    .as("Text should match", TRAVEL_THIRD_SUBTEXT.getCommonTexts())
                    .isEqualTo(TRAVEL_THIRD_SUBTEXT.getCommonTexts());

            TakeScreenshot("Travel");
        }
    }