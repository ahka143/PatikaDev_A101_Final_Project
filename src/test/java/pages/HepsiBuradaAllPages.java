package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HepsiBuradaAllPages {

    private  HepsiBuradaMainPage hepsiBuradaMainPage;
    private  HepsiBuradaAramaSonucuPage hepsiBuradaAramaSonucuPage;
    private  HepsiBuradaSepetimPage hepsiBuradaSepetimPage;


    public  HepsiBuradaMainPage mainPage(){

        if (hepsiBuradaMainPage==null){
            hepsiBuradaMainPage=new HepsiBuradaMainPage();
        }
        return hepsiBuradaMainPage;
    }

    public HepsiBuradaAramaSonucuPage aramaSonucuPage(){

        if(hepsiBuradaAramaSonucuPage==null){
            hepsiBuradaAramaSonucuPage=new HepsiBuradaAramaSonucuPage();
        }
        return hepsiBuradaAramaSonucuPage;
    }

    public HepsiBuradaSepetimPage sepetimPage(){
        if (hepsiBuradaSepetimPage==null){
            hepsiBuradaSepetimPage=new HepsiBuradaSepetimPage();
        }
        return hepsiBuradaSepetimPage;
    }

















    public static String assertEquals(Boolean condition) {
        String sonuc = "";

        try {
            assertTrue(condition);
            sonuc = "Expected ve Actual sonuc eslesti.";
        } catch (Error e) {
            sonuc = "Expected ve Actual sonuc malesef eslesmedi";
        }

        return sonuc;
    }




}
