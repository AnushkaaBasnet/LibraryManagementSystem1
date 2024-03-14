import model.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static final String table_Books="books";
    public static final String table_Users="users";
    public static final String table_Burrowed="users";

    public static final String books_id="id";
    public static final String books_Name="name";
    public static final String books_Author="author";
    public static final String books_ISBN="isbn";
    public static final String books_Available="available";
    public static final String books_Fine="fine";
    public static final String User_id="id";
    public static final String User_name="name";
    public static final String contact_no="contact_no";
    public static final String email="email";
    public static final String return_status="returnstatus";




    public static Connection connect() {
        Connection connection = null;
        String databaseUrl = "jdbc:sqlite:src/main/resources/database/library_management_system.db";
        try {
            connection = DriverManager.getConnection(databaseUrl);
            System.out.println("Connection Established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void insert_books(Connection connection, String name, String author, String genre, int isbn, int avialable, int fine) {
        String sql = "INSERT INTO books(name,author,genre,isbn,avialable,fine) VALUES(?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.setInt(4, isbn);
            pstmt.setInt(5, avialable);
            pstmt.setInt(6, fine);
            pstmt.executeUpdate();
            System.out.println("successful");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }

    }
    public static List<Books> getAllBooks(Connection connection){

        String query="SELECT * FROM "+table_books;
        List<Books> BookListList=new ArrayList<>();
        PreparedStatement pstmt = null;
        try{

            Statement statement= connection.createStatement();
            ResultSet rs=statement.executeQuery(query);


            while(rs.next()){

                int id=rs.getInt(books_id);

                String book_name=rs.getString((books_name));
                String book_author=rs.getString((books_author));
                String book_genre=rs.getString((books_genre));
                int book_isbn=rs.getInt(books_isbn);
                int book_avilablity=rs.getInt(books_avialable);
                int book_fine=rs.getInt(books_fine);


                BookList new_BookList=new BookList(id,book_name,book_author,book_genre,book_isbn,book_avilablity,book_fine);

                BookListList.add((new_BookList));

            }

        }catch (SQLException e){
            System.out.println("error");
            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
        return  BookListList;

    }
    public void delete_books(int id,Connection connection) {
        String sql = "DELETE FROM "+table_books+" WHERE id = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println("Delete Successful.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
    }

    public void insert_user(Connection connection, String name, int contact,String email,String password) {
        String sql = "INSERT INTO user (name,contact,email,password) VALUES(?,?,?,?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, contact);
            pstmt.setString(3, email);
            pstmt.setString(4, password);

            pstmt.executeUpdate();
            System.out.println("successful");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }

    }

    public boolean loginDatabase(Connection connection,String email,String password){


        boolean bool = false;
        String sql = "SELECT * FROM user WHERE email=? AND password=? ";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();


        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
        return bool;

    }

    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int get_id(Connection connection,String email) {
        String sql = "SELECT * FROM user WHERE email=?  ";
        PreparedStatement pstmt = null;
        int id = 0;
        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(user_id);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
        return id;
    }
    public String get_name(Connection connection,String email) {
        String sql = "SELECT * FROM user WHERE email=?  ";
        PreparedStatement pstmt = null;
        int id = 0;
        String name = null;
        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                name = rs.getString(user_name);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            close(pstmt);
        }
        return name;
    }

    public void borrow_books(Connection connection, int userid, int bookid, Date issue_date, Date return_date, String return_status) {
        String sql = "INSERT INTO borrowed (userid,bookid,issuedate,returndate,returnstatus) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try  {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, userid);
            pstmt.setInt(2, bookid);
            pstmt.setString(3, String.valueOf(issue_date));
            pstmt.setString(4, String.valueOf(return_date));
            pstmt.setString(5, return_status);

            pstmt.executeUpdate();
            System.out.println("successful");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(pstmt);
        }

    }

    public void

}