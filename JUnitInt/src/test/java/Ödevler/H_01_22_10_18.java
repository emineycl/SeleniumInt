package Ödevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H_01_22_10_18 {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
 */

   static WebDriver driver;
    @BeforeClass
    static public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    static public void tearnDown(){
      // driver.close();
    }
    @Before
    public void setUp(){
        // http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");


    }
    @After
    public void afterTest(){


    }
    @Test
    public void test01() throws InterruptedException {
        // click on the "Add Element" button 100 times
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        WebElement addCart = driver.findElement(By.xpath("//button[@onclick]"));
        int baslangic = 0;
        int bitis = 100;
        Thread.sleep(1000);

        for (int i = baslangic; i <= bitis; addCart.click()) {
            i++;
            Thread.sleep(0, 5000);

            // write a function that takes a number, and clicks the "Delete" button
            driver.findElement(By.xpath("//button[@class='added-manually']")).click();
            Thread.sleep(2000);
            // given number of times, and then validates that given number of


            // buttons was deleted
            driver.findElement(By.xpath("//button[@class='added-manually']")).click();

        }

    }}
/*
WebElement addCart= driver.findElement(By.xpath("//button[@onclick]"));
int baslangic=0;
int bitis=100;
Thread.sleep(1000);

for (int i=baslangic;i <=bitis ;addCart.click()){
    i++;
    Thread.sleep(0,5000);
}
 */