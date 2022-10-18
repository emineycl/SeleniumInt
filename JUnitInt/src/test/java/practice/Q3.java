package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q3 {
  /*
...Exercise4...
https://www.teknosa.com/ adresine gidiniz
arama cubuguna oppo yazip enter deyiniz
sonuc sayisini yazdiriniz
cikan ilk urune tiklayiniz
sepete ekleyiniz
sepetime git e tiklayiniz
consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
Alisverisi tamamlayiniz
son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
driver i kapatiniz
*/
  static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }


    @Before
    public void beforeTest(){
        driver.get("https://www.teknosa.com/");
    }
    @After
    public void afterTest(){

    }


    @Test
    public void test01() {



    }



}



