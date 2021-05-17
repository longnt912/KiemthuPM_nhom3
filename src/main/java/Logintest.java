import org.testng.annotations.Test;
//import org.openqa.selenium.chrome.ChromeDriver; // dung Chorme
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; // them 2 dau gach neu dung Chorme dong nay
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Logintest {
    WebDriver driver;
    @BeforeTest
    public void setup()
    {
        //System.setProperty("webdriver.chrome.driver"," them duong link driver vao day! "); // bo 2 dau gach dung chorme
        //WebDriver driver = new ChromeDriver(); // bo 2 dau gach dung chorme
        System.setProperty("webdriver.firefox.marionette","D:\\geckodriver-v0.29.1-win64\\geckodriver.exe"); // them 2 dau gach
        driver=new FirefoxDriver(); // them 2 dau gach khi dung chrome
        driver.manage().window().maximize();
        driver.get("https://twhyderabad.github.io/demo_site/"); //website demo copy o dau do :v
    }
    @Test(priority=1)
    public void verify1()
    {
        Loginpage login=new Loginpage(driver);
        login.set_username("admin");
        login.set_password("admin");
        login.click_button();
        Assert.assertTrue(driver.getPageSource().contains("Blog"));
    }
    @Test(priority=2)
    public void verify2()
    {
        Loginpage login=new Loginpage(driver);
        login.set_username("adm");
        login.set_password("admin");
        login.click_button();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
    }
    @Test(priority=3)
    public void verify3()
    {
        Loginpage login=new Loginpage(driver);
        login.set_username("admin");
        login.set_password("adm");
        login.click_button();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
    }
    @Test(priority=4)
    public void verify4()
    {
        Loginpage login=new Loginpage(driver);
        login.set_username("adm");
        login.set_password("adm");
        login.click_button();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
    }
    @Test(priority=5)
    public void verify5()
    {
        Loginpage login=new Loginpage(driver);
        login.set_username("");
        login.set_password("");
        login.click_button();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
    }
    @AfterTest
    public void close()
    {
        driver.close();
    }
}
