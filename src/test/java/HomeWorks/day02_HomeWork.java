package HomeWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_HomeWork {
    public static void main(String[] args) throws InterruptedException {

        /*
        1.Yeni bir class olusturalim (Homework)
        2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
        yazdirin.
        3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        “actual” URL’i yazdirin.
        4.https://www.walmart.com/ sayfasina gidin.
        5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        6. Tekrar “facebook” sayfasina donun
        7. Sayfayi yenileyin
        8. Sayfayi tam sayfa (maximize) yapin
        9.Browser’i kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.facebook.com");

        if (driver.getTitle().contains("facebook")) {
            System.out.println("Facebook title = " + driver.getTitle());
        }else {
            System.out.println("Facebook title is: " +driver.getTitle());
        }
        Thread.sleep(2000);
        if (driver.getCurrentUrl().contains("facebook")) {
            System.out.println("Facebook Url contains 'facebook'");
        }else {
            System.out.println(driver.getCurrentUrl());
        }
         Thread.sleep(2000);
        driver.navigate().to("https://www.walmart.com/");
        Thread.sleep(2000);

        if (driver.getTitle().contains("Walmart.com")) {
            System.out.println("https://www.walmart.com/ contains " + "Walmart.com");
        } else {
            System.out.println(driver.getTitle());
        }
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.close();

    }

}
