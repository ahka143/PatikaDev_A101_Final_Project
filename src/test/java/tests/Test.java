package tests;

import org.openqa.selenium.interactions.Actions;
import pages.HepsiBuradaPages;
import utilities.ConfigReader;
import utilities.Driver;

public class Test {

    @org.testng.annotations.Test
    public void test01(){
        HepsiBuradaPages hepsiBuradaPages=new HepsiBuradaPages();
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        hepsiBuradaPages.cerezKabulEt.click();
        actions.moveToElement(hepsiBuradaPages.girisButonu).perform();
        hepsiBuradaPages.girisButonu2.click();
        hepsiBuradaPages.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        hepsiBuradaPages.girisButonu3.click();

    }


}
