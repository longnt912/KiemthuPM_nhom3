import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    private WebDriver driver;

    @FindBy(id="userName")
    WebElement username;
    @FindBy(id="password")
    WebElement password;
    @FindBy(className="btn-info")
    WebElement button;
    public Loginpage(WebDriver driver)
    {
        //Khoi tao cac phan tu
        PageFactory.initElements(driver, this);

    }
    public void set_username(String usern)
    {
        username.clear();
        username.sendKeys(usern);
    }
    public void set_password(String userp)
    {
        password.clear();
        password.sendKeys(userp);
    }
    public void click_button()
    {
        button.submit();
    }
}
