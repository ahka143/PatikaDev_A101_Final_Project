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
    HepsiBuradaAllPages elements;

    @Test
    public void kayitsizKullaniciTest() {

        elements = new HepsiBuradaAllPages();
        elements.mainPage().kayitsizKullaniciGirisi();
        elements.mainPage().hepsiBuradaArama("calgon");
        Log.info("calgon kelimesi arandi");

        elements.aramaSonucuPage().ilkUrun.click();
        Log.info("Ilk urune tiklandi");

        ReusableMethods.switchWindow();

        String urunAdi = elements.aramaSonucuPage().urunAdiText.getText();
        Log.info("Sepete eklenen urunun texti alindi");

        elements.aramaSonucuPage().farkliSaticilardanUrunEkleme();
        elements.aramaSonucuPage().sepetimButonu.click();
        Log.info("Sepete Gidildi");
        Log.info(HepsiBuradaAllPages.
                assertEquals(elements.sepetimPage().sepettekiUrunlerList.get(0).getText().contains(urunAdi) &&
                        elements.sepetimPage().sepettekiUrunlerList.get(1).getText().contains(urunAdi)));
        Driver.getDriver().quit();
        Log.info("Cikis yapildi");
    }
}
