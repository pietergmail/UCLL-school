package domain;

import domain.Book;
import domain.Food;
import domain.Toy;

public class Gift_bag {
    Book book;
    Food food;
    Toy toy;

    public Gift_bag(Book book, Food food, Toy toy) {
        setBook(book);
        setFood(food);
        setToy(toy);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }
}
