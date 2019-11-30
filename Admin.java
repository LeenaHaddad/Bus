
package bus;

import static bus.BusesAndVacationManagement.managementMenu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Admin {
     public static void loginAdmin() throws Exception { //Begin of login admin method.

        Scanner input = new Scanner(System.in);
	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println("Enter the User name :");
        String user_name = input.next();

        System.out.println("Enter the Password: ");
        String password = input.next();

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop\\adminUsers.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        boolean check = false;

        while (line != null) {

            String[] tokens = line.split(",", 0);

            if ((tokens.length == 4) && (user_name.equals(tokens[2])) && (password.equals(tokens[3]))) {

                check = true;
                break;
            }

            line = br.readLine();
        }
        if (check == true) {
            managementMenu();
        } else {
            System.out.println("User name or password not true"
                               + "try again or make register");
        }
        br.close();
    }//End
    public static void registrationAdmin() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the full name :");
        String full_name = input.nextLine();

        System.out.println("Enter the phone number :");
        String phone_number = input.nextLine();

        System.out.println("Enter the User name :");
        String user_name = input.nextLine();

        System.out.println("Enter the Password: ");
        String password = input.nextLine();

        String concats = full_name.concat("," + phone_number);
        concats = concats.concat("," + user_name);
        concats = concats.concat("," + password);

        FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\adminUsers.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop\\adminUsers.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        Boolean check = false;
        while (line != null) {

            String[] tokens = line.split(",", 0);

            if ((tokens.length == 4) && (user_name.equals(tokens[2])) && (password.equals(tokens[3]))) {
                check = true;
                break;
            }

            line = br.readLine();
        }
        if (check == true) {
            System.out.println("The user already found,choose"
                               + " another user name please.");
        } else {
            System.out.println("Registered successfully.");

            bw.write(concats);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
}
