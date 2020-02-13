package domain.cargo;

import domain.DomainException;

import java.util.List;

public class Vrachtwagen {
    private String nummerplaat;
    private List<Cargo> cargo;
    private boolean heeftGasOfVloeistofCargo;

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void addCargo(Cargo cargo) throws DomainException {
        if (heeftGasOfVloeistofCargo){
            throw new DomainException("Vrachtwagen mag maar een cargo vervoeren indien van type vloeistof of gas");
        }
        if (cargo instanceof GasOfVloeistofCargo){
            heeftGasOfVloeistofCargo = true;
        }
        this.cargo.add(cargo);
    }

    public void removeCargo(Cargo cargo){
        this.heeftGasOfVloeistofCargo = false;

    }

    public boolean isHeeftGasOfVloeistofCargo() {
        return heeftGasOfVloeistofCargo;
    }

    public void setHeeftGasOfVloeistofCargo(boolean heeftGasOfVloeistofCargo) {
        this.heeftGasOfVloeistofCargo = heeftGasOfVloeistofCargo;
        this.cargo.remove(cargo);
    }
}
