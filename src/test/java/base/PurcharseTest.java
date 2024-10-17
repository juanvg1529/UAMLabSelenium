package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class PurcharseTest extends BaseTest {

   @Test
    public void purchaseItemBlaze() throws Exception{



       var loadedPage=homePage.waitUntilPage();
       Assert.assertTrue(loadedPage);
       homePage.clickLogin();
       homePage.setUserName("username");
       homePage.setPWD("password");
       var loginPage= homePage.clickButtonLoginCredentials();
   }

}
