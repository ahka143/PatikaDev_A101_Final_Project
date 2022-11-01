package tests;


import org.testng.annotations.Test;
import pages.HepsiBuradaAllPages;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

public class KayitliKullanici {


    @Test
    public void kayitliKullaniciTest() {
        HepsiBuradaAllPages elements = new HepsiBuradaAllPages();

        elements.mainPage().hepsiBuradaKayitliKullaniciGiris();
        Log.info(HepsiBuradaAllPages.assertEquals(elements.mainPage().girisButonu.getText().equals("Hesabım")));
        Log.info("Kayitli kullanici hesabina basariyla giris yapildi");

        elements.mainPage().hepsiBuradaArama("iphone");
        Log.info("Kalem kelimesi arandi");

        elements.aramaSonucuPage().ilkUrun.click();
        Log.info("Ilk urune tiklandi");

        ReusableMethods.switchWindow();

        String urunAdi = elements.aramaSonucuPage().urunAdiText.getText();
        Log.info("Sepete eklenen urunun texti alindi");

        elements.aramaSonucuPage().sepeteEkleButonu.click();
        ReusableMethods.elemntWaitAndClick(elements.aramaSonucuPage().popupKapat);
        ReusableMethods.scroolDowntoPixel(800);
        ReusableMethods.elemntWaitAndClick(elements.aramaSonucuPage().sepeteEkle1);


        elements.aramaSonucuPage().sepetimButonu.click();
        Log.info("Sepete Gidildi");
        Log.info(HepsiBuradaAllPages.
                assertEquals(elements.sepetimPage().sepettekiUrunlerList.get(0).getText().contains(urunAdi) &&
                        elements.sepetimPage().sepettekiUrunlerList.get(1).getText().contains(urunAdi)));
        Driver.getDriver().manage().deleteAllCookies();
        //Driver.getDriver().quit();
        Log.info("Cikis yapildi");

    }


}