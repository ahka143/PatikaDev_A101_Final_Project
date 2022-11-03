package tests;


import org.testng.annotations.Test;
import pages.HepsiBuradaAllPages;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

public class KayitliKullanici {
    HepsiBuradaAllPages elements;

    @Test
    public void kayitliKullaniciTest() {
        elements = new HepsiBuradaAllPages();

        elements.mainPage().hepsiBuradaKayitliKullaniciGiris();

        ReusableMethods.assertEquals(elements.mainPage().girisButonu.getText().equals("Hesabım"));
        Log.info("Kayitli kullanici hesabina basariyla giris yapildi");

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