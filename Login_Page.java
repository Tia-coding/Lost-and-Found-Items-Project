package lost_found_items;


import java.sql.*;
import java.util.Scanner;

public class Login_Page 
{
    public boolean login_verify() throws Exception
    {
        String url="jdbc:mysql://localhost:3306/test";
        String id="root";
        String pass="";
        String query="select * from userlogin where id=? and password=?";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        
        PreparedStatement pst=con.prepareStatement(query);
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your user id ");
        String id1=sc.next();
        sc.nextLine();
        System.out.println("Enter your password ");
        String pass1=sc.next();
        
        pst.setString(1, id1);
        pst.setString(2, pass1);
        
        ResultSet rs=pst.executeQuery();
        
        if(rs.next()) {
            System.out.println("Login Successful!");
            //  ADDED: Go to menu
            new Lost_Found_menu().menu();
            return true;
        }
        else {
            System.out.println("Invalid Login! Please register first.");
            //  ADDED: Go to registration
            new Registration_Page().register();
            return false;
        }
    }
}
