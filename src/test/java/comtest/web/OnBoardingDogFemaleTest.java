package comtest.web;

import org.testng.annotations.Test;

public class OnBoardingDogFemaleTest extends OnBoardingFlowTest {

    @Test
    public void femaleDogTest(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Dog", "Female", "Collie");
        selectAppointment();
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation();
        getCareLandingPage();
    }
}
