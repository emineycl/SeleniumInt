package ders10_file_waits;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void tets01(){

        System.out.println(System.getProperty("user.dir"));     //C:\Users\Emine\Desktop\SeleniumInt\JUnitInt

        System.out.println(System.getProperty("user.home"));    //C:\Users\Emine
        //masa ustunde olusturdugumuz text file'in path'i
        //"C:\Users\Emine\Desktop\Filetesti\deneme.text.txt"

        //"C:\Users\Emine\Downloads"

        /*
        System.getProperty("user.home") tum bilgisayarlarda kullaniciya kadar olan path'i verir
        ve bu kisim her bilgisayar ve kullanici icin farklidir

         user.home'dan sonrasi tum kullanicilar ortak olabilir
          ornegin tum kullanicilarin masaustu

          user.home / Desktop

          downloads %90 kullanici icin

          user.home / Downloads

          eger birden fazla bilgisayarda file ile ilgili bir test yapacaksaniz
          dosya yolunu dinamik olarak olusturmaniz gerekir
         */

        // dinamik dosya yolu olusturma
        // masa ustunde FileTesti diye bir klasor ve onun altinda deneme diye bir text dosyasi icin

        String dosyaYolu=System.getProperty("user.home")+"/Desktop/FileTesti/deneme.txt";
        Files.exists(Paths.get("istenen dosyanin path'i"));

        System.out.println(Files.exists(Paths.get(dosyaYolu)));  //true veya false

    }
}
