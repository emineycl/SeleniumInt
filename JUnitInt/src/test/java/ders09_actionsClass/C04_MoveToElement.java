package ders09_actionsClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class C04_MoveToElement extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists”
        //    menusunun acilmasi icin mouse’u bu menunun ustune getirelim
     WebElement accountListElementi= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
     /* //*[text()='Account & Lists']   eller //a[@id='nav-link-accountList']*/
        Actions actions=new Actions(driver);
        actions.moveToElement(accountListElementi).perform();

        Thread.sleep(5000);

        //3- “Create a list” butonuna basalim
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();


        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        WebElement yourListElementi= driver.findElement(By.xpath("//li[@id='my-lists-tab']"));  ////div[@role='heading']
        Assert.assertTrue(yourListElementi.isDisplayed());                                                      //*[text()='Your Lists']
        bekle(5);
    }
}