package HomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day05_10_10_H01 {
    //    1-C01_TekrarTesti isimli bir class olusturun
    //2- https://www.google.com/ adresine gidin
    // 3- cookies uyarisini kabul ederek kapatin
    //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6-Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8-Sayfayi kapatin
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        WebElement cookies= driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));
        cookies.click();
        Thread.sleep(1000);

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        WebElement sayfaBasligi= driver.findElement(By.xpath("//img[@class='lnXdpd']"));

        if (sayfaBasligi.isDisplayed()){
            System.out.println("Sayfa basligi GOOGLE ifadesini iceriyor , test PASSED");
        }else {
            System.out.println("Sayfa basligi GOOGLE ifadesini icermiyor, test FAILED");
        }
       /* 2.Yöntem
       if (driver.getTitle().contains("Google")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        } */

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(1000);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
        String sonucSayisiStr=sonucSayisi.getText();
        Thread.sleep(1000);

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonucSayisiStr=sonucSayisiStr.substring(
                (sonucSayisiStr.indexOf(" ")+1),
                (sonucSayisiStr.indexOf("results")-1));

        sonucSayisiStr=sonucSayisiStr.replaceAll("\\.","");
        System.out.println(sonucSayisiStr);

        if (Integer.parseInt(sonucSayisiStr)>10000000){
            System.out.println("Sonuc sayisi 10000000'den fazla, Test PASSED");
        }else {
            System.out.println("Sonuc sayisi 10000000'den fazla degil, Test FAILED");
        }
        Thread.sleep(1000);
        //8-Sayfayi kapatin
        driver.close();
    }


}
