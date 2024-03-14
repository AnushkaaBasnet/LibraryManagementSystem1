package model;

public class Users {
    int id;
    String Name;
    String Contact_no;
    String Email;

    public Users(int id, String name, String contact_no, String email) {
        this.id = id;
        Name = name;
        Contact_no = contact_no;
        Email = email;
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

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
