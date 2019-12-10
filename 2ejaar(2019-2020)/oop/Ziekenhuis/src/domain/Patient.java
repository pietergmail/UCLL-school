package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Patient {

    private String naam;
    private String voornaam;
    private LocalDateTime datumEnTijd;
    private LocalDate geboortedatum;
    private String noodnummer, beschrijving, operatiecode;


    public Patient(String naam, String voornaam, LocalDate geboortedatum, LocalDateTime datumEnTijd, String noodnummer, String beschrijving, String operatiecode) {

        setNaam(naam);
        setVoornaam(voornaam);
        setGeboortedatum(geboortedatum);
        setDatumEnTijd(datumEnTijd);
        setNoodnummer(noodnummer);
        setBeschrijving(beschrijving);
        setOperatiecode(operatiecode);

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public LocalDateTime getDatumEnTijd() {
        return datumEnTijd;
    }

    public void setDatumEnTijd(LocalDateTime datumEnTijd) {
        this.datumEnTijd = datumEnTijd;
    }

    public String getNoodnummer() {
        return noodnummer;
    }

    public void setNoodnummer(String noodnummer) {
        this.noodnummer = noodnummer;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getOperatiecode() {
        return operatiecode;
    }

    public void setOperatiecode(String operatiecode) {
        this.operatiecode = operatiecode;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                ", datum=" + datumEnTijd +
                ", noodnummer='" + noodnummer + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", operatiecode='" + operatiecode + '\'' +
                '}';
    }
}
