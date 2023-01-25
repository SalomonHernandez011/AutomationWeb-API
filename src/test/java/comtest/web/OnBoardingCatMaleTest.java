package comtest.web;

import org.testng.annotations.Test;

public class OnBoardingCatMaleTest extends OnBoardingFlowTest{
    @Test
    public void maleCatTest(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Cat", "Male", "Siamese");
        selectAppointment(false);
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation();
        logInWithCreds();
        getCareLandingPage();
        openProvet();
    }
}
