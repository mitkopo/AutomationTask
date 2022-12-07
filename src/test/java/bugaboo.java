import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class bugaboo extends baseClass {


    @BeforeTest
    public void btSetUp() {


        String baseURL = "https://service.bugaboo.com/s/consumer-contact?selectedItem=Consumer_Contact_Form__c&language=en_US";
        driver.get(baseURL);

        PageFactory.bugaboo bugabooPF = new PageFactory.bugaboo(driver);
        bugabooPF.waitForCookies();
        bugabooPF.acceptCookies();
    }

    @Test
    public void TC1() {

        PageFactory.bugaboo bugabooPF = new PageFactory.bugaboo(driver);

        Assert.assertTrue(bugabooPF.isSubmitClikable());
        bugabooPF.clickSubmit();
    }

    @Test
    public void TC2() {
        PageFactory.bugaboo bugabooPF = new PageFactory.bugaboo(driver);
        bugabooPF.dropdownSelect();

    }

    @Test
    public void TC3() throws InterruptedException {
        PageFactory.bugaboo bugabooPF = new PageFactory.bugaboo(driver);
        bugabooPF.mandotoryFields();
    }


    @Test
    public void TC9() throws InterruptedException {
        PageFactory.bugaboo bugabooPF = new PageFactory.bugaboo(driver);
        bugabooPF.formSelector();
        bugabooPF.tickSNcheckbox();
        bugabooPF.enterItemCode("2BCD3B221");
        bugabooPF.datePicker();
        bugabooPF.radioOnLineSelector();
        bugabooPF.enterDescriptionText("I have problem registering my PS5 extended guarantee");
        bugabooPF.enterFirstName("Mitko");
        bugabooPF.enterLastName("Popov");
        bugabooPF.enterEmail("mitko.popov@hotmail.com");
        bugabooPF.enterVerifyEmail("mitko.popov@hotmail.com");
        bugabooPF.dialCodeSelect();
        bugabooPF.enterPhoneNumber();
        bugabooPF.enterStreetAddress1("Izvorski br.5");
        bugabooPF.enterCity("Bogdanci");
        bugabooPF.countrySelect();
        bugabooPF.captchaCheck();
        bugabooPF.clickSubmit();
    }
}
