package Ödevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class ders10_H_02 extends TestBase {
    //    1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a  kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //            5."username" ve  "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //            8.Ok diyerek Popup'i kapatin
    //            9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin

        @Test
    public void test01() throws InterruptedException {
            //    1."http://webdriveruniversity.com/" adresine gidin
            driver.get("http://webdriveruniversity.com/");
            Actions actions=new Actions(driver);

            //2."Login Portal" a  kadar asagi inin
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
          String ilkSayfaHandle= driver.getWindowHandle();
            System.out.println(ilkSayfaHandle);

            //3."Login Portal" a tiklayin
            WebElement loginPortal= driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']"));
            loginPortal.click();

            //4.Diger window'a gecin
    Set<String> windowHandlesSet=driver.getWindowHandles();

            String ikinciSayfaWindowHandleDegeri= "";

            for (String eachHandleDegeri: windowHandlesSet
            ) {
                if (!eachHandleDegeri.equals(ilkSayfaHandle)){
                    ikinciSayfaWindowHandleDegeri= eachHandleDegeri; // yani ikinci sayfanin window handle degerini simdi bulduk...
                }
            }

            driver.switchTo().window(ikinciSayfaWindowHandleDegeri); // iste! simdi ikinci sayfaya gectik...

            //  5."username" ve  "password" kutularina deger yazdirin
          WebElement username=  driver.findElement(By.xpath("//input[@type='text']"));
            username.sendKeys("Emine");
            bekle(2);
            WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("12345");
            bekle(2);


            //6."login" butonuna basin
            WebElement login= driver.findElement(By.xpath("//button[@type='submit']"));
            login.click();
            bekle(2);

            //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
            String expected="validation failed";
            String actualAlertMessage=driver.switchTo().alert().getText();
            System.out.println(actualAlertMessage);
            Assert.assertEquals(expected,actualAlertMessage);
            bekle(3);

            // 8.Ok diyerek Popup'i kapatin
            driver.switchTo().alert().accept();

            // 9.Ilk sayfaya geri donun
            driver.switchTo().window(ilkSayfaHandle);

            //10.Ilk sayfaya dönuldugunu test edin
            String expectedUrl="http://webdriveruniversity.com/";
            String actualUrl= driver.getCurrentUrl();

            Assert.assertEquals(expectedUrl,actualUrl);


        }

}
