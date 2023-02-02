package comtest.web.onBoarding;

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
        otherVet(true);
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
