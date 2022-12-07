package PageFactory;

import driver.driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class yavlenaPageFactory {
    WebDriver driver;

    @FindBy(xpath = "//*[@class=\"green-btn load-more-results-list\"]")
    WebElement loadMoreButton;

    @FindBy(xpath = "//*[@data-container=\"broker-keyword\"]")
    WebElement searchInputBox;

    @FindBy(xpath = "//*[@class=\"icon-search____ICON\"]")
    WebElement searchIcon;

    @FindBy(xpath = "//*[@class=\"broker-card\"]//div//div//h3//a")
    List<WebElement> name;

    @FindBy(xpath = "//*[@class=\"broker-card\"]//div//div//div//a[@target=\"_blank\"]")
    List<WebElement> numberOfProperties;

    @FindBy(xpath = "//*[starts-with(@href, \"tel:+359 2\")]")
    List<WebElement> landlinePhones;

    @FindBy(xpath = "//span//*[starts-with(@href, \"tel:+359 88\")] | //span//*[starts-with(@href, \"tel:+359  888\")]")
    List<WebElement> mobilePhones;


    public yavlenaPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void searchbrokers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        jsClick(loadMoreButton);

        wait.until(webDriver -> name.size() > 9);
        int i;

        for (i = 0; i <= name.size(); i++) {

            wait.until(webDriver -> name.size() > 9);
            String nameSearch = name.get(i).getText();
            String numberOfPropertiesBeforeSearch = numberOfProperties.get(i).getText();
            String landlinephoneBeforeSearch = landlinePhones.get(i).getText();
            String mobilePhoneBeforeSearch = mobilePhones.get(i).getText();
            searchInputBox.sendKeys(nameSearch);
            searchIcon.click();
            try {
                Assert.assertEquals(nameSearch, name.get(i).getText());
                Assert.assertEquals(numberOfPropertiesBeforeSearch, numberOfProperties.get(i).getText());
                Assert.assertEquals(landlinephoneBeforeSearch, landlinePhones.get(i).getText());
                Assert.assertEquals(mobilePhoneBeforeSearch, mobilePhones.get(i).getText());
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
            wait.until(webDriver -> name.size() == 1);


            searchInputBox.sendKeys(Keys.CONTROL + "A");
            searchInputBox.sendKeys(Keys.DELETE);
            wait.until(webDriver -> name.size() > 1);

        }

    }
}

