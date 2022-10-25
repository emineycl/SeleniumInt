package ders11_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;


public class C01_Cookies extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//*[text()='Accept all']"));
        driver.manage().getCookies();
        Set<Cookie> cookieSet=driver.manage().getCookies();

        for(Cookie eachCookie: cookieSet
        ) {
            System.out.println(eachCookie);
        }
        System.out.println("=========");

        Cookie cookie=new Cookie("en guzel cookie","bizim cookie");
        driver.manage().addCookie(cookie);
        System.out.println(cookie);

        bekle(5);


    }

    }

