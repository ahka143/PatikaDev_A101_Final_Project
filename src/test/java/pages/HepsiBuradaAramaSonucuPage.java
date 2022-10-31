package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HepsiBuradaAramaSonucuPage {

    public HepsiBuradaAramaSonucuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='i0']")
    public WebElement ilkUrun;

    @FindBy(xpath = "(//div[@class='addToCart'])[1]")
    public WebElement sepeteEkle1;
    @FindBy(xpath = "(//div[@class='addToCart'])[2]")
    public WebElement sepeteEkle2;

    @FindBy(xpath = "//*[text()='Sepetim']")
    public WebElement sepetimButonu;

    @FindBy(xpath = "//h1")
    public WebElement urunAdiText;

    @FindBy(xpath = "//*[text()='Sepete git']")
    public WebElement sepeteGitButonu;

    @FindBy(xpath = "//a[@class='checkoutui-Modal-2iZXl']")
    public WebElement popupKapat;
}