package domain;

public class Operatie {

    private String code;
    private String beschrijving;
    private int duur;
    private String afdeling;

    public Operatie(String code, String beschrijving, int duur, String afdeling) {

        setCode(code);
        setBeschrijving(beschrijving);
        setDuur(duur);
        setAfdeling(afdeling);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getDuur() {
        return duur;
    }

    public void setDuur(int duur) {
        this.duur = duur;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    @Override
    public String toString() {

        return "Operatie " +
                "code='" + code + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", duur=" + duur +
                ", afdeling='" + afdeling + '\'' +
                '}';
    }
}
