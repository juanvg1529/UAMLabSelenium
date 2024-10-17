package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Hooks {


      public HomePage(WebDriver driver){
        super(driver);
          PageFactory.initElements(driver, this);

    }
      private  By  logoPage = By.xpath("//a[@id='nava']");
      @FindBy(xpath = "//a[@id='login2']")
      private WebElement loginButton ;
      @FindBy(xpath = "//input[@id='loginusername']")
      private WebElement userNameField;
      @FindBy(xpath = "//input[@id='loginpassword']")
      private WebElement pwdField;
      @FindBy(xpath = "// div[@class='modal-footer']/button[text()='Log in']")
      private WebElement loginButtonUser;

    public boolean waitUntilPage() throws Exception{
      return  isDisplayed(logoPage);
    }
      public void clickLogin() throws Exception{
         click(loginButton);
    }
    public void setUserName(String name)throws Exception{
        putText(userNameField,name);
    }
    public void setPWD(String pwd)throws Exception{
        putText(pwdField,pwd);
    }

    public LoginPage clickButtonLoginCredentials()throws Exception{
        click(loginButtonUser);
        return  new LoginPage(driver);
    }



}
