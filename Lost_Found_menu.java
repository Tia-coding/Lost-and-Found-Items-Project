package lost_found_items;

import java.util.Scanner;
public class Lost_Found_menu {

    public void menu() throws Exception {
        Scanner sc=new Scanner(System.in);

        while(true) {
            System.out.println("\n--- LOST & FOUND MENU ---");
            System.out.println("1. Add Lost/Found Item");
            System.out.println("2. View Items");
            System.out.println("3. Sort Items");
            System.out.println("4. Take Backup");
            System.out.println("5. Logout");

            int ch=sc.nextInt();
            
            switch(ch) {
            case 1: new Lost_Found_service().addItem(); break; 
            case 2: new Lost_Found_service().viewItem(); break; 
            case 3: System.out.println("Sorting feature requires array input"); break;
            case 4: System.out.println("Backup feature requires items array"); break;
            case 5:
                System.out.println("Logged out!");
                new Login_Page().login_verify(); //  RETURN TO LOGIN
                return;
            default:
                System.out.println("Invalid choice!");
            }
        }
    }
}
