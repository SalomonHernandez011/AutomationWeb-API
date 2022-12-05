package comtest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static org.openqa.selenium.Keys.*;
import static java.util.stream.LongStream.range;

public abstract class BasePageObject {

    public final long sleep = Long.parseLong("1000");

    public final long pageWait = Long.parseLong("5000");

    public final long shortWait = Long.parseLong("3000");

    public final long longWait = Long.parseLong("7000");

    protected String[] UNWANTED_ERRORS = {".*4[0-9][0-9].*", ".*5[0-9][0-9].*", ".*upstream.*", ".*error.*"};

    public BasePageObject() {
    }

    public abstract boolean isOpened();

    protected void waitUntilElementCondition(SelenideElement element, Condition condition, long waitTimeOut) {
        try {
            element.should(condition, Duration.ofMillis(waitTimeOut));
        } catch (AssertionError e) {
            // do nothing, so we can continue even if we don't meet condition
        }
    }

    protected boolean isElementCondition(SelenideElement element, Condition condition, long waitTimeOut) {
        if (condition == exist) {
            waitUntilElementCondition(element, condition, waitTimeOut);
        } else {
            try {
                waitUntilElementCondition(element, condition, waitTimeOut);
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        // Scroll into view for evidence collection
        if (condition != exist && element.exists()) {
            // TODO: This is causing issues on mobile?
            //element.scrollIntoView(true);
        }
        return element.is(condition);
    }

    // TODO: Add more conditions as needed
    protected boolean isElementDisplayed(SelenideElement element) {
        return isElementCondition(element, visible, shortWait);
    }

    protected boolean isElementEnabled(SelenideElement element) {
        return isElementCondition(element, enabled, shortWait);
    }

    protected boolean doesElementContainAttribute(SelenideElement element, String attribute, String value) {
        return isElementCondition(element, attribute(attribute, value), shortWait);
    }

    protected boolean isElementDisabled(SelenideElement element) {
        return isElementCondition(element, disabled, shortWait);
    }

    protected boolean isElementChecked(SelenideElement element) {
        return isElementCondition(element, checked, shortWait);
    }

    protected boolean doesElementExist(SelenideElement element) {
        return isElementCondition(element, exist, shortWait);
    }

    protected boolean doesElementContainText(SelenideElement element, String text) {
        return isElementCondition(element, text(text), shortWait);
    }

    protected boolean doesElementContainValue(SelenideElement element, String value) {
        return isElementCondition(element, value(value), shortWait);
    }

    protected boolean doesElementMatchExactText(SelenideElement element, String text) {
        return isElementCondition(element, exactText(text), shortWait);
    }

    public boolean isElementWithTextDisplayed(String expectedText) {
        return isElementDisplayed($x(format("//*[contains(text(),'%1$s') " +
                "or contains(@value, '%1$s') " +
                "or contains(@text, '%1$s')]", expectedText)));
    }

    public boolean isElementWithTextExist(String expectedText) {
        return isElementCondition($x(format("//*[contains(text(), '%s')]", expectedText)), exist, 2000);
    }

    public boolean isElementWithTextDisplayedAndScrollToIt(String expectedText) {
        SelenideElement element = $x(format("//*[contains(text(), '%s')]", expectedText));
        element.scrollIntoView(true);
        return isElementDisplayed(element);
    }

    /**
     * Checks whether a page is loaded by validating on two elements on the page
     *
     * @param elementOne - Header of page
     * @param elementTwo - A second element for verification
     * @return - Whether both elements are displayed, IE that the page is loaded
     */
    protected boolean isPageObjectLoaded(SelenideElement elementOne, SelenideElement elementTwo) {
        String returnString = "";
        boolean elOneDisplayed = isElementCondition(elementOne, visible, longWait);
        if (!elOneDisplayed) {
            System.out.println(elementOne.toString() + " is not displayed");
        }
        boolean elTwoDisplayed = isElementCondition(elementTwo, visible, longWait);
        if (!elTwoDisplayed) {
            System.out.println(elementTwo.toString() + " is not displayed");
        }
        return elOneDisplayed && elTwoDisplayed;
    }

    protected void setTextToHTMLWithJS(String text, SelenideElement element) {
        executeJavaScript("arguments[0].innerHTML = '" + text + "'", element);
    }

    public static void clearInputByKeysForSystem(SelenideElement element) {
        sendSelectAllKeys(element);
        element.sendKeys(chord(DELETE));
    }

    public static void sendSelectAllKeys(SelenideElement element) {
        element.click();
        element.sendKeys(chord(getControlCommand(), "a"));
    }

    private static CharSequence getControlCommand() {
        return  (isSystem("Windows") || isSystem("Linux")) ? CONTROL : COMMAND;
    }

    private static boolean isSystem(String system) {
        return System.getProperty("os.name").startsWith(system);
    }

    public void setValueToTextField(SelenideElement element, String s) {
        //For some reason Selenium clear() ans setValue() is not clearing the text box (bug 574), so doing it with this way:
        var fieldValue = element.shouldBe(visible).getValue();
        range(0, Objects.requireNonNull(fieldValue).length()).forEach(i -> element.sendKeys(Keys.BACK_SPACE));
        element.sendKeys(s);
        sleep(2000);
    }
}
