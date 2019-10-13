package domain;

public class boek {
    String naam;
    String Autheur;
    int hoofdstukken;
    int paginas;

    public boek(String pNaam, String pAutheur, int ppaginas, int phoofdstukken) {
        naam = pNaam;
        hoofdstukken = phoofdstukken;
        paginas = ppaginas;
        Autheur = pAutheur;
    }

    public String geefNaam(){
        return naam;
    }

    public String geefAutheur(){
        return Autheur;
    }

    public int geefpaginas(){
        return paginas;
    }

    public int geefHoofdstukken(){
        return hoofdstukken;
    }

    public int paginasperhoofdstuk(){
        return paginas/hoofdstukken;
    }

}
