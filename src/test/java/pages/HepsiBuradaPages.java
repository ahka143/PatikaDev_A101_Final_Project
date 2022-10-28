package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HepsiBuradaPages {

    public HepsiBuradaPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='sf-OldMyAccount-d0xCHLV38UCH5cD9mOXq'])[1]")
    public WebElement girisButonu;

    @FindBy(xpath = "(//*[text()='Giriş Yap'])[2]")
    public WebElement girisButonu2;

    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement userEmail;

    @FindBy(xpath = "//button[@name='btnLogin']")
    public WebElement girisButonu3;

    @FindBy (xpath = "//*[text()='Kabul Et']")
    public WebElement cerezKabulEt;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@name='btnEmailSelect']")
    public WebElement getGirisButonuSon;

    @FindBy (xpath = "//div[@role='combobox']")
    public WebElement aramaKutusu;

    @FindBy (xpath = "//li[@id='i0']")
    public WebElement ilkUrun;

    @FindBy (xpath = "//button[@class='add-to-basket button small']")
    public List<WebElement> sepeteEkleList;

    @FindBy (xpath = "//*[text()='Sepetim']")
    public WebElement sepetimButonu;

    @FindBy(xpath = "//h1")
    public WebElement urunAdiText;

    @FindBy (xpath = "//div[@class='product_name_3Lh3t']")
    public List<WebElement> sepettekiUrunlerList;

    public static void hepsiBuradaKayitliKullaniciGiris(){
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
    }

    public static String dogrulamaMethodu(String expectedText,WebElement actualElement){
      String sonuc="";
        String actualText = actualElement.getText();

        try {
            assertEquals(actualText, expectedText);
            sonuc="Sonuclar eslesti tebrikler";
        } catch (Error e) {
            sonuc="Sonuclar malesef eslesmedi";
        }


        return sonuc;
    }

    public static void hepsiBuradaArama(String aranacakUrun){
        HepsiBuradaPages hepsiBuradaPages = new HepsiBuradaPages();
        hepsiBuradaPages.aramaKutusu.click();
        hepsiBuradaPages.aramaKutusu.sendKeys(aranacakUrun, Keys.ENTER);
    }

    public  static void elemntWaitAndClick(WebElement elemnt){
        HepsiBuradaPages hepsiBuradaPages = new HepsiBuradaPages();
        ReusableMethods.waitForClickablility(elemnt, 5);
        elemnt.click();

    }
}
