package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;

public class HepsiBuradaMainPage {

    HepsiBuradaMainPage() {
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

    @FindBy(xpath = "//*[text()='Kabul Et']")
    public WebElement cerezKabulEt;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@name='btnEmailSelect']")
    public WebElement getGirisButonuSon;

    @FindBy(xpath = "//div[@class='desktopOldAutosuggestTheme-DgkZjXtKHeqy6zTL8GSA']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']")
    public WebElement aramaKutusuEnterButonu;

    public void hepsiBuradaKayitliKullaniciGiris() {
        HepsiBuradaMainPage hepsiBuradaPages = new HepsiBuradaMainPage();
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

    public void hepsiBuradaArama(String aranacakUrun) {
        HepsiBuradaMainPage hepsiBuradaMainPage = new HepsiBuradaMainPage();
        ReusableMethods.waitForVisibility(hepsiBuradaMainPage.aramaKutusu, 10);
        hepsiBuradaMainPage.aramaKutusu.click();

        hepsiBuradaMainPage.aramaKutusu.sendKeys(aranacakUrun);
        hepsiBuradaMainPage.aramaKutusuEnterButonu.click();
        Log.info(aranacakUrun+" kelimesi arandi");

    }

    public void kayitsizKullaniciGirisi() {
        HepsiBuradaMainPage hepsiBuradaPages = new HepsiBuradaMainPage();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        hepsiBuradaPages.cerezKabulEt.click();

    }


}
