package tests;

import org.openqa.selenium.Keys;
import pages.HepsiBuradaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class KayitsizKullanici {

    @org.testng.annotations.Test
    public void kayitsizKullaniciTest() {

        HepsiBuradaPages hepsiBuradaPages = new HepsiBuradaPages();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

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
        System.out.println(urunAdi);
        hepsiBuradaPages.cerezKabulEt.click();
        ReusableMethods.waitForClickablility(hepsiBuradaPages.sepeteEkleList.get(0), 5);
        ReusableMethods.scroolDowntoPixel(800);
        hepsiBuradaPages.sepeteEkleList.get(0).click();
        ReusableMethods.waitForClickablility(hepsiBuradaPages.sepeteEkleList.get(1), 10);
        hepsiBuradaPages.sepeteEkleList.get(1).click();
        ReusableMethods.waitForVisibility(hepsiBuradaPages.sepeteGitButonu, 5);
        hepsiBuradaPages.sepeteGitButonu.click();

        String sepettekiIlkUrunText = hepsiBuradaPages.sepettekiUrunlerList.get(0).getText();
        String sepettekiIkinciUrunText = hepsiBuradaPages.sepettekiUrunlerList.get(1).getText();
        System.out.println(sepettekiIlkUrunText);
        System.out.println(sepettekiIkinciUrunText);
        assertTrue(sepettekiIlkUrunText.contains(urunAdi) && sepettekiIkinciUrunText.contains(urunAdi));
        Driver.getDriver().quit();
    }
}
