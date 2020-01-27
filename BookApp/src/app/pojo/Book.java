package app.pojo;

public class Book{
    int isbn;
    String author, name;

    public Book(int isbn, String author, String name) {
        this.isbn = isbn;
        this.author = author;
        this.name = name;
    }

    public Book(){
        
    }
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", isbn=" + isbn + ", name=" + name + "]";
    }

}