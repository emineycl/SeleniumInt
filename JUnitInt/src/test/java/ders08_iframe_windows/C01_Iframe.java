package ders08_iframe_windows;

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

public class C01_Iframe {

//    ● Bir class olusturun: IframeTest
//  ● https://the-internet.herokuapp.com/iframe adresine gidin.
//            ● Bir metod olusturun: iframeTest
// ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
//            ○ Text Box’a “Merhaba Dunya!” yazin.
// ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

WebDriver driver;
        @Before
    public void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @Test
    public void iframeTest() throws InterruptedException {

//    ● Bir class olusturun: IframeTest
//  ● https://the-internet.herokuapp.com/iframe adresine gidin.
            driver.get("https://the-internet.herokuapp.com/iframe");

//   ● Bir metod olusturun: iframeTest
    // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
            WebElement anIframeYaziElementi= driver.findElement(By.tagName("h3"));
            Assert.assertTrue(anIframeYaziElementi.isEnabled());
  //  konsolda  yazdirin.
            System.out.println(anIframeYaziElementi.getText());
            //  ○ Text Box’a “Merhaba Dunya!” yazin.
            /*
            Ulasmak istedigimiz bir webelement bir iframe icerisinde ise driver o webelemente direk ulasamaz
            once webelement'in iceriisnde oldugu iframe'e gecis yapmamiz gerekir

            Bir iframe'e gecis icin o iframe'in
                 -index
                 -name veya id attribute'unun degeri
                 -webelement olarak locate edilen obje
                 seceneklerinden biri ile switchto().framme() method'u kullanilir
             */
            WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
            driver.switchTo().frame(iframeElementi);
            WebElement yaziAlaniElementi= driver.findElement(By.xpath("//body[@id=‘tinymce’]"));
            yaziAlaniElementi.clear();
            yaziAlaniElementi.sendKeys("Merhaba Dunya!");
            // ○ TextBox’in altinda bulunan “Elemental Selenium”
            // linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

            /*
            Bir iframe'in icerisine girdikten donra
            asil sayfa ile bir islem yapmak isterseniz
            oncelikle icerisine girdigin iframe'den cikmamiz lazim

             switchTo().defaultContent()  ==> ana sayfaya gecer
             switchTo().parentFrame()  ==>ic ice birden fazla iframe varsa
                                          bulundugu iframe'in bir ust iframe'ine cikar
             */
            driver.switchTo().defaultContent();
            WebElement elementalSeleniumLinki= driver.findElement(By.linkText("Elemental Selenium"));
            Assert.assertTrue(elementalSeleniumLinki.isEnabled());

            System.out.println(elementalSeleniumLinki.getText());

            Thread.sleep(3000);

        }

    @After
    public void teardown(){
       driver.close();
        }
}
