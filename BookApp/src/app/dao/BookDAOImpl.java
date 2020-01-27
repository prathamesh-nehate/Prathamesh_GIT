package app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import app.pojo.Book;

public class BookDAOImpl implements BookDAO {

    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public int addBook(Book book) {
        int row = 0;
        Connection con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("Insert into BOOKS values(?,?,?)");
            ps.setInt(1, book.getIsbn());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    @Override
    public List<Book> findAllBooks() {
        Connection con = getConnection();
        List<Book> books = new ArrayList<Book>();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from BOOKs");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                books.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    

        return books;
    }
    @Override
    public List<Book> findAllByAuthor(String author) {
        Connection con = getConnection();
        List<Book> books = new ArrayList<Book>();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from BOOKS where AUTHOR = ?");
            ps.setString(1,author);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                books.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    @Override
    public List<Book> findAllByName(String name) {
        Connection con = getConnection();
        List<Book> books = new ArrayList<Book>();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from BOOKS where name = ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                books.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    @Override
    public Book delete(int isbn) {
        Connection con = getConnection();
        Book b = new Book();
        
        try {
            PreparedStatement ps = con.prepareStatement("select * from BOOKS where isbn = "+isbn,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.next();
            b = new Book(rs.getInt(1),rs.getString(2),rs.getString(3));
            rs.deleteRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public Boolean update(int isbn, String author) {
        Connection con = getConnection();
        Boolean b = false;
        try {
            PreparedStatement ps = con.prepareStatement("Update books set author = ? where isbn = ?");
            ps.setString(1,author);
            ps.setInt(2,isbn);
            b = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
        
        
    }

    @Override
    public Book getBookISBN(int isbn) {
        Connection con = getConnection();
        Book b = new Book();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from BOOKS where isbn = " + isbn);
            ResultSet rs = ps.executeQuery();
            rs.next();
            b = new Book(rs.getInt(1),rs.getString(2),rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }

    @Override
    public boolean validateUser(String name) {
        boolean  b = false;
        Connection con = getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("Select * from BOOKS where name = ?");
            ps.setString(1,name);
            b = ps.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return b;
    }
}