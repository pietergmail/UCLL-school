import domain.boek;

public class BibliotheekApp {

    public static void main(String[] args){
        boek cursus = new boek("bop", "ikke",   500, 10);

        System.out.println("Je bent het boek " + cursus.geefNaam() +
                " van auteur " + cursus.geefAutheur() + " aan het lezen,"
                + " dit is een boek van " + cursus.geefpaginas() + " pagina's dik.");

        System.out.println("Het gemiddeld aantal pagina's per hoofdstuk zal zijn: " + cursus.paginasperhoofdstuk());
    }

    /*public static void main(String[] args) {

        String boekHTMLCSSTitel = "HTML&CSS";
        String boekHTMLCSSAuteur = "Duckett";
        int boekHTMLCSSAantalPaginas = 999;
        int boekHTMLCSSAantalHoofdstukken = 10;

        System.out.println("Je bent het boek " + boekHTMLCSSTitel +
                " van auteur " + boekHTMLCSSAuteur + " aan het lezen,"
                + " dit is een boek van " + boekHTMLCSSAantalPaginas + " pagina's dik.");

        System.out.println("Het gemiddeld aantal pagina's per hoofdstuk zal zijn: " + boekHTMLCSSAantalHoofdstukken/boekHTMLCSSAantalPaginas);
        String boekJavaScriptTitel = "JavaScript&jQuery";
        String boekJavaScriptAuteur = "Duckett";

        int boekJavaScriptAantalPaginas = 1400;
        int boekJavaScriptAantalHoofdstukken = 12;

        System.out.println("Je bent het boek " + boekJavaScriptTitel +
                " van auteur " + boekJavaScriptAuteur + " aan het lezen,"
                + " dit is een boek van " + boekJavaScriptAantalPaginas + " pagina's dik.");

        System.out.println("Het gemiddeld aantal pagina's per hoofdstuk zal zijn: " +
                boekJavaScriptAantalPaginas/boekJavaScriptAantalHoofdstukken);
    }*/
}