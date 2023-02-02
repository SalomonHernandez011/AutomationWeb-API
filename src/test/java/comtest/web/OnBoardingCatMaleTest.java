package comtest.web;

import comtest.OnBoardingFlowTest;
import org.testng.annotations.Test;

public class OnBoardingCatMaleTest extends OnBoardingFlowTest {
    @Test
    public void maleCatTest(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Cat", "Male", "Siamese");
        spayedTransfered("No");
        otherVet(false);
        selectAppointment(false);
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation();
        getCareLandingPage();
        openProvet();
    }
}
