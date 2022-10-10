package HomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tekrar_2022_10_09 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.yves-rocher.com/");

    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[1]/span")).click();
    Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[1]/div/ul/li[4]/p")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[2]/span")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[2]/div[4]/ul/li[34]/p")).click();
        Thread.sleep(2000);
       WebElement isvec= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[2]/span"));
       isvec.click();
        Thread.sleep(2000);








/*
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.yves-rocher.com/");

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[1]/span/span[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[1]/div/ul/li[4]/p")).click();

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[2]/span/span[1]")).click();

        WebElement kutucuguActi=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[1]/div[2]/div[4]/ul/li[34]/p"));







*/

    }
}
