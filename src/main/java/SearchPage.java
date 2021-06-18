import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage{
    WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver ;
    }



    public void clickSecondPage() {
        //this part close ads
        //driver.findElement(By.xpath("/html/body/div[6]/div/img[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //this part close popup
        //driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/a/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        //driver.findElement(By.className("next-link")).click();
        driver.get("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
    }

    public boolean isOnSecondPage() {
        int check = Integer.parseInt(driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[4]/ul/li[3]/a")).getText());

        return check == 2;
    }

    public void selectProduct() {
        int random =1 +  (int)(Math.random()*(47));
        List<WebElement> listOfElements = driver.findElements(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li"));
        listOfElements.get(random).click();
    }

}
