package domain;

import java.time.*;
import java.util.*;

public class Festival {

    private String                          naam;
    private LocalDate                       datum;
    private Map<Persoon, List<Optreden>>    reservaties;
    private SortedSet<Optreden>             optredens;
    private Set<Werknemer>                  werknemers;

    public Festival(String naam, LocalDate datum){
        this.setNaam(naam);
        this.setDatum(datum);
        this.setReservaties();
        this.setOptredens();
        this.setWerknemers();
    }

    private void setNaam(String naam) {
        if(Checker.isOngeldigeString(naam)) throw new DomainException("De naam van het festival mag niet leeg zijn!");
        this.naam = naam;
    }
    private void setDatum(LocalDate datum) {
        if(Checker.isOngeldigeFestivalDatum(datum)) throw new DomainException("De festival datum kan niet op vandaag staan!");
        this.datum = datum;
    }
    private void setReservaties() {
        this.reservaties = new HashMap<>();
    }
    private void setOptredens() {
        this.optredens = new TreeSet<>(new ComparatorByPrijsArtiest());
    }
    private void setWerknemers() {
        this.werknemers = new HashSet<>();
    }

    public String getNaam() {
        return this.naam;
    }
    public LocalDate getDatum() {
        return this.datum;
    }
    public Map<Persoon, List<Optreden>> getReservaties() {
        return this.reservaties;
    }
    public SortedSet<Optreden> getOptredens() {
        return this.optredens;
    }
    public Set<Werknemer> getWerknemers() { return this.werknemers;}

    public void voegOptredenToe(Artiest artiest, LocalTime tijd){
        if(artiest == null)     throw new DomainException("De artiest die je probeert toe te voegen (in een Optreden) mag niet leeg zijn!");
        if(tijd == null)        throw new DomainException("De tijd die je probeert toe te voegen (in een Optreden) mag niet leeg zijn!");
        // Geen idee of dit mag:
        try {
            Optreden nieuwoptreden  = new Optreden(artiest,tijd);
        }
        catch (DomainException exception){
            throw new DomainException("Het optreden dat je wilt toevoegen kon niet worden gemaakt: " + exception.getMessage());
        }
        Optreden nieuwoptreden  = new Optreden(artiest,tijd);
        if(this.optredens.contains(nieuwoptreden)) throw new DomainException("Het optreden dat je probeert toe te voegen bestaat al!");
        this.optredens.add(nieuwoptreden);
    }
    public void voegOptredenToe(Optreden optreden){
        if(optreden == null) throw new DomainException("Het optreden dat je probeer toe te voegen mag niet leeg zijn!");
        if(this.optredens.contains(optreden)) throw new DomainException("Het optreden dat je probeert toe te voegen bestaat al!");
        this.optredens.add(optreden);
    }
    private void voegNieuweBezoekerToe(Persoon persoon){
        if(persoon == null) throw new DomainException();
        if(this.reservaties.containsKey(persoon)) throw new DomainException("De persoon bestaat al in de lijst van reservaties!");
        this.reservaties.put(persoon, new ArrayList<>());
    }
    public void voegWerknemerToe(Werknemer nieuwewerknemer){
        if(nieuwewerknemer == null) throw new DomainException("De werknemer die je probeert toe te voegen mag niet leeg zijn!");
        if(this.werknemers.contains(nieuwewerknemer)) throw new DomainException("De werknemer die je probeert toe te voegen bestaat al!");
        this.werknemers.add(nieuwewerknemer);
    }
    public void voegReservatieToe(Persoon persoon, Optreden optreden){
        if(persoon == null) throw new DomainException("De persoon die je probeert toe te voegen (bij je Reservatie) mag niet leeg zijn!");
        if(optreden == null) throw new DomainException("Het optreden die je probeert toe te voegen (bij je Reservatie) mag niet leeg zijn!");
        if(!this.optredens.contains(optreden)) throw new DomainException("Het optreden dat je wilt toevoegen (bij je Reservatie) bestaat nog niet (op het Festival)");
        // Als de persoon nog niet bestaat dan wordt deze gemaakt
        if(!this.reservaties.containsKey(persoon)) this.voegNieuweBezoekerToe(persoon);
        // Checken of het optreden al bestaat in zijn lijst
        if(this.reservaties.get(persoon).contains(optreden)) throw new DomainException("Het optreden bestaat al bij die persoon!");
        else this.reservaties.get(persoon).add(optreden);
    }
    private boolean bestaandePersoonInReservaties(Persoon persoon){
        // Optioneel
        if(this.reservaties.containsKey(persoon)) return true;
        else return false;
    }
    public String overzichtReservatiesVoorGegevenPersoon(Persoon persoon){
        if(!this.bestaandePersoonInReservaties(persoon)) throw new DomainException("De persoon komt niet voor in de database van onze reservaties!");
        String overzicht = persoon.toString() + "\n" + "Optredens voor deze persoon: " + "\n";
        for(Optreden optreden : this.reservaties.get(persoon)){
            if(optreden != null){
                overzicht += optreden.toString() + "\n";
            }
        }
        return overzicht;
    }
    public double inkomPrijsVoorGegevenPersoon(Persoon persoon){
        if(!this.bestaandePersoonInReservaties(persoon)) throw new DomainException("De persoon komt niet voor in de database van onze reservaties!");
        double totaal = 0;
        for (Optreden optreden : this.reservaties.get(persoon)){
            if(optreden != null){
                totaal += optreden.getTicketPrijs();
            }
        }
        return totaal;
    }
    public String printLijstTeCompenserenWerkenemers(){
        String lijstMetTeCompenserenWerknemers = "";
        for(Werknemer werknemer : this.werknemers){
            if(werknemer != null && werknemer instanceof TeCompenseren){
                lijstMetTeCompenserenWerknemers += werknemer.toString();
            }
        }
        if(lijstMetTeCompenserenWerknemers.equals("")) return "Er zijn geen werknemers die moeten gecompenseerd worden!";
        else return lijstMetTeCompenserenWerknemers;
    }
    public String printOptredens(){
        String optredens = "";
        if(this.optredens.size() == 0) return "Er zijn nog geen optredens!";
        for(Optreden optreden : this.optredens){
            if(optreden != null){
                optredens += optreden.toString();
            }
        }
        return optredens;
    }

}