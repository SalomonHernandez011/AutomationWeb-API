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
        selectAppointment();
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation();
        getCareLandingPage();
    }
}
