package domain.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Member {
    private String voornaam;
    private String achternaam;
    private String adres;
    private String email;
    private LocalDate geboortedatum;

    public Member(String pvoornaam){
        this.setVoornaam(pvoornaam);
    }

    public Member(String pachternaam, String pvoornaam, String padres, String pemail, String pdatum){
        this.setAchternaam(pachternaam);
        this.setVoornaam(pvoornaam);
        this.setAdres(padres);
        this.setEmail(pemail);
        this.setGeboortedatum(pdatum);
    }

    public Member(String pachternaam, String pvoornaam, String padres, String pemail){
        this.setAchternaam(pachternaam);
        this.setVoornaam(pvoornaam);
        this.setAdres(padres);
        this.setEmail(pemail);
    }

    public void setVoornaam(String voornaam){
        if (voornaam == null || voornaam.isEmpty()){
            throw new IllegalArgumentException("De voornaam mag niet leeg zijn.");
        }
        this.voornaam = voornaam;
    }

    public String getVoornaam(){
        return voornaam;
    }

    public void setAchternaam(String achternaam){
        if (achternaam == null || achternaam.isEmpty()){
            throw new IllegalArgumentException("De achternaam mag niet leeg zijn.");
        }
        this.achternaam = achternaam;
    }

    public String getAchternaam(){
        return achternaam;
    }

    public void setAdres(String adres){
        if (adres == null || adres.isEmpty()){
            throw new IllegalArgumentException("Het adres mag niet leeg zijn.");
        }
        this.adres = adres;
    }

    public String getAdres(){
        return adres;
    }

    public void setEmail(String email){
        if (email == null || email.isEmpty()){
            throw new IllegalArgumentException("De email mag niet leeg zijn.");
        }
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setGeboortedatum(String geboortedatum){
        if (geboortedatum == null){
            throw new IllegalArgumentException("De geboortdeatum mag niet leeg zijn");
        }
        this.geboortedatum = LocalDate.parse(geboortedatum);
    }

    public String getdatum(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = geboortedatum.format(formatter);
        return geboortedatum.format(formatter);
    }

    public int age(){
        LocalDate now=LocalDate.now(); 		//gets localDate
        Period diff=Period.between(geboortedatum, now);	//difference between the dates is calculated
        int age = diff.getYears();
        return age;
    }
}
