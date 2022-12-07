package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class baseClass {

    public static WebDriver driver;


    @BeforeSuite
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:exe\\chromedriver.exe");
        driver = new ChromeDriver();
//        String baseURL = "https://service.bugaboo.com/s/consumer-contact?selectedItem=Consumer_Contact_Form__c&language=en_US";
//        driver.get(baseURL);
        driver.manage().window().maximize();

    }


    @AfterSuite
    public void closeBrowser() {
//        driver.quit();

    }
}
