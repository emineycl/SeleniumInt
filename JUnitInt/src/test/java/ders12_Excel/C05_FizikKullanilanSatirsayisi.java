package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_FizikKullanilanSatirsayisi {

    @Test
    public void tets01() throws IOException {

        //ulkeler excel'inde saysa2'de fiziki olarak kullanilan satir sayisinin 15 oldugunu test edin
        String dosyaYolu=System.getProperty("user.home") + "/Desktop/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        int toplamSatirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();
        //index kullandigi icin satir sayisini bulmak icin 1 ekleyelim
        System.out.println("Toplam satir sayaisi : " + toplamSatirSayisi);


        int fizikiKullanilanSatirsayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println("Fiziki kullanilan satir sayisi : " + fizikiKullanilanSatirsayisi);

    }
}
