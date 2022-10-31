package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HepsiBuradaAllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class KayitsizKullanici {

    @Test
    public void kayitsizKullaniciTest() {

        HepsiBuradaAllPages elements= new HepsiBuradaAllPages();
        elements.mainPage().kayitsizKullaniciGirisi();
        elements.mainPage().hepsiBuradaArama("kalem");

        Log.info("Kayitsiz kullanici olarak giris yapildi");

        Log.info("Kalem kelimesi arandi");

        elements.aramaSonucuPage().ilkUrun.click();
        Log.info("Ilk urune tiklandi");

        ReusableMethods.switchWindow();

        String urunAdi = elements.aramaSonucuPage().urunAdiText.getText();
        ReusableMethods.scroolDowntoPixel(800);

       elements.aramaSonucuPage().sepeteEkle1.click();
        //ReusableMethods.waitForVisibility(elements.aramaSonucuPage().sepeteEkleList.get(1),10);
ReusableMethods.waitForVisibility(elements.aramaSonucuPage().sepeteGitButonu,10);
elements.aramaSonucuPage().popupKapat.click();
        elements.aramaSonucuPage().sepeteEkle2.click();

        Log.info("Sepete eklenen urunun texti alindi");

        elements.aramaSonucuPage().sepetimButonu.click();
        Log.info("Sepete Gidildi");
        Log.info(HepsiBuradaAllPages.
                assertEquals(elements.sepetimPage().sepettekiUrunlerList.get(0).getText().contains(urunAdi) &&
                        elements.sepetimPage().sepettekiUrunlerList.get(1).getText().contains(urunAdi)));
        Driver.getDriver().quit();
        Log.info("Cikis yapildi");
    }
}
