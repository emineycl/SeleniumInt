package HomeWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_HomeWork {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.facebook.com");

        if (driver.getTitle().contains("facebook")) {
            System.out.println("Facebook title = " + driver.getTitle());
        }else {
            System.out.println("Facebook title is: " +driver.getTitle());
        }
        Thread.sleep(2000);
        if (driver.getCurrentUrl().contains("facebook")) {
            System.out.println("Facebook Url contains 'facebook'");
        }else {
            System.out.println(driver.getCurrentUrl());
        }
         Thread.sleep(2000);
        driver.navigate().to("https://www.walmart.com/");
        Thread.sleep(2000);

        if (driver.getTitle().contains("Walmart.com")) {
            System.out.println("https://www.walmart.com/ contains " + "Walmart.com");
        } else {
            System.out.println(driver.getTitle());
        }
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.close();

    }

}
