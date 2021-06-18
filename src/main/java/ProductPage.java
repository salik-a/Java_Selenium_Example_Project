import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver ;

    }

    By pageprice = By.id("sp-price-discountPrice");
    //By addbasket = By.id("add-to-basket");
    //By gobasket = By.className("dIB");
    By basketprice = By.className("new-price");
    public void addBasket() {
        //close ads
        //driver.findElement(By.className("wis-clsbtn-96096")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //add product to basket
        driver.findElement(By.id("add-to-basket")).click();
    }

    public void goToBasket() {
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/a")).click();
        driver.get("https://www.gittigidiyor.com/sepetim");
    }
    public  String getPrice(){
        String price =driver.findElement(By.id("sp-price-lowPrice")).getText();
        return price;
    }

    public boolean isPriceRight(String firstprice, String secondprice) {
        return firstprice.equals(secondprice);
    }
}
