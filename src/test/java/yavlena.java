import PageFactory.yavlenaPageFactory;
import base.baseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class yavlena extends baseClass {

    @BeforeTest
    public void btSetUp() {


        String baseURL = "https://www.yavlena.com/broker/";
        driver.get(baseURL);
    }


    @Test
    public void tc1() {
        yavlenaPageFactory yavlenaPF = new yavlenaPageFactory(driver);

        yavlenaPF.searchbrokers();

    }
}
