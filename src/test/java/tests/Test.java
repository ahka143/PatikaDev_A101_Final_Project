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
    public void test01() {
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
        hepsiBuradaPages.aramaKutusu.sendKeys("kalem",Keys.ENTER);
String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
        hepsiBuradaPages.ilkUrun.click();
        Set<String> windowHandlesSet=Driver.getDriver().getWindowHandles();
        for (String each:windowHandlesSet
             ) {
            if (each!=ilkSayfaWindowHandle){
                Driver.getDriver().switchTo().window(each);
            }
        }

       hepsiBuradaPages.sepeteEkleList.get(0).click();
        ReusableMethods.waitForClickablility(hepsiBuradaPages.sepeteEkleList.get(1),5);
        hepsiBuradaPages.sepeteEkleList.get(1).click();
        hepsiBuradaPages.sepeteGitButonu.click();






    }


}
