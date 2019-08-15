package domain;

public class Food {
    String type;
    String allergy;

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getAllergy() {
        return allergy;
    }

    private void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public Food(String type, String pallergy) {
        setType(type);
        setAllergy(pallergy);
    }
}
