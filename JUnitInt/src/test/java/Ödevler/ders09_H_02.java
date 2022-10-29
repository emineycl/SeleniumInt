package Ödevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ders09_H_02 extends TestBase {

//    1- Bir Class olusturalim KeyboardActions2
//2- https://html.com/tags/iframe/ sayfasina gidelim
//  3- video’yu gorecek kadar asagi inin
//4- videoyu izlemek icin Play tusuna basin
//5- videoyu calistirdiginizi test edin
        @Test
    public void test01() throws InterruptedException {

    //2- https://html.com/tags/iframe/ sayfasina gidelim
    driver.get("https://html.com/tags/iframe/");

    //  3- video’yu gorecek kadar asagi inin
         Actions actions=new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN).perform();

      /*      WebElement iframeVideoElementi = driver.findElement(By.xpath("//div[@class=\"render\"]"));

            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].scrollIntoView();", iframeVideoElementi);

          <===Sayfa asagi bu sekilde de kaydirilabilir ====>
            */

    //4- videoyu izlemek icin Play tusuna basin
            WebElement ilkIframe= driver.findElement(By.xpath("//iframe[@width='560']"));
            driver.switchTo().frame(ilkIframe);
            bekle(3);
            WebElement playButton= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
            playButton.click();

    //5- videoyu calistirdiginizi test edin
            WebElement isVideoPlayed= driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']"));
            Assert.assertTrue(isVideoPlayed.isDisplayed());

        }


}
