package domain;

import java.time.LocalTime;

public class Optreden {

    private Artiest artiest;
    private LocalTime uur;
    private double ticketPrijs;

    public Optreden(Artiest artiest, LocalTime uur, double ticketPrijs){
        this.setArtiest(artiest);
        this.setUur(uur);
        this.setTicketPrijs(ticketPrijs);
    }
    public Optreden(Artiest artiest, LocalTime uur){
        this(artiest,uur,0);
    }

    private void setArtiest(Artiest artiest) {
        if(artiest == null || artiest.getClass() != Artiest.class) throw new DomainException("De artiest die je probeert toe te voegen is geen Artiest object!");
        this.artiest = artiest;
    }
    private void setUur(LocalTime uur) {
        if(Checker.isOngeldigUur(uur)) throw new DomainException("Het uur is ongeldig!");
        this.uur = uur;
    }
    private void setTicketPrijs(double ticketPrijs) {
        if(Checker.isOngeldigePrijs(ticketPrijs)) throw new DomainException("De prijs van een ticket is ongeldig!");
        this.ticketPrijs = ticketPrijs;
    }

    public Artiest getArtiest() {
        return this.artiest;
    }
    public LocalTime getUur() {
        return this.uur;
    }
    public double getTicketPrijs() {
        return this.ticketPrijs;
    }

    @Override
    public String toString() {
        return "Optreden: " + "\n\tArtiest: " + artiest + "\n\tOm: " + uur + " uur" + "\n\tTicket prijs: " + ticketPrijs + " euro";
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof Optreden){
            Optreden optreden = (Optreden) obj;
            if(optreden.getArtiest().equals(this.getArtiest())
                && optreden.getUur().equals(this.getUur())){
                return true;
            }
        }
        return false;
    }

}
