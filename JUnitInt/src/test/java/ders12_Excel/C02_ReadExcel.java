package ders12_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;


import java.io.FileInputStream;

import java.io.IOException;

public class C02_ReadExcel {

    //  7. Dosya yolunu bir String degiskene atayalim
    //  8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //  9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //  10. WorkbookFactory.create(fileInputStream)
    //  11. Worksheet objesi olusturun workbook.getSheetAt(index)
    //  12. Row objesi olusturun sheet.getRow(index)
    //  13. Cell objesi olusturun row.getCell(index)

    @Test
    public void readExcelTesti() throws IOException {

      //  7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu=System.getProperty("user.home") +"/Desktop/ulkeler.xlsx";

        //  8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

      //  9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

      //  10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        //20. satirda kod alemimizde bir workbook olusturup
        //fis objesi ile okunan excel'de ki bilgileri workbook'a yuköedik
        //boylece excel'deki datalarin bir kopyasi workbook objesine yuklendi

      //  11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");

      //  12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(13);
      //  13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(2);

        System.out.println(cell);  // Arnavutluk

        //14. 14. satirdaki ulkenin turkcesinin Bahreyn oldugunu test edin

        String expectedIsim="Bahreyn";
        String actualIsim=cell.toString();

        Assert.assertEquals(expectedIsim,actualIsim);
    }
}
