package comtest.web.onBoarding;

import Util.CatBreedGenerator;
import Util.DogBreedListGenerator;
import comtest.OnBoardingFlowTest;
import org.testng.annotations.Test;

public class OnBoardingCatTest extends OnBoardingFlowTest {
    CatBreedGenerator catBreedGenerator = new CatBreedGenerator();
    private final String catBreed = catBreedGenerator.catBreed();
    @Test
    public void maleCatTest(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation("Cat", "Male", catBreed);
        spayedTransfered("Not Sure");
        otherVet(true);
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
