package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseForm extends Hooks{
    public PurchaseForm(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@id='country']")
    private WebElement countryField;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;
    @FindBy(xpath = "//input[@id='card']")
    private WebElement cardField;
    @FindBy(xpath = "//input[@id='month']")
    private WebElement monthField;
    @FindBy(xpath = "//input[@id='year']")
    private WebElement yearField;
    @FindBy(xpath = "//button[text ()=\"Purchase\"]")
    private WebElement buttonPurchase;
    public void fillPurchaseForm(String name, String country ,String city, String card, String month, String year)throws  Exception{
        putText(nameField,name);
        putText(countryField,country);
        putText(cityField,city);
        putText(cardField,card);
        putText(monthField,month);
        putText(yearField,year);
    }

    public PurchaseCompletedPage clickPurchaseButton()throws Exception {
        click(buttonPurchase);
        return new PurchaseCompletedPage(driver);
    }



}
