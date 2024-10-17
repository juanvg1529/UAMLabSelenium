package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Hooks {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//a[@id='logout2']")
    private WebElement logoutButton;

    public String getLogoutText() throws Exception{
        return getText(logoutButton);
    }
}
