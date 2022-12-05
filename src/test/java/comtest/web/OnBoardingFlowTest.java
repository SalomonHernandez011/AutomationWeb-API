package comtest.web;

import comtest.BaseWebTest;
import PageObjects.ALittleAboutYouPage;
import PageObjects.EnterPetDetailsPage;
import PageObjects.LandingPage;
import PageObjects.RegistrationPage;
import com.codeborne.selenide.testng.ScreenShooter;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({ ScreenShooter.class})
public class OnBoardingFlowTest extends BaseWebTest {
    Faker faker = new Faker();
    private LandingPage landingPage;
    private RegistrationPage registrationPage;
    private ALittleAboutYouPage aLittleAboutYouPage;
    private EnterPetDetailsPage enterPetDetailsPage;
    private final String SecondScreenText = "Our TeleHealth team is ready to connect any time you have questions.";
    private final String ThirdStringText = "*Labs, Diagnostics, and Medications not included.";
    private String email = "salomontesting"+"+"+RandomStringUtils.randomNumeric(2)+"@gmail.com";
    private String petName = faker.name().firstName();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String petBreed = "Collie";

    @BeforeMethod
    public void setup(){
        landingPage = new LandingPage();
    }

    @Test
    public void verifyLandingPage(){
        callLandingPage();
        thirdPageView();
        getStartedPage();
        selectLocationAndSignUp();
        isBreedEnabled();
        fillPetInformation();

    }
    private void callLandingPage(){
        landingPage.clickNext();
        assertThat(landingPage.getTextFromSecondScreen())
                .as("Text should match", SecondScreenText)
                .isEqualTo(SecondScreenText);
    }
    private void thirdPageView(){
        landingPage.clickThirdOption();
        assertThat(landingPage.getTextFromLastScreen())
                .as("Text Should Match", ThirdStringText)
                .isEqualTo(ThirdStringText);
    }
    private void getStartedPage(){
        registrationPage = landingPage.getStartedSelect()
                .clearZipField()
                .setTextToZip("20002");
        assertThat(registrationPage.locationCard())
                .isTrue();
    }
    private void selectLocationAndSignUp(){
        enterPetDetailsPage = registrationPage.clickLocationCard()
                .clickNotAnEmergency()
                .setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setUserEmail(email)
                .markCheckBox()
                .clickContinue();
    }

    private void isBreedEnabled(){
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isFalse();
    }
    private void fillPetInformation(){
        enterPetDetailsPage.setPetName(petName)
                .selectDog()
                .selectMale()
                .uploadImage()
                .setAge("1","0","0");
        assertThat(enterPetDetailsPage.breedEnabled())
                .as("It should be disabled")
                .isTrue();
        enterPetDetailsPage.enterBreed(petBreed)
                .selectBreedOption()
                .selectContinue();
    }

}
