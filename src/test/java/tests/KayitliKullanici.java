package tests;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HepsiBuradaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

import java.util.Set;

import static org.testng.Assert.*;

public class KayitliKullanici {


    @org.testng.annotations.Test
    public void kayitliKullaniciTest() {
        HepsiBuradaPages hepsiBuradaPages = new HepsiBuradaPages();

        HepsiBuradaPages.hepsiBuradaKayitliKullaniciGiris();
        HepsiBuradaPages.dogrulamaMethodu("Hesabim", hepsiBuradaPages.girisButonu);
        Log.info("Hesabima girildi");

        HepsiBuradaPages.hepsiBuradaArama("kalem");
        Log.info("Kalem kelimesi arandi");
        hepsiBuradaPages.ilkUrun.click();
        String ilkSayfaWindowHandle = Driver.getDriver().getWindowHandle();

        Set<String> windowHandlesSet = Driver.getDriver().getWindowHandles();
        for (String each : windowHandlesSet
        ) {
            if (each != ilkSayfaWindowHandle) {
                Driver.getDriver().switchTo().window(each);
            }
        }

        String urunAdi = hepsiBuradaPages.urunAdiText.getText();

        hepsiBuradaPages.sepeteEkleList.get(0).click();
        HepsiBuradaPages.elemntWaitAndClick(hepsiBuradaPages.sepeteEkleList.get(1));

        hepsiBuradaPages.sepetimButonu.click();

        String sepettekiIlkUrunText = hepsiBuradaPages.sepettekiUrunlerList.get(0).getText();
        String sepettekiIkinciUrunText = hepsiBuradaPages.sepettekiUrunlerList.get(1).getText();

        assertTrue(sepettekiIlkUrunText.contains(urunAdi) && sepettekiIkinciUrunText.contains(urunAdi));
        Driver.getDriver().quit();
        Log.info("Cikis yapildi");

    }


}