package HomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day05_10_10_H02 {
// 1. “https://www.saucedemo.com” Adresine gidin
// 2. Username kutusuna “standard_user” yazdirin
// 3. Password kutusuna “secret_sauce” yazdirin
// 4. Login tusuna basin
// 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
// 6. Add to Cart butonuna basin
// 7. Alisveris sepetine tiklayin
// 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
// 9. Sayfayi kapatin

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        // 2. Username kutusuna “standard_user” yazdirin
        WebElement usernameKutusu= driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameKutusu.sendKeys("standard_user" + Keys.ENTER);
        Thread.sleep(1000);

        // 3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordKutusu= driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys("secret_sauce" + Keys.ENTER);
        Thread.sleep(1000);

        // 4. Login tusuna basin
        WebElement loginTusu=driver.findElement(By.xpath("//input[@type='submit']"));
        loginTusu.click();
        Thread.sleep(1000);

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
       WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
       ilkUrun.click();
       Thread.sleep(1000);

        // 6. Add to Cart butonuna basin
        WebElement cartButonu=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        cartButonu.click();
        Thread.sleep(1000);

        // 7. Alisveris sepetine tiklayin
        WebElement alisverisSepeti=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        alisverisSepeti.click();

        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepetKontrol= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        if (sepetKontrol.isDisplayed()) {
            System.out.println("Urunun gorunuyor, test PASSED ");
        }else {
            System.out.println("Urun sepette gorunmuyor , test FAILED");
        }
        Thread.sleep(1000);

        // 9. Sayfayi kapatin
        driver.close();
}
}