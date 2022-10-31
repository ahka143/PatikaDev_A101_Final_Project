package tests;


import org.testng.annotations.Test;
import pages.HepsiBuradaAllPages;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

public class KayitliKullanici {


    @Test
    public void kayitliKullaniciTest() {
        HepsiBuradaAllPages elements= new HepsiBuradaAllPages();

        elements.mainPage().hepsiBuradaKayitliKullaniciGiris();
        Log.info(HepsiBuradaAllPages.assertEquals(elements.mainPage().girisButonu.getText().equals("Hesabim")));
        Log.info("Kayitli kullanici hesabina basariyla giris yapildi");

        elements.mainPage().hepsiBuradaArama("kalem");
        Log.info("Kalem kelimesi arandi");

        elements.aramaSonucuPage().ilkUrun.click();
        Log.info("Ilk urune tiklandi");

        ReusableMethods.switchWindow();

        String urunAdi = elements.aramaSonucuPage().urunAdiText.getText();
        ReusableMethods.elemntWaitAndClick(elements.aramaSonucuPage().sepeteEkle1);
        ReusableMethods.elemntWaitAndClick(elements.aramaSonucuPage().sepeteEkle2);


        Log.info("Sepete eklenen urunun texti alindi");
        elements.aramaSonucuPage().sepetimButonu.click();
        Log.info("Sepete Gidildi");
        Log.info(HepsiBuradaAllPages.
                assertEquals(elements.sepetimPage().sepettekiUrunlerList.get(0).getText().contains(urunAdi) &&
                        elements.sepetimPage().sepettekiUrunlerList.get(1).getText().contains(urunAdi)));
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().quit();
        Log.info("Cikis yapildi");

    }


}