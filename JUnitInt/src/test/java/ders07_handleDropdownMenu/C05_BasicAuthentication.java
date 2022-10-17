package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BasicAuthentication {
//    1- Bir class olusturun : BasicAuthentication
//2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
//            3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
//    Html komutu : https://username:password@URL
//    Username    : admin
//    password     : admin
//4- Basarili sekilde sayfaya girildigini dogrulayin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void basicAuthenticationTest() throws InterruptedException {
        //    1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
       // driver.get("https://the-internet.herokuapp.com/basic_auth");
        //            3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //    Html komutu : https://username:password@URL
        //    Username    : admin
        //    password     : admin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
// 4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement basariliGirisyazisiElementi= driver.findElement(By.tagName("p"));

        String expectedKelime="Congratulations";
        String actualYazi=basariliGirisyazisiElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedKelime));
Thread.sleep(1000);
    }

    @After
    public void teardown(){
        driver.close();
    }
}
