package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HepsiBuradaPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

import static org.testng.Assert.*;

public class Test {


    @org.testng.annotations.Test
    public void kullaniciGirisliTest() {
        HepsiBuradaPages hepsiBuradaPages = new HepsiBuradaPages();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        hepsiBuradaPages.cerezKabulEt.click();
        actions.moveToElement(hepsiBuradaPages.girisButonu).perform();
        hepsiBuradaPages.girisButonu2.click();
        hepsiBuradaPages.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        ReusableMethods.jsClick(hepsiBuradaPages.girisButonu3);
        hepsiBuradaPages.passwordTextBox.sendKeys(ConfigReader.getProperty("userPassword"));
        hepsiBuradaPages.getGirisButonuSon.click();

        String expectedText = "Hesabım";
        String actualText = hepsiBuradaPages.girisButonu.getText();

        assertEquals(actualText, expectedText);

        hepsiBuradaPages.aramaKutusu.click();
        hepsiBuradaPages.aramaKutusu.sendKeys("kalem", Keys.ENTER);
        String ilkSayfaWindowHandle = Driver.getDriver().getWindowHandle();
        hepsiBuradaPages.ilkUrun.click();
        Set<String> windowHandlesSet = Driver.getDriver().getWindowHandles();
        for (String each : windowHandlesSet
        ) {
            if (each != ilkSayfaWindowHandle) {
                Driver.getDriver().switchTo().window(each);
            }
        }
        String urunAdi = hepsiBuradaPages.urunAdiText.getText();

        hepsiBuradaPages.sepeteEkleList.get(0).click();
        ReusableMethods.waitForClickablility(hepsiBuradaPages.sepeteEkleList.get(1), 5);
        hepsiBuradaPages.sepeteEkleList.get(1).click();
        ReusableMethods.waitForClickablility(hepsiBuradaPages.sepeteGitButonu, 5);
        hepsiBuradaPages.sepeteGitButonu.click();

        String sepettekiIlkUrunText = hepsiBuradaPages.sepettekiUrunlerList.get(0).getText();
        String sepettekiIkinciUrunText = hepsiBuradaPages.sepettekiUrunlerList.get(1).getText();

        assertTrue(sepettekiIlkUrunText.contains(urunAdi) && sepettekiIkinciUrunText.contains(urunAdi));
        Driver.getDriver().quit();

    }

    @org.testng.annotations.Test
    public void kullaniciGirissizTest() {
        Driver.getDriver().quit();
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