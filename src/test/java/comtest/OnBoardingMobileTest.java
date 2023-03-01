package comtest;

import PageObjects.*;
import Util.TwilioOTPHandle;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.twilio.Twilio;
import comtest.BaseMobileTest;
import dataProvider.ConfigFileReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static comtest.BaseWebTest.TakeScreenshot;
import static constants.CommonProperties.URL;
import static constants.CommonTexts.*;
import static constants.CommonTexts.ZIP_TEXT;
import static org.assertj.core.api.Assertions.assertThat;

public class OnBoardingMobileTest extends BaseMobileTest {
    Faker faker = new Faker();
    private LandingMobilePage landingMobilePage;
    private LocationPage locationPage;
    private ALittleAboutYouPage aLittleAboutYouPage;
    private EnterPetDetailsPage enterPetDetailsPage;
    private ChooseAppointmentPage chooseAppointmentPage;
    private ALittleMoreAboutPage aLittleMoreAboutPage;
    private CreatePasswordPage createPasswordPage;
    private DidYouGetOurTextPage didYouGetOurTextPage;
    private YourMembershipPage yourMembershipPage;
    private AddPaymentPage addPaymentPage;
    private GetCareLandingPage getCareLandingPage;
    private AppointmentHeldPopUp appointmentHeldPopUp;
    private LogInPage logInPage;
    private ProVetCloudLogInPage proVetCloudLogInPage;
    private ProvetDashboardPage provetDashboardPage;
    private SickPetPage sickPetPage;
    private String email = "parkertestingace"+"+"+ RandomStringUtils.randomNumeric(9)+"@gmail.com";
    private String petName = faker.pokemon().name();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String phoneNumber = "3396752234";
    private String password = "1234asdF@";
    private String petBreed = "Collie";
    private String cardNumber = "4242424242424242";
    public static final String ACCOUNT_SID = "ACf1b12f0aa5be0f10511cb307abb1acd2";
    public static final String AUTH_TOKEN = "dfba90f015d9d088f4ca278da0a513c1";

    @BeforeMethod
    public void init(){
        driver.get("https://qa.parkerandace.com/on-boarding");
        landingMobilePage = new LandingMobilePage();
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
    @Test
    protected void callLandingPage() {
        landingMobilePage.clickNext();
        assertThat(landingMobilePage.getCaruselText(VIRTUAL_ACCESS.getCommonTexts()))
                .as("Text Should Match", VIRTUAL_ACCESS.getCommonTexts())
                .isEqualTo(VIRTUAL_ACCESS.getCommonTexts());

        assertThat(landingMobilePage.getTextFromSecondScreen())
                .as("Text should match", SECOND_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(SECOND_SCREEN_TEXT.getCommonTexts());
        TakeScreenshot("OnBoarding");
    }
    protected void thirdPageView() {
        landingMobilePage.clickThirdOption();

        assertThat(landingMobilePage.getCaruselTextSecond(NO_EXAMS.getCommonTexts()))
                .as("Text Should Match", NO_EXAMS.getCommonTexts())
                .isEqualTo(NO_EXAMS.getCommonTexts());

        assertThat(landingMobilePage.getTextFromLastScreen())
                .as("Text Should Match", THIRD_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(THIRD_SCREEN_TEXT.getCommonTexts());
        TakeScreenshot("OnBoarding");
    }

    protected void getStartedPage() {
        locationPage = landingMobilePage.getStartedSelect()
                .clearZipField()
                .setTextToZip("20002");

        assertThat(locationPage.subLocText())
                .as("Text Should Match", LOCATION_INSTRUCTIONS.getCommonTexts())
                .isEqualTo(LOCATION_INSTRUCTIONS.getCommonTexts());

        assertThat(locationPage.subZipText())
                .as("Text Should Match", ZIP_TEXT.getCommonTexts())
                .isEqualTo(ZIP_TEXT.getCommonTexts());

        assertThat(locationPage.locationCard())
                .isTrue();
        TakeScreenshot("OnBoarding");
    }

}
