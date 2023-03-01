package PageObjects;

import comtest.BasePageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ALittleAboutYouPage extends BasePageObject {
    private final SelenideElement firstNameField = $("#almayp-first-name-input");
    private final SelenideElement lastNameField = $("#almayp-last-name-input");
    private final SelenideElement userEmail = $("#almayp-email-input");
    private final SelenideElement littleCheckbox = $("span[class='checkmark']");
    private final SelenideElement littleContinueButton = $("button[id='almayp-continue-button']");
    private final SelenideElement alreadyMemberLink = $("a[class*='already-member']");
    private final SelenideElement emailError = $("span[class*='error']");


    public ALittleAboutYouPage() {
        assertTrue(isOpened(), "A little about you Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(firstNameField, lastNameField);
    }

    public ALittleAboutYouPage setFirstNameField(String name){
        firstNameField.setValue(name);
        return this;
    }

    public ALittleAboutYouPage setLastNameField(String lastname){
        lastNameField.setValue(lastname);
        return this;
    }

    public ALittleAboutYouPage setUserEmail(String email){
        userEmail.setValue(email);
        return this;
    }

    public ALittleAboutYouPage markCheckBox(){
        littleCheckbox.click();
        return this;
    }
    public boolean checkboxIsMarked(){
        return littleCheckbox.isSelected();
    }

    public EnterPetDetailsPage clickContinue(){
        waitUntilElementCondition(littleContinueButton, Condition.interactable, shortWait);
        littleContinueButton.click();
        return new EnterPetDetailsPage();
    }
    public String  errorEmailMsg(){
        return emailError.getText();
    }

    public LogInPage clickAlreadyMember(){
        alreadyMemberLink.click();
        return new LogInPage();
    }
}
