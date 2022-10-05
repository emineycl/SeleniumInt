package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {


/* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini ve Url alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

    public static void main(String[] args) throws InterruptedException {

       /*2*/ System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

       /*3*/ driver.manage().window().maximize();

   /*4*/ driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   /*5*/ driver.get("https://www.otto.de");

        /*6*/   String actOttoTitle= driver.getTitle();
        System.out.println("actOttoTitle= " + actOttoTitle);

        String actOttoUrl=driver.getCurrentUrl();
        System.out.println("actOttoUrl = " + actOttoUrl);

        if (actOttoTitle.contains("OTTO"))
            System.out.println("Otto Test Passed");
        else
            System.out.println("Otto Test Failed");

        if (actOttoUrl.contains("otto"))
            System.out.println("Otto URL Test Passed");
        else
            System.out.println("Otto URL Test Failed");

        driver.navigate().to("https://www.wisequarter.com");

        boolean isTrue=driver.getTitle().contains("Quarter");

        if (isTrue)
            System.out.println("WQ Title Test Passed");
        else
            System.out.println("WQ Title Test Failed");

        String wqUrl=driver.getCurrentUrl();
        System.out.println(wqUrl.contains("quarter")? "WQ Url Test Passed" : "WQ Url Failed");

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.quit();

    }
}
