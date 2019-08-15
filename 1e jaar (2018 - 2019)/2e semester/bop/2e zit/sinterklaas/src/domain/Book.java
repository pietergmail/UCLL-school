package domain;

public class Book {
    private String title;
    private String author;
    private int words;

    public Book(String title, String author, int words) {
        setAuthor(author);
        setTitle(title);
        setWords(words);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    public int getWords() {

        return words;
    }

    private void setWords(int words) {
        if (words < 0)
            throw new IllegalArgumentException("A book can not be less then zero pages.");
        this.words = words;
    }

    public String age(){
        if(this.words > 0 && this.words <= 250){
            return "The recommended age is 0 to less than 2";
        }
        if(this.words > 250 && this.words <= 850){
            return "The recommended age is 2 to 4";
        }
        if(this.words > 850 && this.words <= 3000){
            return "The recommended age is 5 to 7";
        }

        if(this.words > 3000 && this.words <= 10000){
            return "The recommended age is 6 to 9";
        }

        if(this.words > 10000 && this.words <= 50000){
            return "The recommended age is 10 to 13";
        }
        return " The recommende ager is 14 and up";
    }
}

