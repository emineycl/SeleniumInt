package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {



    /*...Exercise1...
   1- Create a new class under Q1 create main method
    2-Set Path
    3-Create chrome driver
    4-Maximize the window
    5-Open google home page https://www.google.com/.
    6-On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
    7-Navigate forward to amazon
    8-Refresh the page
    9-Close/Quit the browser
    10-And last step : print "All Ok" on console
     */

       /*1*/ public static void main(String[] args) throws InterruptedException {
           /*2*/ System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        /*3*/ WebDriver driver=new ChromeDriver();

      /*4*/  driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // ->ImplicitlyWait Selenium från bibliotek

        Thread.sleep(2000);

       /*5*/ driver.get("https://www.google.com/");
        Thread.sleep(2000);

       /*6*/ driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

       /*7*/ driver.navigate().back();
        Thread.sleep(2000);

       /*8*/ driver.navigate().forward();
        Thread.sleep(2000);

        /*9*/driver.navigate().refresh();
        Thread.sleep(2000);

     /*9*/ driver.close();

        /*10*/ System.out.println("All Ok");



    }
 }