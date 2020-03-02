package domain.model;

public enum Role {
	ADMIN("AdMin"), CUSTOMER("CustoMer");
	
	private String stringValue;
	
	private Role(String stringValue) {
		this.stringValue = stringValue;
	}
	
	public String getStringValue() {
		return stringValue;
	}
	
	
}
