package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PurchaseForm;

import java.time.LocalDateTime;

public class PurcharseTest extends BaseTest {

   @Test
    public void purchaseItemBlaze() throws Exception{

      var loadedPage=homePage.waitUntilPage();
      Assert.assertTrue(loadedPage);
      homePage.clickLogin();
      homePage.setUserName("username");
      homePage.setPWD("password");
      var loginPage= homePage.clickButtonLoginCredentials();
      var logOutText= loginPage.getLogoutText();
      Assert.assertEquals(logOutText,"Log out");
      var addToCartPage=loginPage.selectItemtoBuy();
      String AddToCareText= addToCartPage.retrieveAddToCartText();
      Assert.assertTrue(AddToCareText.contains("Add to cart"));
      addToCartPage.clickAddToCartButton();
      addToCartPage.alert_clickToAccept();
      String itemToPurcharseName= addToCartPage.getItemToPurchaseName();
      var cartPage= addToCartPage.clickCartOption();
      var itemPurchase= cartPage.validateItemToBuy(itemToPurcharseName);
      cartPage.printConsole("Item Selected ="+itemPurchase+" , continue filling the form");
      var purchaseForm= cartPage.clickPurchaseButton();
      purchaseForm.fillPurchaseForm("Juan","Colombia","Medellin","7418/596", "October","2024");
      var purchaseCompletePage= purchaseForm.clickPurchaseButton();
      var getPurchaseValidationText= purchaseCompletePage.getPurchaseMessage();
      Assert.assertEquals(getPurchaseValidationText,"Thank you for your purchase!");
      var loginPageAfterPurchase= purchaseCompletePage.clickConfirmationButton();
      var logOutTextAfterPurchase= loginPageAfterPurchase.getLogoutText();
      Assert.assertEquals(logOutTextAfterPurchase,"Log out");


   }

}
