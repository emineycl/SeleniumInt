package Ödevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ders08_H_01  extends TestBase {
// ● Bir class olusturun: IframeTest02
//1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
// 2) sayfadaki iframe sayısını bulunuz.
// 3) ilk iframe’deki (Youtube) play butonuna tıklayınız.
// 4) ilk iframe’den çıkıp ana sayfaya dönünüz
//5) ikinci iframe’deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız

    @Test
    public void iframeTest02(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz

        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2) sayfadaki iframe sayısını bulunuz.
        WebElement iframeYaziElementi= driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframeYaziElementi);
        WebElement declineCookies= driver.findElement(By.xpath("//*[text()='Accept All']"));
        declineCookies.click();
        driver.switchTo().defaultContent();

        // 3) ilk iframe’deki (Youtube) play butonuna tıklayınız.
        WebElement iframeYaziElementi2= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
       driver.switchTo().frame(iframeYaziElementi2);
       WebElement youtubeButton= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        youtubeButton.click();

        // 4) ilk iframe’den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe’deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement jmeterMadeEasy= driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(jmeterMadeEasy);
        WebElement guruLink= driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
        guruLink.click();
}
}

/*
package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {

 public    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        ;
    }
public static void bekle(int bekelnecekSaniye) throws InterruptedException {
        try {
        Thread.sleep(bekelnecekSaniye*1000);
}catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
 */