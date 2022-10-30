package Ödevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;

public class H_01 {

// 1. http://zero.webappsecurity.com/ Adresine gidin
// 2. Sign in butonuna basin
// 3. Login kutusuna “username” yazin
// 4. Password kutusuna “password.” yazin
// 5. Sign in tusuna basin
//6. Pay Bills sayfasina gidin
//7. “Purchase Foreign Currency” tusuna basin
//8. “Currency” drop down menusunden Eurozone’u secin
//9. “amount” kutusuna bir sayi girin
//10. “US Dollars” in secilmedigini test edin
//11. “Selected currency” butonunu secin
//12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
//13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

   static WebDriver driver;
    @BeforeClass
       static public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
        static public void tearnDown(){
          //  driver.close();
    }
        @After
        public void afterTest(){

        }
        @Before
        public void beforeTest(){
                // 1. http://zero.webappsecurity.com/ Adresine gidin
                driver.get("http://zero.webappsecurity.com/");

        }
        @Test
    public void test01() throws InterruptedException {
            // 2. Sign in butonuna basin
            WebElement signButton= driver.findElement(By.xpath("//button[@id='signin_button']"));
            signButton.click();
            /*   driver.findElement(By.className("icon-signin")).click();  */

            // 3. Login kutusuna “username” yazin
            WebElement loginKutusu= driver.findElement(By.xpath("//input[@type='text']"));
            loginKutusu.sendKeys("username" );
            /* driver.findElement(By.id("user_login")).sendKeys("username"); */

            // 4. Password kutusuna “password.” yazin
            WebElement passwordKutusu= driver.findElement(By.xpath("//input[@type='password']"));
            passwordKutusu.sendKeys("password");
           /*  driver.findElement(By.id("user_password")).sendKeys("password"); */
            Thread.sleep(1500);

            // 5. Sign in tusuna basin
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            driver.navigate().back();
            /*  driver.findElement(By.xpath("//input[@value='Sign in']")).click();
                 driver.navigate().back();
                    */

            //6. Pay Bills sayfasina gidin
            driver.findElement(By.xpath("//a[@id='online-banking']")).click();
         /*   driver.findElement(By.xpath("//a[text()='More Services']")).click();  */
            driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

            //7. “Purchase Foreign Currency” tusuna basin
            driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();
            /*  driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();  */

            //8. “Currency” drop down menusunden Eurozone’u secin



            /*  WebElement DDM=driver.findElement(By.id("pc_currency"));
        Select select=new Select(DDM);
        select.selectByVisibleText("Eurozone (euro)");
        select.getFirstSelectedOption().click(); */

            //9. “amount” kutusuna bir sayi girin
//10. “US Dollars” in secilmedigini test edin
//11. “Selected currency” butonunu secin
//12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
//13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

        }

}



/*

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.className("icon-signin")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='More Services']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        WebElement DDM=driver.findElement(By.id("pc_currency"));
        Select select=new Select(DDM);
        select.selectByVisibleText("Eurozone (euro)");
        select.getFirstSelectedOption().click();
        driver.findElement(By.id("pc_amount")).sendKeys("3000");
        WebElement radioUSD=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(radioUSD.isSelected());
        driver.findElement(By.id("pc_inDollars_false")).click();
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        String expectedText="Foreign currency cash was successfully purchased.";
        String actualText=driver.findElement(By.id("alert_content")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void teardown(){
        driver.close();
    }
}
 */