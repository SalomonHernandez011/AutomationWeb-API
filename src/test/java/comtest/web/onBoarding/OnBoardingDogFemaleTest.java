package comtest.web.onBoarding;

import Util.DogBreedListGenerator;
import comtest.OnBoardingFlowTest;
import org.testng.annotations.Test;

public class OnBoardingDogFemaleTest extends OnBoardingFlowTest {
    DogBreedListGenerator dogBreedListGenerator = new DogBreedListGenerator();
    private final String dogBreed = dogBreedListGenerator.dogBreed();
    @Test
    public void femaleDogTest(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Dog", "Female", dogBreed);
        spayedTransfered("No");
        otherVet(false);
        selectAppointment(true);
        fillMoreInformation();
        generatePassword();
        enterSmsText();
        billingInfo();
        addPaymentInformation("Valid");
        sickScreen();
        getCareLandingPage();
        openProvet();
    }
}
