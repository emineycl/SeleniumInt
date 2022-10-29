package Ödevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ders10_H_01 extends TestBase {
    //  “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    // “Our Products” butonuna basin
    //“Cameras product”i tiklayin
    // Popup mesajini yazdirin
    //“close” butonuna basin
    //"WebdriverUniversity.com (IFrame)" linkini tiklayin
    //"http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test01() throws InterruptedException {
        //  “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // “Our Products” butonuna basin
       WebElement ilkIframe= driver.findElement(By.xpath("//iframe[@id='frame']"));
       driver.switchTo().frame(ilkIframe);
        WebElement ourButonu= driver.findElement(By.xpath("//*[text()='Our Products']"));
        ourButonu.click();

        //“Cameras product”i tiklayin
        WebElement camera= driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]"));
        camera.click();

        // Popup mesajini yazdirin
        WebElement popUp= driver.findElement(By.xpath("//div[@class='modal-content']"));
        popUp.click();
        System.out.println(popUp.getText());

        //“close” butonuna basin
        WebElement closeButonu= driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        closeButonu.click();

        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        WebElement iframeLink= driver.findElement(By.xpath("(//div[@class='container'])[1]"));
        iframeLink.click();

        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedWebSite="http://webdriveruniversity.com/index.html";
        String actualWebSite=driver.getCurrentUrl();
        Assert.assertEquals(expectedWebSite,actualWebSite);


    }

}
