package comtest.web;

import comtest.OnBoardingFlowTest;
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
        spayedTransfered("Yes");
        otherVet(true);
        selectAppointment(true);
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation();
        sickScreen();
        getCareLandingPage();
        openProvet();
    }
}
