package domain;

public class Pizza {
    String beschrijving;
    String ingredient1;
    String ingredient2;
    String ingredient3;
    int prijs;
    boolean isvegan;

    public Pizza(String beschrijving, String ingredient1, String ingredient2, String ingredient3, int prijs, boolean isvegan) {
        setBeschrijving(beschrijving);
        setIngredient1(ingredient1);
        setIngredient2(ingredient2);
        setIngredient3(ingredient3);
        setIsvegan(isvegan);
        setPrijs(prijs);
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        if (ingredient1.equals(this.ingredient2) || ingredient1.equals(this.ingredient3))
            throw new IllegalArgumentException("Dit ingredient zit al op de pizza");
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        if (ingredient2.equals(this.ingredient1) || ingredient2.equals(this.ingredient3))
            throw new IllegalArgumentException("Dit ingredient zit al op de pizza");
            this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        if (ingredient3.equals(this.ingredient1) || ingredient3.equals(this.ingredient2))
            throw new IllegalArgumentException("Dit ingredient zit al op de pizza");
        this.ingredient3 = ingredient3;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        if(prijs > 20 || prijs < 2){
            throw new IllegalArgumentException("De pizza zijn prijs is niet corredt.");
        }
        this.prijs = prijs;
    }

    public boolean isIsvegan() {
        return isvegan;
    }

    public void setIsvegan(boolean isvegan) {
        this.isvegan = isvegan;
    }
}
