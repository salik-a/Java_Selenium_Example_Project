import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class HomePage{
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver ;
    }


    public boolean isOnHomePage() {
        Boolean value = driver.findElement(By.id("overlay")).isEnabled();
        return value;
    }//check overlay id element is on this page or not


    public void goLogin(){
        driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }// open login page
    public boolean isLogged() {
        String check = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]")).getText();
        return check.contains("Hesabım");
    }

    public void search() {
        //write(searchpart,"bilgisayar");
        driver.findElement(By.name("k")).sendKeys("bilgisayar" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        //getsearchbutton().get(2).click();

    }

}
