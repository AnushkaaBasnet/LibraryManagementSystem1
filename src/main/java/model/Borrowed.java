package model;

public class Borrowed {
    int id;
    int UserId;
    int Bookid;
    String date;
    String Return_date;
    String Return_status;

    public Borrowed(int id, int userId, int bookid, String date, String return_date, String return_status) {
        this.id = id;
        UserId = userId;
        Bookid = bookid;
        this.date = date;
        Return_date = return_date;
        Return_status = return_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getBookid() {
        return Bookid;
    }

    public void setBookid(int bookid) {
        Bookid = bookid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReturn_date() {
        return Return_date;
    }

    public void setReturn_date(String return_date) {
        Return_date = return_date;
    }

    public String getReturn_status() {
        return Return_status;
    }

    public void setReturn_status(String return_status) {
        Return_status = return_status;
    }
}