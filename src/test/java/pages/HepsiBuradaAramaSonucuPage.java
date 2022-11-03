package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;



public class HepsiBuradaAramaSonucuPage {

    public HepsiBuradaAramaSonucuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='i0']")
    public WebElement ilkUrun;

    @FindBy(xpath = "//span[@class='addToCartButton']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "(//button[@class='add-to-basket button small'])[1]")
    public WebElement sepeteEkle1;


    @FindBy(xpath = "//*[text()='Sepetim']")
    public WebElement sepetimButonu;

    @FindBy(xpath = "//h1")
    public WebElement urunAdiText;


    @FindBy(xpath = "//h1//a")
    public WebElement popupKapat;


    public void farkliSaticilardanUrunEkleme() {
        HepsiBuradaAramaSonucuPage hepsiBuradaAramaSonucuPage = new HepsiBuradaAramaSonucuPage();
        hepsiBuradaAramaSonucuPage.sepeteEkleButonu.click();
        ReusableMethods.elemntWaitAndClick(hepsiBuradaAramaSonucuPage.popupKapat);
        ReusableMethods.scroolDowntoPixel(800);
        ReusableMethods.elemntWaitAndClick(hepsiBuradaAramaSonucuPage.sepeteEkle1);
    }
}
