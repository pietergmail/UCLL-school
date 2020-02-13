package be.ucll.oop.cargo;

import be.ucll.oop.DomainException;

import java.util.ArrayList;
import java.util.List;

public class Vrachtwagen {
	private String nummerplaat;
	private List<Cargo> cargo;
	private boolean heeftGasOfVloeistofCargo;

	public Vrachtwagen(String nummerplaat) {
		this.cargo = new ArrayList<>();
		this.heeftGasOfVloeistofCargo = false;
		setNummerplaat(nummerplaat);
	}

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
		if (heeftGasOfVloeistofCargo) {
			throw new DomainException("Vrachtwagen mag maar één cargo vervoeren indien van type vloeistof of gas");
		}
		if (cargo instanceof GasOfVloeistofCargo) {
			heeftGasOfVloeistofCargo = true;
		}
		this.cargo.add(cargo);
	}

	public void removeCargo(Cargo cargo) {
		this.heeftGasOfVloeistofCargo = false;
		this.cargo.remove(cargo);
	}
}
