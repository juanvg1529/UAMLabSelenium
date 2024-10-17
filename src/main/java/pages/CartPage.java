package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Hooks{

    public CartPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[text()=\"Products\"]")
    private WebElement productsText;

    public String getPageAssertion() throws Exception{
        return  getText(productsText);
    }
}
