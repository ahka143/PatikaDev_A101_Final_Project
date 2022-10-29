package tests;


import org.testng.annotations.Test;
import pages.HepsiBuradaPages;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

import static org.testng.Assert.*;

public class KayitliKullanici {


    @Test
    public void kayitliKullaniciTest() {
        HepsiBuradaPages hepsiBuradaPages = new HepsiBuradaPages();

        HepsiBuradaPages.hepsiBuradaKayitliKullaniciGiris();
        Log.info(HepsiBuradaPages.assertEquals(hepsiBuradaPages.girisButonu.getText().equals("Hesabim")));
        Log.info("Kayitli kullanici hesabina basariyla giris yapildi");

        HepsiBuradaPages.hepsiBuradaArama("kalem");
        Log.info("Kalem kelimesi arandi");

        hepsiBuradaPages.ilkUrun.click();
        Log.info("Ilk urune tiklandi");

        ReusableMethods.switchWindow();

        String urunAdi = hepsiBuradaPages.urunAdiText.getText();
        HepsiBuradaPages.elemntWaitAndClick(hepsiBuradaPages.sepeteEkleList.get(0));
        HepsiBuradaPages.elemntWaitAndClick(hepsiBuradaPages.sepeteEkleList.get(1));

        String sepettekiIlkUrunText = hepsiBuradaPages.sepeteEkleList.get(0).getText();
        String sepettekiIkinciUrunText = hepsiBuradaPages.sepeteEkleList.get(1).getText();
        Log.info("Sepete eklenen urunun texti alindi");
        hepsiBuradaPages.sepetimButonu.click();
        Log.info("Sepete Gidildi");
        Log.info(HepsiBuradaPages.
                assertEquals(sepettekiIlkUrunText.contains(urunAdi) && sepettekiIkinciUrunText.contains(urunAdi)));
        Driver.getDriver().quit();
        Log.info("Cikis yapildi");

    }


}