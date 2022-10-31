package tests.day13_testNGFrameWork;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_TestNGIlkTest extends TestBase {



        @Test(priority = 10)
        public void ilkTest(){
            driver.get("https://wwww.amazon.com");
        }
        @Test
        public void ikinciTest(){
            driver.get("https://www.youtube.com/");
        }
        @Test
        public void ucuncuTest(){
            driver.get("https://wisequarter.com/");
        }
    }


