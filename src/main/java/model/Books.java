package model;

public class Books {
    int id;
    String Name;
    String Author;
    int ISBN;
    int Available;
    String Fine;

    public Books(int id, String name, String author, int ISBN, int available, String fine) {
        this.id = id;
        Name = name;
        Author = author;
        this.ISBN = ISBN;
        Available = available;
        Fine = fine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getAvailable() {
        return Available;
    }

    public void setAvailable(int available) {
        Available = available;
    }

    public String getFine() {
        return Fine;
    }

    public void setFine(String fine) {
        Fine = fine;
    }


}
