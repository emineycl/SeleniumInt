package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_HandleDropdownMenu {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /*
    Dropdown menuler özel web elemenetleridir ve select tag'i iel olusturulurlar
    1-
    dropdown menulerden element secebilmek icin Select class'indan obje olusturmaliyiz
     */
    @Test
    public void dropdownTest(){
        //amazona gidin
        driver.get("https://www.Amazon.com/");
        //arama kutusunun solundaki search in menusunden Electronics'i secelim
        WebElement dropdownWebelement=driver.findElement(By.id("searchDropdownBox"));
        Select select= new Select(dropdownWebelement);
        select.selectByVisibleText("Electronics");


        //arama cubugunu java yazip aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        //bulunan sonuc sayisinin 1000'den fazla oldugunu test edin

        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class=‘a-section a-spacing-small a-spacing-top-small’]"));
        String aramaSonucStr=aramaSonucElementi.getText();
      //  System.out.println(aramaSonucStr);  //1-24 of 127 results for"Java"
        //test case'in de yazdirma yapilmamali *
        int indexOfOf=aramaSonucStr.indexOf("of");
        int indexOfResults=aramaSonucStr.indexOf("results");

        int aramaSOnucSayisiInt=Integer
                .parseInt(aramaSonucStr
                .substring(indexOfOf+3,indexOfResults-1));

        Assert.assertTrue(aramaSOnucSayisiInt>1000);

    }
    @After
    public void teardown(){

        driver.close();
    }
}
