package bus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Bus { //Begin of class.

    public static void insertBuses() throws Exception {
        Scanner input = new Scanner(System.in);

        int bus_id1 = intilized();

        String bus_id2 = bus_id1 + "";

        System.out.println("Enter Bus name:-");
        String bus_name = input.nextLine();
        
        //StringUtils.isNumeric(bus_name);
        //NumberUtils.isNumber("123");
        
        System.out.println("Enter Bus type:-");
        String bus_type = input.nextLine();

        String concats = bus_id2.concat("," + bus_name);
        concats = concats.concat("," + bus_type);

        FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\busManagement.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(concats);
        bw.newLine();

        bw.flush();
        bw.close();

    }

    public static int intilized() throws Exception {
        int num2 = 99;
        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop"
                                       + "\\busManagement.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        while (line != null) {
            String[] tokens = line.split(",", 0);
            if (tokens.length == 3) {

                num2 = Integer.parseInt(tokens[0]);

            }
            line = br.readLine();

        }
        br.close();

        return ++num2;

    }

    public static void updateBuses() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the id of bus that "
                           + "you want to update its data:");
        int old_id1 = input.nextInt();
        
        String old_id2 = old_id1 + "";

        FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\auxiliry file1.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop"
                                       + "\\busManagement.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        
        boolean check = false;
        
        while (line != null) {
            String[] tokens = line.split(",", 0);
            if (old_id2.equals(tokens[0])) {
                
                 check = true;
                 
            }
        
            if(check == true){
                
                
                System.out.println("Enter the new bus name:");
                String new_bus_name = input.next();

                System.out.println("Enter the new bus type:");
                String new_bus_type = input.next();
                
                line = old_id2.concat("," + new_bus_name);
                line = line.concat("," + new_bus_type);
               
                
                
            }
            
            else{
                System.out.println("The id of bus not true"
                                   + "try again");   
            }
            bw.write(line);
            bw.newLine();
            line = br.readLine();
            check = false;
            
        }

        bw.flush();
        bw.close();

        br.close();
        copyFilesBus();
    }
    public static void deleteBuses() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the id of bus that "
                           + "you want to update its data:");
        int old_id1 = input.nextInt();

        String old_id2 = old_id1 + "";

        FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\auxiliry file1.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop"
                                       + "\\busManagement.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        boolean check = false;//to check id if it exist in file or not
        
        while (line != null) {
            String[] tokens = line.split(",", 0);

            if (old_id2.equals(tokens[0])) {
                
                check = true;
            }
            if (check == true){
                
                line = br.readLine();
                System.out.println("Bus deleted..."); 
            }
            else{
                System.out.println("The id of bus not true"
                                   +"try again");
                
                System.out.println("Enter the id of bus that "
                                   + "you want to update its data:");
                old_id1 = input.nextInt();
                old_id2 = old_id1 + "";
            }
            

            if (line != null) {
                bw.write(line);
            }
            bw.newLine();
            line = br.readLine();
            check = false;
            
        }

        bw.flush();
        bw.close();

        br.close();

        copyFilesBus();
    }

    public static void displayBuses() throws Exception {//begin of the method

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop"
                                       + "\\busManagement.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
    }//end of the method
    public static void copyFilesBus() throws Exception {
        FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\"
                                       + "busManagement.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop\\auxiliry file1.txt");

        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {

            bw.write(line);
            bw.newLine();
            line = br.readLine();
            
        }

        bw.flush();
        bw.close();

        br.close();
    }
}
