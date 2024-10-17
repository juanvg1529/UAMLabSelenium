package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Hooks;
import pages.HomePage;

public  class  BaseTest{
    private WebDriver driver;
    protected Hooks hooks;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
        hooks= new Hooks(driver);
        homePage= new HomePage(driver);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://www.demoblaze.com/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}