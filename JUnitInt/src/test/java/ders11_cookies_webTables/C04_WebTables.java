package ders11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // en alttaki web table'da 9 satir oldugunu test edin
        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//table//tr"));

        Assert.assertTrue(satirlarListesi.size()==10);

        // sutun sayisinin 13 oldugunu test edin
        List<WebElement> ilkSatirDataListesi= driver.findElements(By.xpath("//table//tr[1]/td"));    //tek tek data'lari verir*
       Assert.assertTrue(ilkSatirDataListesi.size()==14);
        // 3. sutunu yazdirin
        List<WebElement> ucuncuSutunDataListesi= driver.findElements(By.xpath("//table//tr/td[3]"));

        for (WebElement each: ucuncuSutunDataListesi) {
            System.out.println(each.getText());
        }
        // 5.satiri yazdirin
       System.out.println("=================");
        List<WebElement> besinciSatirDataListesi= driver.findElements(By.xpath("//table//tr[5]"));
        for (WebElement each: besinciSatirDataListesi) {
            System.out.println(each.getText());
        }

        // 3.satir, 5.sutundaki basligin Home Service oldugunu test edin
        WebElement ucuncusatirBesinciSutun= driver.findElement(By.xpath("//table//tr[3]/td[5]"));
        String expectedIcerik="Home Service";
        String actualData=ucuncusatirBesinciSutun.getText();

        Assert.assertTrue(actualData.contains(expectedIcerik));

        // satir ve sutun degerlerini verdigimizde tablodaki o bolumu yazdiracak bir method olusturun
        dataYazdir(3,5);

   bekle(5);
    }
    public void dataYazdir(int satir, int sutun) {
        WebElement arananData= driver.findElement(By.xpath("//table//tr["+satir+"]/td["+sutun+"]"));

        System.out.println(satir+ ".satir" + sutun+ ".ci sutundaki data :" + arananData.getText());
    }
}
