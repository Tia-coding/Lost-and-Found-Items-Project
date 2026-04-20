package lost_found_items;

import java.sql.*;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.*;

public class Lost_Found_service {

    String url="jdbc:mysql://localhost:3306/test";
    String id="root";
    String password="";
    
    public void addItem() throws Exception
    {
        String query1="insert into lostitem values(?,?,?,?,?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection(url,id,password);
        PreparedStatement ps1=con.prepareStatement(query1);
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the itemid:");
        int itemid=sc.nextInt();
        System.out.println("Enter the itemname:");
        String itemname=sc.next();
        //sc.next();
        System.out.println("Enter the category:");
        String category=sc.next();
        //sc.next();
        System.out.println("Enter the foundat:");
        String foundat=sc.next();
       // sc.next();
        System.out.println("Enter the price:");
        int price=sc.nextInt();
        //sc.next();
        System.out.println("Enter the status:");
        String status=sc.next();
        //sc.next();
        System.out.println("Enter the report_time:");
        String report_time=sc.next();    
        //sc.next();
        
        ps1.setInt(1,itemid);
        ps1.setString(2,itemname);
        ps1.setString(3,category);
        ps1.setString(4,foundat);
        ps1.setInt(5,price);
        ps1.setString(6,status);
        ps1.setString(7,report_time);
        
        ps1.executeUpdate();
        
        ps1.close();
        con.close();
       
        
        System.out.println("Item Added Successfully!");
        
        //  ADDED: Back to menu
        new Lost_Found_menu().menu();
    }
    
    public void viewItem() throws Exception
    {
        String query2="select * from lostitem";
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection(url,id,password);
        Statement st1=con.createStatement();
        
        ResultSet rs=st1.executeQuery(query2);
        while(rs.next())
        {
            System.out.println(rs.getInt("itemid")+" "+rs.getString("itemname")+" "+rs.getString("category")+" "+rs.getString("foundat")+" "+rs.getInt("price")
            +" "+rs.getString("status")+" "+rs.getString("report_time"));
        }
        
        //  ADDED: return to menu
        new Lost_Found_menu().menu();
    }

    public void sortItem(Describe_Item_Comparator[] items) throws Exception
    {
        Describe_Item_Comparator c1=new Describe_Item_Comparator();
        for(int i=0; i<items.length-1;i++)
            for(int j=i+1;j<items.length;j++)
            {
                if(c1.compare(items[i],items[j])>0)
                {
                    Describe_Item_Comparator temp=items[i];
                    items[i]=items[j];
                    items[j]=temp;
                }
            }
        System.out.println("Items in the item class are sorted in descending order");
        
        // ADDED
        new Lost_Found_menu().menu();
    }
    
    public void takeBackup(Describe_Item_Comparator[] items) throws Exception
    {
        FileOutputStream text1=new FileOutputStream("Lost_Found_Backup.ser");
        ObjectOutputStream ob1=new ObjectOutputStream(text1);
        ob1.writeObject(items);
        ob1.close();
        System.out.println("Items backup is taken");

        //  ADDED
        new Lost_Found_menu().menu();
    }

    public void inspectItems()
    {
        try {
            Class cls = Describe_Item_Comparator.class;

            System.out.println("\n--- CLASS INSPECTION USING REFLECTION ---");

            System.out.println("\nClass Name:");
            System.out.println(cls.getName());

            System.out.println("\nConstructors:");
            Constructor[] constructors = cls.getDeclaredConstructors();
            for (Constructor c : constructors) {
                System.out.println(c);
            }

            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }

        } catch (Exception e) {
           System.out.println("not found");
        }
    }

}

