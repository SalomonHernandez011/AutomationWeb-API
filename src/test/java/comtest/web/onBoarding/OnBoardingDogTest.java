package comtest.web.onBoarding;

import Util.DogBreedListGenerator;
import comtest.OnBoardingFlowTest;
import org.testng.annotations.Test;

public class OnBoardingDogTest extends OnBoardingFlowTest {
    DogBreedListGenerator dogBreedListGenerator = new DogBreedListGenerator();
    private final String dogBreed = dogBreedListGenerator.dogBreed();
    @Test
    public void dogTest(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Dog", "Male", dogBreed);
        spayedTransfered("Not sure");
        otherVet(false);
        selectAppointment(false);
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation("Valid");
        getCareLandingPage();
        petProfileSection();
        openProvet();
    }
}