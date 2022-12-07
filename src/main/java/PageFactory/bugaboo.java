package PageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class bugaboo {
    WebDriver driver;

    @FindBy(xpath = "//button[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")
    WebElement acceptCookies;

    @FindBy(xpath = "//*[@class=\"slds-select\"]")
    WebElement dropdown;

    @FindBy(xpath = "//button[@class=\"slds-button slds-button_brand flow-button__NEXT\"]")
    WebElement submit;

    @FindBy(xpath = "//*[@class=\"slds-rich-text-editor__output\"]")
    WebElement notification;

    @FindBy(xpath = "//*[@class=\"flowruntime-input-error slds-form-element__help\"]")
    List<WebElement> notifications;

    @FindBy(xpath = "//div[@class=\"flowruntime-input-label\"] //abbr")
    WebElement fisrtMandatorySign;

    @FindBy(xpath = "(//div[@class=\"flowruntime-input-label\"] //abbr) [position() !=1] | //div[@class=\"slds-size_1-of-1\"]//div//label//abbr")
    List<WebElement> mandotorySignsFirstSkipped;

    @FindBy(xpath = "//*[@id=\"vfFrame\"]")
    WebElement captchaIframe;

    @FindBy(xpath = "//*[@role=\"checkbox\"]")
    WebElement captchaCheckBox;
    @FindBy(xpath = "//*[@id=\"html_element\"]/div/div/iframe")
    WebElement iframe2;

    @FindBy(xpath = "//*[@class=\"slds-select\"]|//*[@class=\"slds-form-element\"]|//*[@class=\"slds-radio_faux\"]|//*[@class=\"slds-checkbox_faux\"]")
    List<WebElement> formInputs;

    @FindBy(xpath = "//*[@data-dial-code=\"389\"]")
    WebElement dialCode389;

    @FindBy(xpath = "//*[@class=\"slds-checkbox_faux\"]")
    WebElement snCheckbox;

    @FindBy(xpath = "//*[@name=\"Country\"]")
    WebElement countrySelect;

    @FindBy(xpath = "//*[@class=\"iti__flag-container\"]")
    WebElement flagContainer;

    @FindBy(xpath = "//*[starts-with(@for, \"RADIO-0-\")]")
    WebElement radioOnline;

    @FindBy(xpath = "//*[@name=\"Purchase_Date\"]")
    WebElement calendar;

    @FindBy(xpath = "//*[@name=\"Item_Code\"]")
    WebElement itemCodeInputBox;

    @FindBy(xpath = "//*[@class=\"slds-textarea\"]")
    WebElement descriptionInputBox;

    @FindBy(xpath = "//*[@name=\"First_Name\"]")
    WebElement fistNameInputBox;

    @FindBy(xpath = "//*[@name=\"Last_Name\"]")
    WebElement lastNameInputBox;

    @FindBy(xpath = "//*[@name=\"Email\"]")
    WebElement emailInputBox;

    @FindBy(xpath = "//*[@name=\"Verify_EMail\"]")
    WebElement verifyEmailInputBox;

    @FindBy(xpath = "//*[@data-id=\"countryPhone\"]")
    WebElement phoneNumberInputBox;

    @FindBy(xpath = "//*[@name=\"Street_Address_1\"]")
    WebElement streetAddress1InputBox;

    @FindBy(xpath = "//*[@name=\"City\"]")
    WebElement cityInputBox;


    public bugaboo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForCookies() {
        waitForElementToBeVisible(dropdown);
    }

    public void waitForSubmit() {
        waitForElementToBeClickable(submit);
    }

    public void acceptCookies() {
        acceptCookies.click();
    }

    public void clickSubmit() {
        submit.click();
    }

    public boolean isSubmitClikable() {
        Boolean button = null;
        if (submit.isDisplayed() == true) {
            System.out.println("Submit button is clickable");
            return button = true;
        }

        return button;
    }

    public void dropdownSelect() {
        Select sel = new Select(dropdown);
        int i;


        for (i = 1; i <= 8; i++) {

            int numberOfElementsBeforeChange = formInputs.size();
            waitForElementToBeVisible(fisrtMandatorySign);
            waitForSubmit();

            sel.selectByIndex(i);
            int numberofElementsAfterChange = formInputs.size();
            Assert.assertNotEquals(numberOfElementsBeforeChange, numberofElementsAfterChange);

        }
    }

    public void mandotoryFields() throws InterruptedException {
        Select sel = new Select(dropdown);
        int i;


        for (i = 0; i <= 8; i++) {
            if (i == 0) {
                waitForCookies();
                waitForElementToBeVisible(fisrtMandatorySign);
                waitForSubmit();
                sel.selectByIndex(i);

                try {
                    clickSubmit();
                } catch (StaleElementReferenceException exc) {
                    exc.printStackTrace();
                }

                waitForElementToBeVisible(notification);
                boolean b = notification.isDisplayed();
                Assert.assertTrue(notification.isDisplayed());
                System.out.println(b);

            } else {
                sel.selectByIndex(i);


                try {
                    waitForSubmit();
                    clickSubmit();

                    waitForElementToBeVisible(notification);
                } catch (StaleElementReferenceException exc) {
                    exc.printStackTrace();
                }

                int numberOfSigns = mandotorySignsFirstSkipped.size();
                waitForElementToBeClickable(submit);
                int numberOfNotifications = notifications.size();
                waitForElementToBeClickable(submit);
                try {
                    Assert.assertEquals(numberOfNotifications, numberOfSigns);
                } catch (AssertionError e) {
                    System.out.println(e);
                    System.out.println("Testcase is failed");
                }

            }

        }

    }

    public void dialCodeSelect() throws InterruptedException {


        Thread.sleep(900);
        flagContainer.click();
        dialCode389.click();
    }

    public void formSelector() {
        Select sel = new Select(dropdown);
        sel.selectByIndex(5);
    }

    public void countrySelect() {
        Select sel = new Select(countrySelect);
        sel.selectByValue("CountriesList.MK");
    }

    public void radioOnLineSelector() {
        radioOnline.click();
    }

    public void datePicker() {
        calendar.sendKeys("Sep 15, 2022");

    }

    public void captchaCheck() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));


        driver.switchTo().frame(captchaIframe);
        driver.switchTo().frame(iframe2);
        captchaCheckBox.click();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

    }

    public void tickSNcheckbox() {
        snCheckbox.click();
    }

    public void enterDescriptionText(String text) {
        descriptionInputBox.sendKeys(text);
    }

    public void enterFirstName(String text) {
        fistNameInputBox.sendKeys(text);
    }

    public void enterLastName(String text) {
        lastNameInputBox.sendKeys(text);
    }

    public void enterEmail(String text) {
        emailInputBox.sendKeys(text);
    }

    public void enterVerifyEmail(String text) {
        verifyEmailInputBox.sendKeys(text);
    }

    public void enterPhoneNumber() {
        phoneNumberInputBox.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='71299138';", phoneNumberInputBox);
    }

    public void enterStreetAddress1(String text) {
        streetAddress1InputBox.sendKeys(text);
    }

    public void enterCity(String text) {
        cityInputBox.sendKeys(text);
    }

    public void enterItemCode(String text) {
        itemCodeInputBox.sendKeys(text);
    }
}