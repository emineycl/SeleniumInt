package Ödevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {


    public WebDriver driver;
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

