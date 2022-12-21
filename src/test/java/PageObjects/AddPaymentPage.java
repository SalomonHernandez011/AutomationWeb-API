package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import comtest.BasePageObject;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class AddPaymentPage extends BasePageObject {
    private final SelenideElement nameOnCard = $("#apmp-name-card-input");
    private final SelenideElement cardNumber = $x("//*[contains(@name, 'cardnumber')]");
    private final SelenideElement expirationText = $x("//*[contains(@name, 'exp-date')]");
    private final SelenideElement cvcText = $x("//*[contains(@name, 'cvc')]");
    private final SelenideElement addressText = $("#apmp-address-input");
    private final SelenideElement cityText = $("#apmp-city-input");
    private final SelenideElement stateDropdown = $("div[class=' css-9485xe-control']");
    private final SelenideElement zipCodeText = $("#apmp-zip-code-input");
    private final SelenideElement continueFromPayment = $("#apmp-continue-button");
    private final SelenideElement frame = $x("//iframe[contains(@name,'__privateStripeFrame')]");
    private final SelenideElement frameExp = $x("//iframe[@title='Secure expiration date input frame']");
    private final SelenideElement frameCvc = $x("//iframe[@title='Secure CVC input frame']");
    private final SelenideElement selectState = $x("//div[contains(text(),'California')]");

    public AddPaymentPage() {
        assertTrue(isOpened(), "Payment Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(nameOnCard, continueFromPayment);
    }

    public AddPaymentPage setNameOnCard(String cardName){
        nameOnCard.setValue(cardName);
        return this;
    }

    public AddPaymentPage setCardNumber(String cardNum){
        switchTo().frame(frame);
        cardNumber.setValue(cardNum);
        switchTo().defaultContent();
        return this;
    }

    public AddPaymentPage setExpiration(String expiration){
        switchTo().frame(frameExp);
        expirationText.setValue(expiration);
        switchTo().defaultContent();
        return this;
    }

    public AddPaymentPage setCvcCode(String cvc){
        switchTo().frame(frameCvc);
        cvcText.setValue(cvc);
        switchTo().defaultContent();
        return this;
    }

    public AddPaymentPage setAddressOnPayment(String address){
        isElementWithTextDisplayedAndScrollToIt("Address");
        addressText.setValue(address);
        return this;
    }

    public AddPaymentPage setCityText(String city){
        cityText.setValue(city);
        return this;
    }

    public AddPaymentPage openStateDropdown(){
        stateDropdown.click();
        return this;
    }

    public AddPaymentPage setZipCode(String zip){
        zipCodeText.setValue(zip);
        return this;
    }

    public AddPaymentPage setState(String expectedText){
        SelenideElement state = $x(format("//*[contains(text(), \"%s\")]", expectedText));
        state.scrollIntoView(true);
        state.click();
        return this;
    }

    public void selectContinue(){
        continueFromPayment.click();
    }
}
