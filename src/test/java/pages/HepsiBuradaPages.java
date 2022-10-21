package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPages {

    public HepsiBuradaPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='Giriş Yap'])[1]")
    public WebElement girisButonu;

    @FindBy(xpath = "(//*[text()='Giriş Yap'])[2]")
    public WebElement girisButonu2;

    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement userEmail;

    @FindBy(xpath = "//button[@name='btnLogin']")
    public WebElement girisButonu3;

    @FindBy (xpath = "//*[text()='Kabul Et']")
    public WebElement cerezKabulEt;
}
