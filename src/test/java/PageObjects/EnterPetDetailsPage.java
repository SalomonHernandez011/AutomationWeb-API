package PageObjects;

import comtest.BasePageObject;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;


import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class EnterPetDetailsPage extends BasePageObject {
    private final SelenideElement petDetailsTitle = $("div[class^='highway-9']");
    private final SelenideElement petDetailsContinueButton = $("#aapp-continue-button");
    private final SelenideElement petNameField = $("#aapp-pet-name-input");
    private final SelenideElement dogOption = $("#option-dog-animaltype");
    private final SelenideElement catOption = $("#option-cat");
    private final SelenideElement maleOption = $("#option-male-gender");
    private final SelenideElement femaleOption = $("#option-cat");
    private final SelenideElement uploadPhoto = $("input[id='aapp-photo-pet-input']");
    private final SelenideElement calendarOption = $("input[name='petsBirthDay']");
    private final SelenideElement breedOptions = $("#aapp-breed-auto-fill");
    private final SelenideElement spayedYes = $("");
    private final SelenideElement spayedNo = $("");
    private final SelenideElement spayedNotSure = $("div[id^='option-not']");
    private final SelenideElement otherYes = $("");
    private final SelenideElement skipOption = $("#option-skip");
    private final SelenideElement vetName = $("#aapp-veterinary-name-input");
    private final SelenideElement vetNumber = $("#aapp-veterinary-phone-input");
    private final SelenideElement breedFirstOptionDropdown = $("#aapp-breed-auto-fill-option-1");
    private final SelenideElement setYear = $("input[placeholder='Years']");
    private final SelenideElement setMonth = $("input[placeholder='Months']");
    private final SelenideElement setDays = $("input[placeholder='Days']");

    public EnterPetDetailsPage() {
        assertTrue(isOpened(), "Enter pet details is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(petDetailsTitle, petDetailsContinueButton);
    }

    public EnterPetDetailsPage setPetName(String name){
        petNameField.setValue(name);
        return this;
    }
    public EnterPetDetailsPage selectDog(){
        dogOption.click();
        return this;
    }
    public EnterPetDetailsPage selectCat(){
        catOption.click();
        return this;
    }
    public EnterPetDetailsPage selectMale(){
        maleOption.click();
        return this;
    }
    public EnterPetDetailsPage selectFemale(){
        femaleOption.click();
        return this;
    }
    public EnterPetDetailsPage uploadImage(){
        uploadPhoto.sendKeys("C:\\Users\\Salomon\\Pictures\\220805-border-collie-play-mn-1100-82d2f1.jpg");
        return this;
    }
    public EnterPetDetailsPage enterBreed(String breed){
        setValueToTextField(breedOptions, breed);
        return this;
    }
    public EnterPetDetailsPage selectBreedOption(){
        breedFirstOptionDropdown.click();
        return this;
    }
    public EnterPetDetailsPage setAge(String year, String month, String days){
        setYear.setValue(year);
        setMonth.setValue(month);
        setDays.setValue(days);
        return this;
    }
    public void selectContinue(){
        petDetailsContinueButton.click();
    }
    public boolean breedEnabled(){
        return breedOptions.isEnabled();
    }
}
