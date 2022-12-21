package comtest.web;

import PageObjects.*;
import comtest.BaseWebTest;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    private GetCareLandingPage getCareLandingPage;
    private String email = "salomontesting"+"+"+RandomStringUtils.randomNumeric(9)+"@gmail.com";
    private String petName = faker.name().firstName();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String phoneNumber = faker.phoneNumber().cellPhone();
    private String smsText = faker.number().digits(4);
    private String password = "1234asdF@";
    private String petBreed = "Collie";
    private String cardNumber = "4242424242424242";

    @BeforeMethod
    public void setup(){
        landingPage = new LandingPage();
    }

    @Test
    public void verifyLandingPage(){
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

    private void callLandingPage(){
        landingPage.clickNext();

        assertThat(landingPage.getCaruselText(VIRTUAL_ACCESS.getCommonTexts()))
                .as("Text Should Match", VIRTUAL_ACCESS.getCommonTexts())
                .isEqualTo(VIRTUAL_ACCESS.getCommonTexts());

        assertThat(landingPage.getTextFromSecondScreen())
                .as("Text should match", SECOND_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(SECOND_SCREEN_TEXT.getCommonTexts());
    }

    private void thirdPageView(){
        landingPage.clickThirdOption();

        assertThat(landingPage.getCaruselTextSecond(NO_EXAMS.getCommonTexts()))
                .as("Text Should Match", NO_EXAMS.getCommonTexts())
                .isEqualTo(NO_EXAMS.getCommonTexts());

        assertThat(landingPage.getTextFromLastScreen())
                .as("Text Should Match", THIRD_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(THIRD_SCREEN_TEXT.getCommonTexts());
    }

    private void getStartedPage(){
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
    }
    private void selectLocationAndSignUp(){
        enterPetDetailsPage = locationPage.clickLocationCard()
                .clickNotAnEmergency()
                .setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setUserEmail(email)
                .markCheckBox()
                .clickContinue();
    }

    private void isBreedEnabled(){
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isFalse();
    }
    private void fillPetInformation(){
        enterPetDetailsPage.setPetName(petName)
                .selectDog()
                .selectMale()
                .uploadImage()
                .setAge("1","0","0");
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isTrue();
        enterPetDetailsPage.enterBreed(petBreed)
                .selectBreedOption()
                .selectContinue();
    }

    private void selectAppointment(){
        chooseAppointmentPage = new ChooseAppointmentPage();
        chooseAppointmentPage.getAppointmentOptions();
        chooseAppointmentPage.setAppointment()
                .continueAppointment()
                .clickUnderstand();
    }

    private void fillMoreInformation(){
        aLittleMoreAboutPage = new ALittleMoreAboutPage();
        aLittleMoreAboutPage.setPhoneNumber(phoneNumber)
                .checkAppointmentCheckbox()
                .checkDiscountCheckBox()
                .selectContinue();
    }
    private void generatePassword(){
        createPasswordPage = new CreatePasswordPage();
        createPasswordPage.setPassword(password)
                .confirmPassword(password)
                .nextPageContinue();
    }

    private void enterSmsText(){
        didYouGetOurTextPage = new DidYouGetOurTextPage();
        didYouGetOurTextPage.setSmsCode(smsText)
                .clickContinueSMS();
    }

    private void billingInfo(){
        yourMembershipPage = new YourMembershipPage();
        yourMembershipPage.continueToPayment();
    }

    private void addPaymentInformation(){
        addPaymentPage = new AddPaymentPage();
        addPaymentPage.setNameOnCard("Salomon")
                .setCardNumber(cardNumber)
                .setExpiration("1223")
                .setCvcCode("123")
                .setAddressOnPayment("Address")
                .setCityText("San Diego")
                .openStateDropdown()
                .setState("California")
                .setZipCode("91910")
                .selectContinue();
    }

    private void getCareLandingPage(){
        getCareLandingPage = new GetCareLandingPage();
    }

}
