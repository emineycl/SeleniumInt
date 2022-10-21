package HomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day04_TekrarSorusu_10_09 {

    /*
    1- bir class olusturun
    2- https://www.amazon.com/ adresine gidin
    3- Browseri tam sayfa yapin
    4- Sayfayi “refresh” yapin
    5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    6- Gift Cards sekmesine basin
    7- Birthday butonuna basin
    8- Best Seller bolumunden ilk urunu tiklayin
    9- Gift card details’den 25 $i secin
    10-Urun ucretinin 25$ oldugunu test edin
    11-Sayfayi kapatin
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
    WebDriver driver= new ChromeDriver();

       // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //    3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //    5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
      String actualTitle= driver.getTitle();
      String arananMetin="Spend less";
        if (actualTitle.contains(arananMetin)){
            System.out.println("Title aranan  metni iceriyor, test PASSED");
        }else {
            System.out.println("Title aranan metni icermiyor, test FAILED");
        }

        //  6- Gift Cards sekmesine basin
       driver.findElement(By.linkText("Gift Cards")).click();
       /*driver.findElement(By.xpath("(//a[@class='nav-a  '])[4]")).click();   benim cözumum ,ayni sonuc */
        Thread.sleep(1000);

        //    7- Birthday butonuna basin
       // driver.findElement(By.xpath("//img[@alt='Birthday gift cards ']")).click();  hocanin yazdigi sekilde bulamadi
        driver.findElement(By.xpath("//a[@aria-label='Birthday gift cards']")).click();
        Thread.sleep(1000);

      //  8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();
        Thread.sleep(1000);

      //  9- Gift card details’den 25 $i secin
        driver.findElement(By.xpath("//button[@value='25']")).click();
        /* driver.findElement(By.xpath("(//span[@class='a-button a-button-toggle'])[1]")).click(); calisiyor ama 19 tane buldu */
        Thread.sleep(2000);

      //  10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucretElementi= driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));
        String actualUcretStr=ucretElementi.getText();
        String expectedUcretStr="25$";

        if (actualUcretStr.equals(expectedUcretStr)){
            System.out.println("Gift card testi PASSED");
        }else {
            System.out.println("Gift card fiyati farkli, test FAILED");
        }
        Thread.sleep(2000);

        //    11-Sayfayi kapatin
        driver.close();
    }
}
