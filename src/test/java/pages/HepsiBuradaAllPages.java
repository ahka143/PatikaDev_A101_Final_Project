package pages;



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






















}
