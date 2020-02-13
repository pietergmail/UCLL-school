package domain.model;

public class LetterCounter {
    private String woord;

    public String getWoord() {
        return woord;
    }

    public void setWoord(String woord) {
        this.woord = woord;
    }

    public LetterCounter(String woord){
        this.setWoord(woord);
    }

    public int aantal(String letter){
        if(letter == null){
            throw new IllegalArgumentException("Letter mag niet null zijn");
        }
        return this.getWoord().length() - this.getWoord().replaceAll(letter,"").length();
    }
}
