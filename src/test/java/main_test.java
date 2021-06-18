import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLogger.class)
//@Disabled("disabled because of this bug")
public class main_test {
    WebDriver driver;

    HomePage homePage;
    LoginPage loginPage;
    SearchPage searchPage;
    ProductPage productPage ;
    BasketPage basketPage ;


    @Test
    @Order(1)
    public void main_test() throws InterruptedException {

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        driver = new ChromeDriver(options);

        homePage= new HomePage(driver);
        searchPage= new SearchPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("http://www.gittigidiyor.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(homePage.isOnHomePage(),"Not on home page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.goLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        loginPage.Login();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(homePage.isLogged(),"Could not login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/section[1]/section[2]/a")).click();
        Thread.sleep(1000);
        homePage.search();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage.clickSecondPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(searchPage.isOnSecondPage(),"Not on second search page");
        searchPage.selectProduct();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String firstprice = productPage.getPrice();
        productPage.addBasket();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
        productPage.goToBasket();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String secondprice = basketPage.getBasketPrice();
        Assertions.assertTrue(productPage.isPriceRight(firstprice,secondprice),"Price isn't right");
        Thread.sleep(3000);
        basketPage.makeValueTwo();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
        Assertions.assertTrue(basketPage.isValueTwo(secondprice),"Value isn't two");
        basketPage.deleteProduct();
        Assertions.assertTrue(basketPage.isProductDeleted(),"Product didn't delete");
    }



}
