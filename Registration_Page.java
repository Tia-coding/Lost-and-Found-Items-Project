package lost_found_items;


import java.sql.*;
import java.util.Scanner;

public class Registration_Page {

    public void register() throws Exception
    {
        String url="jdbc:mysql://localhost:3306/test";
        String id="root";
        String pass="";
        String query1="insert into users values(?,?,?,?,?)";
        String query2="insert into userlogin values(?,?,?)";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        
        PreparedStatement pst1=con.prepareStatement(query1);
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your user id ");
        int id1=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your name ");
        String name1=sc.next();
        System.out.println("Enter your email id ");
        String email1=sc.next();
        sc.nextLine();
        System.out.println("Enter your phone no. ");
        String phone1=sc.next();
        sc.nextLine();
        System.out.println("Enter your password ");
        String pass1=sc.next();
        
        pst1.setInt(1, id1);
        pst1.setString(2,name1);
        pst1.setString(3,email1);
        pst1.setString(4,phone1);
        pst1.setString(5,pass1);
        
        pst1.executeUpdate();
        
        PreparedStatement pst2=con.prepareStatement(query2);
        
        pst2.setInt(1, id1);
        pst2.setString(2,name1);
        pst2.setString(3,pass1);
        
        pst2.executeUpdate();
        
        System.out.println("You are registered with us now!!");
        
        // ADDED: Go back to login
        new Login_Page().login_verify();
    }
}
