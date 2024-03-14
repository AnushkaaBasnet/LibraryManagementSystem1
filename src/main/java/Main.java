
        import model.Books;
        import model.Users;
        import model.Burrowed;

        import java.sql.Connection;
        import java.util.Calendar;
        import java.util.List;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = DBUtils.connect();
        DBUtils db = new DBUtils();
        Books be = new Books();
        Users ue=new Users();

        Scanner sc = new Scanner(System.in);
                System.out.println("What would you like to do? (1/2/3)");
                System.out.println("1. Add Books");
                System.out.println("2. View Books");
                System.out.println("3. Delete Books");
                System.out.println("4. Add User");
                System.out.println("5. Edit Return Status");
                System.out.println("6. Log out");
                String res=sc.next();
                if(res.equals("1")){
                    be.populate_book();
                    db.insert_books(connection,be.getName(),be.getAuthor(),be.getISBN(),,be.getAvailable(),be.getFine());
                }else if(res.equals("2")){
                    List<Books> new_bookList=DBUtils.getAllBooks(connection);
                    System.out.println("+----+------------------------+----------------+");
                    System.out.println("| ID |       Book Name        |    Author Name|");
                    System.out.println("+----+------------------------+----------------+");

                    for(Books b:new_bookList){
                        System.out.printf("| %-2d | %-22s | %-14s |\n", b.getId(), b.getName(), b.getAuthor());


                    } System.out.println("+----+------------------------+----------------+");


                }else if(res.equals("3")){

                    System.out.println("Enter the record id that you want to DELETE: ");
                    int del_id=sc.nextInt();
                    db.delete_books(del_id,connection);
                }
                else if(res.equals("4")){
                    ue.Signup_User();
                    db.insert_user(connection,ue.getName(),ue.getContact(),ue.getEmail(),ue.getPassword());
                }
                else if(res.equals("5")){
                    System.out.println("Enter the record id that has been RETURNED: ");
                    int ret_id=sc.nextInt();


                }
                else if(res.equals("6")){
                    break;
                }

            }

        } else if( bool){

            if(bool) {
                while(true){
                    int id=db.get_id(connection,email);
                    String name=db.get_name(connection,email);

                    CurrentUser cs=new CurrentUser(id,name);
                    System.out.println("Welcome "+cs.getName());
                    System.out.println("What would you like to do? (1/2/3)");
                    System.out.println("1 Borrow Book ");
                    System.out.println("2. View Books ");
                    System.out.println("3. Log Out ");
                    int res2=sc.nextInt();
                    if (res2==1) {
                        System.out.println("Enter the record id that you want to BORROW: ");
                        Calendar calendar = Calendar.getInstance();
                        java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());
                        calendar.add(Calendar.DAY_OF_YEAR, 8);
                        java.sql.Date futureDate = new java.sql.Date(calendar.getTime().getTime());

                        // Insert the dates into the database


                        int bor_id=sc.nextInt();
                        db.borrow_books(connection,id,bor_id,currentDate,futureDate,"0");
                    } else if (res2 == 2) {
                        List<BookList> new_bookList = DBUtils.getAllBooks(connection);
                        System.out.println("+----+------------------------+----------------+");
                        System.out.println("| ID |       Book Name        |    Author Name |");
                        System.out.println("+----+------------------------+----------------+");

                        for (BookList b : new_bookList) {
                            System.out.printf("| %-2d | %-22s | %-14s |\n", b.getId(), b.getName(), b.getAuthor());


                        }
                        System.out.println("+----+------------------------+----------------+");

                    } else if (res2==3) {
                        break;
                    }
                }
            }
        }else{
            System.out.println("Incorrect Credentials");
        }
        System.out.println("End OF Program");
    }
}
