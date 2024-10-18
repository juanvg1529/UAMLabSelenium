package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Hooks{

    public CartPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[text()=\"Products\"]")
    private WebElement productsText;

    @FindBy(xpath = "//tr[@class=\"success\"]/td")
    private List<WebElement> elementsToPurchase;

    @FindBy(xpath = "//button[text()=\"Place Order\"]")
    private WebElement buttonPlaceOrder;

    public String getPageAssertion() throws Exception{
        return  getText(productsText);
    }
    public  String validateItemToBuy(String itemToBuy)throws Exception{
        String itemPurchased=null;
        for(WebElement element:elementsToPurchase){
            By xpathItemtoPurchase = By.xpath("//tr[@class=\"success\"]/td[text()=\"" + itemToBuy + "\"]");
            var webElementItemToPurchase= driver.findElement(xpathItemtoPurchase).getText();
            if (element.getText().contains(webElementItemToPurchase)){
                itemPurchased= webElementItemToPurchase;
                break;
            }

        }
        return itemPurchased;


    }
    public PurchaseForm clickPurchaseButton() throws Exception{
        this.click(buttonPlaceOrder);
        return new PurchaseForm(driver);
    }



}
