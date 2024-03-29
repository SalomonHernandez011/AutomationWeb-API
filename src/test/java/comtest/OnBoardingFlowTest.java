package comtest;

import PageObjects.*;
import Util.DogBreedListGenerator;
import Util.TwilioOTPHandle;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.twilio.Twilio;
import dataProvider.ConfigFileReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;

import static constants.CommonProperties.PROVET_EMAIL;
import static constants.CommonTexts.*;
import static constants.CreditCardVariations.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OnBoardingFlowTest extends BaseWebTest {
    Faker faker = new Faker();
    Faker fakerBreeds = new DogBreedListGenerator();
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
    private LogInPage logInPage;
    private ProVetCloudLogInPage proVetCloudLogInPage;
    private ProvetDashboardPage provetDashboardPage;
    private SickPetPage sickPetPage;
    private ChatPage chatPage;
    private NavigationMenu navigationMenu;
    private String email = "parkertestingace"+"+"+RandomStringUtils.randomNumeric(9)+"@gmail.com";
    private String petName = faker.pokemon().name();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String phoneNumber = "3396752234";
    private String password = "1234asdF@";
    private String petBreed = "Collie";
    private String cardNumber = "4242424242424242";
    public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = "";

    @BeforeMethod
    public void setup() {
        landingPage = new LandingPage();
        TakeScreenshot("Onboarding");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
    protected void callLandingPage() {
        landingPage.clickNext();

        assertThat(landingPage.getCaruselText(VIRTUAL_ACCESS.getCommonTexts()))
                .as("Text Should Match", VIRTUAL_ACCESS.getCommonTexts())
                .isEqualTo(VIRTUAL_ACCESS.getCommonTexts());

        assertThat(landingPage.getTextFromSecondScreen())
                .as("Text should match", SECOND_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(SECOND_SCREEN_TEXT.getCommonTexts());
        TakeScreenshot("OnBoarding");
    }
    protected void thirdPageView() {
        landingPage.clickThirdOption();

        assertThat(landingPage.getCaruselTextSecond(NO_EXAMS.getCommonTexts()))
                .as("Text Should Match", NO_EXAMS.getCommonTexts())
                .isEqualTo(NO_EXAMS.getCommonTexts());

        assertThat(landingPage.labsText(THIRD_SCREEN_TEXT))
                .as("Text Should Match", THIRD_SCREEN_TEXT.getCommonTexts())
                .isEqualTo(THIRD_SCREEN_TEXT.getCommonTexts());
        TakeScreenshot("OnBoarding");
    }

    protected void getStartedPage() {
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
    protected void selectLocationAndSignUp() {
        locationPage = new LocationPage();
         locationPage.clickLocationCard()
                .clickNotAnEmergency();
    aLittleAboutYouPage = new ALittleAboutYouPage();
        TakeScreenshot("OnBoarding");
        aLittleAboutYouPage.setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setUserEmail(email);
        Selenide.sleep(1000);
        TakeScreenshot("OnBoarding");
        aLittleAboutYouPage.clickContinue();
        TakeScreenshot("OnBoarding");
    }

    protected void isBreedEnabled() {
        enterPetDetailsPage = new EnterPetDetailsPage();
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isFalse();
    }
    protected void fillPetInformation(String pet, String gender, String breed) {
        enterPetDetailsPage.setPetName(petName)
                .selectPet(pet)
                .selectGender(gender);
        enterPetDetailsPage.uploadImage(pet)
                .setAge("","","21");
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isTrue();
        enterPetDetailsPage.enterBreed(breed)
                .selectBreedOption();
        TakeScreenshot("OnBoarding");

    }

    protected void spayedTransfered(String spayed){
        enterPetDetailsPage.spayedSelect(spayed);
        TakeScreenshot("OnBoarding");
    }

    protected void otherVet(boolean otherVet){
        if(otherVet == true){
            vetInfo();
        }else{
            enterPetDetailsPage.selectContinue();
        }
    }

    protected void vetInfo(){
        enterPetDetailsPage.otherVet()
                .vetInfo("Test Vet Name")
                .vetNumber(phoneNumber);
        TakeScreenshot("OnBoarding");
        enterPetDetailsPage.selectContinue();
    }

    protected void selectAppointment(boolean sick) {
        chooseAppointmentPage = new ChooseAppointmentPage();
        chooseAppointmentPage.sickOption(sick);
        //will need to add selector for choose available appointment automagically still not done by FE
        TakeScreenshot("OnBoarding");
        chooseAppointmentPage.getAppointmentOptions();
        TakeScreenshot("OnBoarding");
        chooseAppointmentPage.setAppointment();
        TakeScreenshot("OnBoarding");
        chooseAppointmentPage.continueAppointment();
        TakeScreenshot("OnBoarding");
        appointmentHeldPopUp = new AppointmentHeldPopUp();
        appointmentHeldPopUp.clickUnderstand();
        TakeScreenshot("OnBoarding");
    }

    protected void fillMoreInformation() {
        aLittleMoreAboutPage = new ALittleMoreAboutPage();
        TakeScreenshot("OnBoarding");
        aLittleMoreAboutPage.setPhoneNumber(phoneNumber);
//                .checkAppointmentCheckbox()
//                .checkDiscountCheckBox();
        Selenide.sleep(1000);
        TakeScreenshot("OnBoarding");
        aLittleMoreAboutPage.selectContinue();
    }
    protected void generatePassword() {
        createPasswordPage = new CreatePasswordPage();
        TakeScreenshot("OnBoarding");
        createPasswordPage.setPassword(password)
                .confirmPassword(password);
        TakeScreenshot("OnBoarding");
        createPasswordPage.nextPageContinue();
    }

    protected void enterSmsText() {
        didYouGetOurTextPage = new DidYouGetOurTextPage();
        TakeScreenshot("OnBoarding");
        Selenide.sleep(3000);
        didYouGetOurTextPage.setSmsCode(TwilioOTPHandle.smsMessage());
        TakeScreenshot("OnBoarding");
        didYouGetOurTextPage .clickContinueSMS();
    }

    protected void billingInfo() {
        yourMembershipPage = new YourMembershipPage();
        TakeScreenshot("OnBoarding");
        yourMembershipPage.continueToPayment();
    }

    protected void addPaymentInformation(String creditCard) {
        addPaymentPage = new AddPaymentPage();
        TakeScreenshot("OnBoarding");
        addPaymentPage.setNameOnCard("Salomon");

        if(creditCard.equalsIgnoreCase("valid")) {
            addPaymentPage.setCardNumber(VALID_CREDIT_CARD.getCreditCard());
        }
        else if(creditCard.equalsIgnoreCase("declined")){
            addPaymentPage.setCardNumber(DECLINES_CREDIT_CARD.getCreditCard());

        }
        else if(creditCard.equalsIgnoreCase("no funds")){
            addPaymentPage.setCardNumber(NOFUNDS_CREDIT_CARD.getCreditCard());

        }
        else if(creditCard.equalsIgnoreCase("expired")){
            addPaymentPage.setCardNumber(EXPIRED_CREDIT_CARD.getCreditCard());
        }
        else if(creditCard.equalsIgnoreCase("incorrectCvc")){
            addPaymentPage.setCardNumber(INCORRECT_CVC.getCreditCard());
        }
        else{
            addPaymentPage.setCardNumber(PROCESS_ERROR_CC.getCreditCard());
        }
        addPaymentPage.setExpiration("1255")
                .setCvcCode("123")
                .setAddressOnPayment("Address")
                .setCityText("San Diego")
                .openStateDropdown()
                .setState("California")
                .setZipCode("91910");
        TakeScreenshot("OnBoarding");
        addPaymentPage.selectContinue();
    }
    protected void getCareLandingPage() {
        getCareLandingPage = new GetCareLandingPage();
        TakeScreenshot("OnBoarding");
    }
    protected void petProfileSection(){
        navigationMenu = new NavigationMenu();
        navigationMenu.clickPetSection();
        Selenide.sleep(2000);
        TakeScreenshot("OnBoarding");
    }

    protected void openProvet(){
        openProVetBrowser();
        proVetCloudLogInPage = new ProVetCloudLogInPage();
        proVetCloudLogInPage.enterUsername(ConfigFileReader.getProperty(PROVET_EMAIL))
                .enterPassword("salomones100%cabron")
                .clickLogIn();
        provetDashboardPage = new ProvetDashboardPage();
        provetDashboardPage.allAppointments();
        provetDashboardPage.searchCreatedAppointment(firstName+ " "+lastName);
        Selenide.sleep(2000);
        provetDashboardPage.clickPetParent(firstName,lastName);
        Selenide.sleep(2000);
        TakeScreenshot("OnBoarding");

    }

    protected void sickScreen(){
        sickPetPage = new SickPetPage();
        TakeScreenshot("OnBoarding");
        sickPetPage.clickSickButton();
        TakeScreenshot("OnBoarding");
        chatPage = new ChatPage();
        chatPage.chatText("Test Sick OnBoarding Message");
        chatPage.sendMessage();

    }
}
