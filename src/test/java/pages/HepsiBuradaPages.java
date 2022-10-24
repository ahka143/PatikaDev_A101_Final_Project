package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

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

    @FindBy (xpath = "//*[text()='Sepete git']")
    public WebElement sepeteGitButonu;
}
