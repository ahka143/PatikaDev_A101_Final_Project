package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HepsiBuradaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class KayitsizKullanici {

    @Test
    public void kayitsizKullaniciTest() {

        HepsiBuradaPages hepsiBuradaPages = new HepsiBuradaPages();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        Log.info("Ana sayfaya gidildi");
        ReusableMethods.waitForClickablility(hepsiBuradaPages.aramaKutusu, 10);
        hepsiBuradaPages.aramaKutusu.click();
        hepsiBuradaPages.aramaKutusu.sendKeys("kalem", Keys.ENTER);
        String ilkSayfaWindowHandle = Driver.getDriver().getWindowHandle();
        ReusableMethods.waitForClickablility(hepsiBuradaPages.ilkUrun, 10);
        ReusableMethods.scroolDowntoPixel(300);
        hepsiBuradaPages.ilkUrun.click();
        Set<String> windowHandlesSet = Driver.getDriver().getWindowHandles();
        for (String each : windowHandlesSet
        ) {
            if (each != ilkSayfaWindowHandle) {
                Driver.getDriver().switchTo().window(each);
            }
        }
        String urunAdi = hepsiBuradaPages.urunAdiText.getText();
        hepsiBuradaPages.cerezKabulEt.click();
        ReusableMethods.waitForClickablility(hepsiBuradaPages.sepeteEkleList.get(0), 5);
        ReusableMethods.scroolDowntoPixel(800);
        hepsiBuradaPages.sepeteEkleList.get(0).click();
        ReusableMethods.waitForClickablility(hepsiBuradaPages.sepeteEkleList.get(1), 10);
        hepsiBuradaPages.sepeteEkleList.get(1).click();

        hepsiBuradaPages.sepetimButonu.click();

        String sepettekiIlkUrunText = hepsiBuradaPages.sepettekiUrunlerList.get(0).getText();
        String sepettekiIkinciUrunText = hepsiBuradaPages.sepettekiUrunlerList.get(1).getText();
        assertTrue(sepettekiIlkUrunText.contains(urunAdi) && sepettekiIkinciUrunText.contains(urunAdi));
        Driver.getDriver().quit();
        Log.info("Sayfa kapatildi");
    }
}
