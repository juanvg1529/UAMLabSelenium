package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage extends Hooks{
    public AddToCartPage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//h2[@class='name']")
    private  WebElement itemName;

    @FindBy(xpath= "//a[text()=\"Cart\"]" )
    private WebElement cartPageOption;
    public String retrieveAddToCartText()throws Exception{
        return getText(addToCartButton);
    }
    public String getItemToPurchaseName() throws Exception{
        return  getText(itemName);
    }
    public void alert_clickToAccept(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    public void clickAddToCartButton()throws Exception{
        click(addToCartButton);
    }
    public CartPage clickCartOption() throws  Exception{
        click(cartPageOption);
        return new CartPage(driver);
    }
}
