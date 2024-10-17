package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class LoginPage extends Hooks {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//a[@id='logout2']")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private List<WebElement> listOfPurchaseElements;

    @FindBy(xpath = "//h4[@class='card-title']/a")
    private List<WebElement> cardTitleList;
    public String getLogoutText() throws Exception{
        return getText(logoutButton);
    }
    public AddToCartPage selectItemtoBuy(){
        String productSelected = null;
        List<String> itemsNames= new ArrayList<>();
        for(WebElement element:cardTitleList){
            String getNameElement =element.getText();
            itemsNames.add(getNameElement);
        }
        Collections.shuffle(itemsNames);
        Random random = new Random();
        int indexSelectedList=random.nextInt(itemsNames.size() );

        productSelected= itemsNames.get(indexSelectedList);
        for (WebElement element:cardTitleList){
            if( element.getText().contains(productSelected)) {
                element.click();
                break;
            }
        }
        return new AddToCartPage(driver);

    }
}
