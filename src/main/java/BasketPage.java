import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BasketPage{
    WebDriver driver;
    public BasketPage(WebDriver driver) {
        this.driver = driver ;
    }

    public String getBasketPrice(){
        String price = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[5]/div[1]/div[2]/strong")).getText();
        return price;
    }
    public void makeValueTwo() {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select")).sendKeys("2" + Keys.ENTER);
    }
    public boolean isValueTwo(String price){
        String pricedouble = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[5]/div[1]/div[2]/strong")).getText();
        if (pricedouble.equals(price)){
            return false;}
        else{
            return true;
        }
    }
    public void deleteProduct() {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a")).click();
    }

    public boolean isProductDeleted() {//check there is shopcar icon on elements or not
        Boolean value = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[1]/i")).isEnabled();
        return value;
    }
}
