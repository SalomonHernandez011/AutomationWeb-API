package comtest.web.onBoarding.creditCardErrors;

import Util.DogBreedListGenerator;
import comtest.OnBoardingFlowTest;
import org.testng.annotations.Test;

public class DeclinedCreditCardTest extends OnBoardingFlowTest {
    DogBreedListGenerator dogBreedListGenerator = new DogBreedListGenerator();
    private String dogBreed = dogBreedListGenerator.dogBreed();
    @Test
    public void dogTest() {
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Dog", "Male", dogBreed);
        spayedTransfered("No");
        otherVet(false);
        selectAppointment(false);
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation("Declined");
        getCareLandingPage();
    }
}
