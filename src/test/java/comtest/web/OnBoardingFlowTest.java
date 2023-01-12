package comtest.web;

import PageObjects.*;
import Util.TwilioOTPHandle;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.twilio.Twilio;
import comtest.BaseWebTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonTexts.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OnBoardingFlowTest extends BaseWebTest {
    Faker faker = new Faker();
    private LandingPage landingPage;
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
    private String email = "parkertestingace"+"+"+RandomStringUtils.randomNumeric(9)+"@gmail.com";
    private String petName = faker.pokemon().name();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String phoneNumber = "3396752234";
    private String smsText = faker.number().digits(4);
    private String password = "1234asdF@";
    private String petBreed = "Collie";
    private String cardNumber = "4242424242424242";
    public static final String ACCOUNT_SID = "ACf1b12f0aa5be0f10511cb307abb1acd2";
    public static final String AUTH_TOKEN = "dfba90f015d9d088f4ca278da0a513c1";

    @BeforeMethod
    public void setup() {
        landingPage = new LandingPage();
        TakeScreenshot("Onboarding");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @Test
    public void verifyOnBoardingFlowPage() {
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation();
        selectAppointment();
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation();
        getCareLandingPage();
    }
    private void callLandingPage() {
        landingPage.clickNext();

        assertThat(landingPage.getCaruselText(VIRTUAL_ACCESS.getCommonTexts()))
                .as("Text Should Match", VIRTUAL_ACCESS.getCommonTexts())
                .isEqualTo(VIRTUAL_ACCESS.getCommonTexts());

        assertThat(landingPage.getTextFromSecondScreen())
                .as("Text should match", SECOND_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(SECOND_SCREEN_TEXT.getCommonTexts());
        TakeScreenshot("OnBoarding");
    }
    private void thirdPageView() {
        landingPage.clickThirdOption();

        assertThat(landingPage.getCaruselTextSecond(NO_EXAMS.getCommonTexts()))
                .as("Text Should Match", NO_EXAMS.getCommonTexts())
                .isEqualTo(NO_EXAMS.getCommonTexts());

        assertThat(landingPage.getTextFromLastScreen())
                .as("Text Should Match", THIRD_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(THIRD_SCREEN_TEXT.getCommonTexts());
        TakeScreenshot("OnBoarding");
    }

    private void getStartedPage() {
        locationPage = landingPage.getStartedSelect()
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
    private void selectLocationAndSignUp() {
        locationPage = new LocationPage();
         locationPage.clickLocationCard()
                .clickNotAnEmergency();
    aLittleAboutYouPage = new ALittleAboutYouPage();
        TakeScreenshot("OnBoarding");
        aLittleAboutYouPage.setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setUserEmail(email)
                .markCheckBox();
        TakeScreenshot("OnBoarding");
        aLittleAboutYouPage.clickContinue();
        TakeScreenshot("OnBoarding");
    }

    private void isBreedEnabled() {
        enterPetDetailsPage = new EnterPetDetailsPage();
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isFalse();
    }
    private void fillPetInformation() {
        enterPetDetailsPage.setPetName(petName)
                .selectDog()
                .selectMale()
                .uploadImage()
                .setAge("1","0","0");
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isTrue();
        enterPetDetailsPage.enterBreed(petBreed)
                .selectBreedOption();
        TakeScreenshot("OnBoarding");
        enterPetDetailsPage.selectContinue();
    }

    private void selectAppointment() {
        chooseAppointmentPage = new ChooseAppointmentPage();
        TakeScreenshot("OnBoarding");
        chooseAppointmentPage.getAppointmentOptions();
        chooseAppointmentPage.setAppointment()
                .continueAppointment();
        TakeScreenshot("OnBoarding");
        appointmentHeldPopUp = new AppointmentHeldPopUp();
        appointmentHeldPopUp.clickUnderstand();
        TakeScreenshot("OnBoarding");
    }

    private void fillMoreInformation() {
        aLittleMoreAboutPage = new ALittleMoreAboutPage();
        TakeScreenshot("OnBoarding");
        aLittleMoreAboutPage.setPhoneNumber(phoneNumber)
                .checkAppointmentCheckbox()
                .checkDiscountCheckBox();
        TakeScreenshot("OnBoarding");
        aLittleMoreAboutPage.selectContinue();
    }
    private void generatePassword() {
        createPasswordPage = new CreatePasswordPage();
        TakeScreenshot("OnBoarding");
        createPasswordPage.setPassword(password)
                .confirmPassword(password);
        TakeScreenshot("OnBoarding");
        createPasswordPage.nextPageContinue();
    }

    private void enterSmsText() {
        didYouGetOurTextPage = new DidYouGetOurTextPage();
        TakeScreenshot("OnBoarding");
        didYouGetOurTextPage.setSmsCode(TwilioOTPHandle.smsMessage());
        Selenide.sleep(3000);
        TakeScreenshot("OnBoarding");
        didYouGetOurTextPage .clickContinueSMS();
    }

    private void billingInfo() {
        yourMembershipPage = new YourMembershipPage();
        TakeScreenshot("OnBoarding");
        yourMembershipPage.continueToPayment();
    }

    private void addPaymentInformation() {
        addPaymentPage = new AddPaymentPage();
        TakeScreenshot("OnBoarding");
        addPaymentPage.setNameOnCard("Salomon")
                .setCardNumber(cardNumber)
                .setExpiration("1223")
                .setCvcCode("123")
                .setAddressOnPayment("Address")
                .setCityText("San Diego")
                .openStateDropdown()
                .setState("California")
                .setZipCode("91910");
        TakeScreenshot("OnBoarding");
        addPaymentPage.selectContinue();
    }

    private void getCareLandingPage() {
        getCareLandingPage = new GetCareLandingPage();
        TakeScreenshot("OnBoarding");
    }

}
