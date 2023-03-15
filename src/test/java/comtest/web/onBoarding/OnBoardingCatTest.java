package comtest.web.onBoarding;

import Util.DogBreedListGenerator;
import comtest.OnBoardingFlowTest;
import org.testng.annotations.Test;

public class OnBoardingCatTest extends OnBoardingFlowTest {
    DogBreedListGenerator dogBreedListGenerator = new DogBreedListGenerator();
    private String dogBreed = dogBreedListGenerator.dogBreed();
    @Test
    public void maleCatTest(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Cat", "Male", "Siamese");
        spayedTransfered("Not Sure");
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
