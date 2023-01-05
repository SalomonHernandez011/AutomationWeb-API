package comtest.web;

import PageObjects.*;
import Util.TwilioOTPHandle;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.TakeScreenshot;
import com.codeborne.selenide.commands.TakeScreenshotAsImage;
import com.codeborne.selenide.testng.ScreenShooter;
import com.github.javafaker.DateAndTime;
import com.twilio.Twilio;
import comtest.BaseWebTest;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static constants.CommonTexts.*;
import static org.assertj.core.api.Assertions.allOf;
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
    private LogInPage logInPage;
    private String email = "parkertestingace"+"+"+RandomStringUtils.randomNumeric(9)+"@gmail.com";
    private String petName = faker.name().firstName();
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
    public void setup() throws IOException {
        landingPage = new LandingPage();
        TakeScreenshot("First Page"+LocalDate.now());
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @Test
    public void verifyLandingPage() throws IOException {
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
    private void callLandingPage() throws IOException {
        landingPage.clickNext();

        assertThat(landingPage.getCaruselText(VIRTUAL_ACCESS.getCommonTexts()))
                .as("Text Should Match", VIRTUAL_ACCESS.getCommonTexts())
                .isEqualTo(VIRTUAL_ACCESS.getCommonTexts());

        assertThat(landingPage.getTextFromSecondScreen())
                .as("Text should match", SECOND_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(SECOND_SCREEN_TEXT.getCommonTexts());
        TakeScreenshot("Second Page"+LocalDate.now());
    }
    private void thirdPageView() throws IOException {
        landingPage.clickThirdOption();

        assertThat(landingPage.getCaruselTextSecond(NO_EXAMS.getCommonTexts()))
                .as("Text Should Match", NO_EXAMS.getCommonTexts())
                .isEqualTo(NO_EXAMS.getCommonTexts());

        assertThat(landingPage.getTextFromLastScreen())
                .as("Text Should Match", THIRD_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(THIRD_SCREEN_TEXT.getCommonTexts());
        TakeScreenshot("Third Page"+LocalDate.now());
    }

    private void getStartedPage() throws IOException {
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
        TakeScreenshot("GetStartedPage"+LocalDate.now());
    }
    private void selectLocationAndSignUp() throws IOException {
        enterPetDetailsPage = locationPage.clickLocationCard()
                .clickNotAnEmergency()
                .setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setUserEmail(email)
                .markCheckBox()
                .clickContinue();
        TakeScreenshot("PetDetails"+LocalDate.now());
    }

    private void isBreedEnabled(){
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isFalse();
    }
    private void fillPetInformation() throws IOException {
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
        TakeScreenshot("PetInformationFilled"+LocalDate.now());
        enterPetDetailsPage.selectContinue();
    }

    private void selectAppointment() throws IOException {
        chooseAppointmentPage = new ChooseAppointmentPage();
        TakeScreenshot("AcceptAppointmentEmpty"+LocalDate.now());
        chooseAppointmentPage.getAppointmentOptions();
        chooseAppointmentPage.setAppointment()
                .continueAppointment()
                .clickUnderstand();
        TakeScreenshot("AcceptAppointment"+LocalDate.now());
    }

    private void fillMoreInformation() throws IOException {
        aLittleMoreAboutPage = new ALittleMoreAboutPage();
        TakeScreenshot("ALittleMoreAboutYou"+LocalDate.now());
        aLittleMoreAboutPage.setPhoneNumber(phoneNumber)
                .checkAppointmentCheckbox()
                .checkDiscountCheckBox();
        TakeScreenshot("ALittleMoreAboutYou"+LocalDate.now());
        aLittleMoreAboutPage.selectContinue();
    }
    private void generatePassword() throws IOException {
        createPasswordPage = new CreatePasswordPage();
        TakeScreenshot("GeneratePassword"+LocalDate.now());
        createPasswordPage.setPassword(password)
                .confirmPassword(password);
        TakeScreenshot("GeneratePassword"+LocalDate.now());
        createPasswordPage.nextPageContinue();
    }

    private void enterSmsText() throws IOException {
        didYouGetOurTextPage = new DidYouGetOurTextPage();
        didYouGetOurTextPage.setSmsCode(TwilioOTPHandle.smsMessage());
        Selenide.sleep(3000);
        TakeScreenshot("EnterSmSCode"+LocalDate.now());
        didYouGetOurTextPage .clickContinueSMS();
    }

    private void billingInfo() throws IOException {
        yourMembershipPage = new YourMembershipPage();
        TakeScreenshot("BillingInformation"+LocalDate.now());
        yourMembershipPage.continueToPayment();
    }

    private void addPaymentInformation() throws IOException {
        addPaymentPage = new AddPaymentPage();
        TakeScreenshot("AddPayment"+LocalDate.now());
        addPaymentPage.setNameOnCard("Salomon")
                .setCardNumber(cardNumber)
                .setExpiration("1223")
                .setCvcCode("123")
                .setAddressOnPayment("Address")
                .setCityText("San Diego")
                .openStateDropdown()
                .setState("California")
                .setZipCode("91910");
        TakeScreenshot("PaymentInformationAdded"+LocalDate.now());
        addPaymentPage.selectContinue();
    }

    private void getCareLandingPage() throws IOException {
        logInPage = new LogInPage();
        TakeScreenshot("LogInPage"+LocalDate.now());
    }

}
