package PageObjects;

import com.codeborne.selenide.SelenideElement;
import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import comtest.BasePageObject;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class AddPaymentPage extends BasePageObject {
    private final SelenideElement nameOnCard = $("#apmp-name-card-input");
    private final SelenideElement cardNumber = $("div[class^='StripeElement']");
    private final SelenideElement expirationText = $("div[class='multi-input first-input StripeElement StripeElement--empty']");
    private final SelenideElement cvcText = $("div[class='multi-input second-input StripeElement StripeElement--empty']");
    private final SelenideElement addressText = $("#apmp-address-input");
    private final SelenideElement cityText = $("#apmp-city-input");
    private final SelenideElement stateDropdown = $("div[class=' css-9485xe-control']");
    private final SelenideElement zipCodeText = $("#apmp-zip-code-input");
    private final SelenideElement continueFromPayment = $("#apmp-continue-button");

    public AddPaymentPage() {
        assertTrue(isOpened(), "Payment Page is opened");
    }

    public boolean isOpened() {
        return isPageObjectLoaded(nameOnCard, cardNumber);
    }

    public AddPaymentPage setNameOnCard(String cardName){
        nameOnCard.setValue(cardName);
        return this;
    }

    public AddPaymentPage setCardNumber(String cardNum){
        cardNumber.setValue(cardNum);
        return this;
    }

    public AddPaymentPage setExpiration(String expiration){
        expirationText.setValue(expiration);
        return this;
    }

    public AddPaymentPage setCode(String code){
        cvcText.setValue(code);
        return this;
    }

    public AddPaymentPage setAddressOnPayment(String address){
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

    //Need to add a method to click on option from dropdown or use the same as above to perform both actions

    public AddPaymentPage setZipCode(String zip){
        zipCodeText.setValue(zip);
        return this;
    }

    public void selectContinue(){
        continueFromPayment.click();
    }
}
