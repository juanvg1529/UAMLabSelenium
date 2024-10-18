package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class PurchaseCompletedPage extends Hooks {
    public PurchaseCompletedPage(WebDriver driver){
        super( driver);
    }

    @FindBy(xpath = "//h2[text()=\"Thank you for your purchase!\"]")
    private WebElement purchaseMessage;
    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    private  WebElement comfirmationButton;

    public String getPurchaseMessage() throws Exception{
        return getText(purchaseMessage);
    }
    public LoginPage clickConfirmationButton()throws Exception{
        click(comfirmationButton);
        return new LoginPage(driver);
    }

}
