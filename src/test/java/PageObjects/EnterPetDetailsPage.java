package PageObjects;

import comtest.BasePageObject;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;


import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class EnterPetDetailsPage extends BasePageObject {
    private final SelenideElement petDetailsTitle = $("span[class='text-3-xl-highway-series-9']");
    private final SelenideElement petDetailsContinueButton = $("#aapp-continue-button");
    private final SelenideElement petNameField = $("#aapp-pet-name-input");
    private final SelenideElement dogOption = $("#option-dog-animaltype");
    private final SelenideElement catOption = $("#option-cat-animaltype");
    private final SelenideElement maleOption = $("#option-male-gender");
    private final SelenideElement femaleOption = $("#option-female-gender");
    private final SelenideElement uploadPhoto = $("input[id='aapp-photo-pet-input']");
    private final SelenideElement calendarOption = $("input[name='petsBirthDay']");
    private final SelenideElement breedOptions = $("#aapp-breed-auto-fill");
    private final SelenideElement spayedYes = $("#option-yes-spayedorneutered");
    private final SelenideElement spayedNo = $("#option-no-spayedorneutered");
    private final SelenideElement spayedNotSure = $("div[id^='option-not']");
    private final SelenideElement otherVetYes = $("div[id='option-yes-transferpetanotherveterinay']");
    private final SelenideElement skipOption = $("#option-skip-transferpetanotherveterinayp");
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
    public EnterPetDetailsPage selectPet(String pet){
        if (pet.equalsIgnoreCase("Dog")){
            dogOption.click();
        }else{
            catOption.click();
        }
        return this;
    }
    public EnterPetDetailsPage selectCat(){
        catOption.click();
        return this;
    }
    public EnterPetDetailsPage selectGender(String gender){
        if(gender.equalsIgnoreCase("Male")){
            maleOption.click();
        }else{
            femaleOption.click();
        }
        return this;
    }
    public EnterPetDetailsPage otherVet(){
        otherVetYes.click();
        return this;
    }
    public EnterPetDetailsPage vetInfo(String vet){
        vetName.setValue(vet);
        return this;
    }
    public EnterPetDetailsPage vetNumber(String vetNum){
        vetNumber.setValue(vetNum);
        return this;
    }
    public EnterPetDetailsPage spayedSelect(String option){
        if(option.equalsIgnoreCase("Yes")){
            spayedYes.click();
        }else if (option.equalsIgnoreCase("No")){
            spayedNo.click();
        }else if (option.equalsIgnoreCase("Not Sure")){
            spayedNotSure.click();
        }
        return this;
    }

    public EnterPetDetailsPage selectFemale(){
        femaleOption.click();
        return this;
    }
    public EnterPetDetailsPage uploadImage(String pet){
        if(pet.equalsIgnoreCase("dog")) {
            uploadPhoto.sendKeys(System.getProperty("user.dir") + "/Pictures/collie.jpg");
        }else if(pet.equalsIgnoreCase("cat")){
            uploadPhoto.sendKeys(System.getProperty("user.dir") + "/Pictures/cat.jpg");
        }
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
