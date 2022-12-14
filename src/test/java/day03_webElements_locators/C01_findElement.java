package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_findElement {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        // Bir web sitesinde herhangi bir web elementi kullanabilmek icin
        // o web elementi kodlarimiza tanitmamiz gerekir
        // WebElement amazonAramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement amazonAramaKutusu=driver.findElement(By.name("twotabsearchtextbox"));
        amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(5000);
        driver.close();
        /*
          Selenium'da 8 adet Locator vardir
          bunlardan 6 tanesi HTML uzerindeki tag veya attribute'lere goredir
          2 tanesi ise daha spesifik olarak, ilk 6 tane locator ile bulamadigimiz
          webElementleri locate etmek icin kullanilir
          1- By.id
             id genelde unique verilir
             dolayisiyla bir HTML elementde id varsa once By.id denenebilir
          2- className
             class attribute'u genelde ayni islevi yapan webelementleri gruplandirmak icin kullanilir
             bu gruplandirmalar sayesinde css ile gruptaki tum webElementler tek yerden sekillendirilebilir
             class attribute'u kullanilirken eger class value'u space iceriyorsa,
             classname ile yapilan locate'ler hata verebilir

             genellikle classname ile yapilan locate'ler birden fazla webelement dondureceginden
             List<WebElement> seklinde olusturacagimiz bir List'e kaydolur

             Bu listedeki elementler WebElement oldugu icin
             bu liste direk yazdirilamaz,
             bunun yerine for-each loop kullanilarak webElement ozellikleri yazdirilabilir
         */
    }
}







