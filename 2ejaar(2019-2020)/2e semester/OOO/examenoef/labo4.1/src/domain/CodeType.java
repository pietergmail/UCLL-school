package domain;

public enum CodeType {
    Ceasarcode("caesar","domain.Caesarcode"),
    Spiegeling("spiegeling","domain.Spiegeling");

    private final String name;
    private final String klasseNaam;

    CodeType(String name, String domain){
        this.name = name;
        this.klasseNaam = domain;
    }

    public String getName(){return name;}

    public String getKlasseNaam(){return klasseNaam;}
}
