package tests;


import org.testng.annotations.Test;
import pages.HepsiBuradaAllPages;

import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class KayitsizKullanici {
    HepsiBuradaAllPages elements;

    @Test
    public void kayitsizKullaniciTest() {

        elements = new HepsiBuradaAllPages();

        elements.mainPage().kayitsizKullaniciGirisi();
        Log.info("Kayitsiz kullanici olarak giris yapildi");

        elements.mainPage().hepsiBuradaArama("calgon");

        elements.aramaSonucuPage().ilkUrun.click();
        Log.info("Ilk urune tiklandi");

        ReusableMethods.switchWindow();

        String urunAdi = elements.aramaSonucuPage().urunAdiText.getText();
        Log.info("Sepete eklenen urunun texti alindi");

        elements.aramaSonucuPage().farkliSaticilardanUrunEkleme();

        elements.aramaSonucuPage().sepetimButonu.click();

        Log.info("Sepete Gidildi");
        ReusableMethods.
                assertEquals(elements.sepetimPage().sepettekiUrunlerList.get(0).getText().contains(urunAdi) &&
                        elements.sepetimPage().sepettekiUrunlerList.get(1).getText().contains(urunAdi));

        Driver.quitDriver();
        Log.info("Cikis yapildi");
    }
}
