package comtest.web;

import PageObjects.*;
import comtest.BaseWebTest;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.CommonTexts.SECOND_SCREEN_TEXT;
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
    private final String secondScreenText = "Our TeleHealth team is ready to connect any time you have questions.";
    private final String thirdStringText = "*Labs, Diagnostics, and Medications not included.";
    private final String virtualAccess = "24/7 Virtual Access";
    private final String noExams = "No Exam Fees";
    private final String locInstruction = "To find the location nearest to you, please enter your zip code or enable location services on your device.";
    private final String zipText = "Enter Zip to display available locations";
    private String email = "salomontesting"+"+"+RandomStringUtils.randomNumeric(2)+"@gmail.com";
    private String petName = faker.name().firstName();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String phoneNumber = faker.phoneNumber().cellPhone();
    private String smsText = faker.number().digits(4);
    private String password = "1234asdF@";
    private String petBreed = "Collie";

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
    }

    private void callLandingPage(){
        landingPage.clickNext();

        assertThat(landingPage.getCaruselText(virtualAccess))
                .as("Text Should Match", virtualAccess)
                .isEqualTo(virtualAccess);

        assertThat(landingPage.getTextFromSecondScreen())
                .as("Text should match", SECOND_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(SECOND_SCREEN_TEXT.getCommonTexts());
    }

    private void thirdPageView(){
        landingPage.clickThirdOption();

        assertThat(landingPage.getCaruselTextSecond(noExams))
                .as("Text Should Match", noExams)
                .isEqualTo(noExams);

        assertThat(landingPage.getTextFromLastScreen())
                .as("Text Should Match", thirdStringText)
                .isEqualTo(thirdStringText);
    }

    private void getStartedPage(){
        locationPage = landingPage.getStartedSelect()
                .clearZipField()
                .setTextToZip("20002");

        assertThat(locationPage.subLocText())
                .as("Text Should Match", locInstruction)
                .isEqualTo(locInstruction);

        assertThat(locationPage.subZipText())
                .as("Text Should Match", zipText)
                .isEqualTo(zipText);

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

}
