package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        System.out.println(driver.getWindowHandle());
        //bize acilan browser'in handle degerini döndurur
        //CDwindow-8F212F0E64212F153CEC2E4E4DCDD8E0
        //CDwindow-4027B81A88572E37EDCD79796D709BC1

        System.out.println(driver.getWindowHandles());
        //[CDwindow-85265C34C40332B00A7C1A4E6DC61170]   //koseli parantez olmasinin sebebi Set olmasi*
        /*
        eger  testimiz sirasinda birden fazla window acilirsa
        acilan tum window'larin window handle degerlerini bir Set olarak döndurur.
        window'lar arasi gecisi bu handle degerleri ile yapariz
         */

        driver.get("https://amazon.com");
        System.out.println(driver.getPageSource());
        // websayfasinin tum kaynak kodlarini döndurur

        driver.close();
    }
}
