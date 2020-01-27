package app.dao;

import java.util.List;

import app.pojo.Book;


public interface BookDAO{
    int addBook(Book book);
    Book getBookISBN(int isbn);
    Boolean update(int isbn,String author);
    List<Book>findAllBooks();
    List<Book>findAllByName(String name);
    List<Book>findAllByAuthor(String author);
    Book delete(int isbn);
    boolean validateUser(String name);
}