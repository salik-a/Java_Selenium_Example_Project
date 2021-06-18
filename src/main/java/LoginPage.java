import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class LoginPage{
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver ;
    }
   // By userName = By.id("L-UserNameField");
    //By password = By.id("L-PasswordField");
    //By enter = By.id("gg-login-enter");
    public void Login() {
        //enter email
        driver.findElement(By.id("L-UserNameField")).sendKeys("salikalper@gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //enter password
        driver.findElement(By.id("L-PasswordField")).sendKeys("As.99166" + Keys.ENTER);

    }
}