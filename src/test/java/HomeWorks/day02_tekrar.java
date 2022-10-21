package HomeWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_tekrar {
    public static void main(String[] args) throws InterruptedException {

        /*
        1. Yeni bir class olusturun (TekrarTesti)
        2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        doğru URL'yi yazdırın.
        4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        5. Youtube sayfasina geri donun
        6. Sayfayi yenileyin
        7. Amazon sayfasina donun
        8. Sayfayi tamsayfa yapin
        9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        Yoksa doğru başlığı(Actual Title) yazdırın.
        10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        doğru URL'yi yazdırın
        11.Sayfayi kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://youtube.com");

        if (driver.getTitle().contains("youtube")) {
            System.out.println("This title contains : " +driver.getTitle());
        } else {
            System.out.println("Actual title :" + driver.getTitle());
        }
        Thread.sleep(2000);
        if (driver.getCurrentUrl().contains("youtube")) {
            System.out.println("This Url contains of :" + driver.getCurrentUrl());
        }else  {
            System.out.println("Actual URL : "+ driver.getCurrentUrl());
        }
        Thread.sleep(2000);
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.manage().window().maximize();
        Thread.sleep(2000);

        if (driver.getTitle().contains("Amazon")) {
            System.out.println("This site contains of: " +driver.getTitle());
        }else {
            System.out.println("Actual title: "+ driver.getTitle());
        }
        if (driver.getCurrentUrl().contains("https://www.amazon.com/"))  {
            System.out.println("Sayfa URL: "+driver.getCurrentUrl());
        }else {
            System.out.println("Actual URL: "+driver.getCurrentUrl());
        }
    driver.close();
    }

}
