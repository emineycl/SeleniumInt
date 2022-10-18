package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

        public class Q2 {
    //..Exercise2...
//  http://www.bestbuy.com 'a gidin,
//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
//  Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
//  Ayrica Relative Locator kullanarak;
//      mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin

    static WebDriver driver;
    @BeforeClass
public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
}
@AfterClass
public static void tearDown(){
  driver.close();
}


@Before
    public void beforeTest(){
    driver.get("http://www.bestbuy.com");
    }
@After
    public void afterTest(){

}
    @Test
    public void baslikTesti(){
    //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    String title= driver.getTitle();
    boolean iceriyorMu=title.contains("Best");

    Assert.assertTrue("Title Best kelimesi icermiyor",iceriyorMu);


}

    @Test
    public void logoTest(){
    //  Ayrica Relative Locator kullanarak;
    //     logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin

        WebElement helloHeading=driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement bestBuyLogo= driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));

        Assert.assertTrue(bestBuyLogo.isDisplayed());

    }

    @Test
    public void linkTest(){
    // Ayrica Relative Locator kullanarak;
    //   mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
        WebElement usFlag= driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoFlag= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usFlag));

        Assert.assertFalse(!mexicoFlag.isDisplayed());
    }

}
