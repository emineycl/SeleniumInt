package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C06_ExcelimapYapma {

    @Test
    public void excelMapTesti() throws IOException {

        //Bazen excel'deki datayi kod alanimiza almak isteriz

        String dosyaYolu=System.getProperty("user.home") + "/Desktop/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //Excel'de birden fazla sutun oldugu icin list gibi bir yapiya
        //bu bilgileri depolamak mumkun olmaz
        //reel database'e en yakin java yapisi olan map kullanabiliriz

        //ingilizce ulke ismi key
        //driver 3 bilgiyi birlestirdigimiz String ise value olsun

        Map<String, String> ulkelerMapi=new TreeMap<>();

        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <sonSatirIndexi ; i++) {
            String keyUlke=workbook
                                 .getSheet("Sayfa1")
                                 .getRow(i)
                                 .getCell(0)
                                 .toString();
            String valueUlke=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
     ulkelerMapi.put(keyUlke,valueUlke);
        }
        System.out.println(ulkelerMapi);

        //Ingilizce ismi Barbados olan ulkenin baskent isminin ingilizce olarak Bridgetown oldugunu test edin


    }
}
