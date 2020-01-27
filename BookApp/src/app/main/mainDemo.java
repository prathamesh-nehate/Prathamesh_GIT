package app.main;
import app.pojo.Book;

import java.util.List;
import java.util.ListIterator;

import app.dao.BookDAOImpl;

class mainDemo{
    public static void main(String[] args) {
        BookDAOImpl obj = new BookDAOImpl();

        // int row = obj.addBook(new Book(12345678,"JAVaA","GOSLasdING"));
        // System.out.println("Rows updated :=" + row);

        // Book b = obj.getBookISBN(123456789);
        // System.out.println(b);

        List<Book> b = obj.findAllBooks();
        ListIterator<Book> it = b.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // List<Book> c = obj.findAllByAuthor("JAVA");
        // ListIterator<Book> it1 = c.listIterator();
        // while(it1.hasNext()){
        //     System.out.println(it1.next());
        // }

        // List<Book> d = obj.findAllByName("GOSLING");
        // ListIterator<Book> it2 = d.listIterator();
        // while(it1.hasNext()){
        //     System.out.println(it2.next());
        // }

        obj.update(12345678,"jkop");
       // obj.delete(12345678);
        List<Book> bb = obj.findAllBooks();
        ListIterator<Book> it3 = bb.listIterator();
        while(it.hasNext()){
            System.out.println(it3.next());

        }

        System.out.println(obj.validateUser("GOSLasdING"));
    }
}