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
        fillPetInformation("Dog", "Male", "Maltipoo");
        spayedTransfered("No");
        otherVet(false);
        selectAppointment(false);
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation();
        getCareLandingPage();
        petProfileSection();
        openProvet();
    }
}
