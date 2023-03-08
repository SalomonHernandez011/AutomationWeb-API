package comtest.web.onBoarding;

import Util.DogBreedListGenerator;
import comtest.OnBoardingFlowTest;
import org.testng.annotations.Test;

public class OnBoardingCatMaleTest extends OnBoardingFlowTest {
    DogBreedListGenerator dogBreedListGenerator = new DogBreedListGenerator();
    private String dogBreed = dogBreedListGenerator.dogBreed();
    @Test
    public void maleCatTest(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Cat", "Female", dogBreed);
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
