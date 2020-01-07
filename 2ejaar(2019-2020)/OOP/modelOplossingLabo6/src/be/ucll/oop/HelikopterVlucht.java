package be.ucll.oop;

import java.util.LinkedList;
import java.util.List;

public abstract class HelikopterVlucht extends Activiteit {
	private String code;
	private List<Coordinaat> vluchtSchema;

	public HelikopterVlucht() {
		this.vluchtSchema = new LinkedList<>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Coordinaat> getVluchtSchema() {
		return vluchtSchema;
	}
}
