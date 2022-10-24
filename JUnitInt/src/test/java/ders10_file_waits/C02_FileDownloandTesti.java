package ders10_file_waits;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloandTesti extends TestBase {
    @Test
    public void downloadTesti() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='logo.png']")).click();

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        bekle(7);

   //   String dosyaYolu= System.getProperty("user.home")+"\"C:\\Users\\Emine\\Downloads\\logo.png\"";
        String dosyaYolu= "/Users/Emine/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
