package bus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Vacation { //Begin of class.

    public static void insertVaca() throws Exception {
        Scanner input = new Scanner(System.in);

        int vaca_id1 = intilized();//initilize vacation...

        String vaca_id2 = vaca_id1 + "";

        System.out.println("Enter Bus id:-");
        String bus_id = input.next();
        
        System.out.println("Enter number of seats:-");
        int num_of_seats1 = input.nextInt();
        String num_of_seats2 = num_of_seats1 + "";

        System.out.println("Enter the source station:-");
        String source = input.next();
        System.out.println("Enter the destination station:-");
        String destination = input.next();

        System.out.println("Enter the source time in hour:-");
        String source_time = input.next();

        System.out.println("Enter the destination time in hour:-");
        String destination_time = input.next();

        System.out.println("Enter the total duraation time :-");
        String total_dura = input.next();

        System.out.println("Enter the vacation price:-");
        String vaca_price = input.next();

        String concats = vaca_id2.concat("," + bus_id);
        concats = concats.concat("," + num_of_seats2);
        concats = concats.concat("," + source);
        concats = concats.concat("," + destination);
        concats = concats.concat("," + source_time);
        concats = concats.concat("," + destination_time);
        concats = concats.concat("," + total_dura);
        concats = concats.concat("," + vaca_price);

        FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\vacationManagement.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(concats);
        bw.newLine();

        bw.flush();
        bw.close();

    }

    public static int intilized() throws Exception {//initlize vacation id
        int num2 = 0;
        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop"
                                       + "\\vacationManagement.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        while (line != null) {
            String[] tokens = line.split(",", 0);
            if (tokens.length == 9) {

                num2 = Integer.parseInt(tokens[0]);

            }
            line = br.readLine();

        }
        br.close();

        return ++num2;

    }

    public static void updateVaca() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the id of vacation that "
                           + "you want to update its data:");
        
        int old_id1 = input.nextInt();
        String old_id2 = old_id1 + "";
        
         FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\auxiliry file1.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop"
                                       + "\\vacationManagement.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        
        boolean check = false;//to check id if it exist in file or not
        
        while (line != null) {
            String[] tokens = line.split(",", 0);
            if (old_id2.equals(tokens[0])) {
                    check = true;
            }
             if(check == true){
                System.out.println("Enter Bus id:-");
                String bus_id = input.next();

                System.out.println("Enter number of seats:-");
                int num_of_seats1 = input.nextInt();
                String num_of_seats2 = num_of_seats1 + "";

                System.out.println("Enter the source station:-");
                String source = input.next();
                System.out.println("Enter the destination station:-");
                String destination = input.next();

                System.out.println("Enter the source time:-");
                String sour_time = input.next();

                System.out.println("Enter the destination time:-");
                String dest_time = input.next();

                System.out.println("Enter the vacation price:-");
                String vaca_price = input.next();
                 
                 
                line = old_id2.concat("," + bus_id);
                line = line.concat("," + num_of_seats2);
                line = line.concat("," + source);
                line = line.concat("," + destination);
                line = line.concat("," + sour_time);
                line = line.concat("," + dest_time);
                line = line.concat("," + num_of_seats2);
                
             }else{
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
        copyFilesVaca();
    }
    public static void deleteVaca() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the id of bus that "
                           + "you want to update its data:");
        int old_id1 = input.nextInt();

        String old_id2 = old_id1 + "";

        FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\auxiliry file1.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop"
                                       + "\\vacationManagement.txt");
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
                 System.out.println("vacation deleted...");
            }
            else{
                System.out.println("The id of vacation not true"
                                   +"try again");
                
                System.out.println("Enter the id of vacation that "
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

        copyFilesVaca();
    }

    public static void displayVaca() throws Exception {

        FileReader fr = new FileReader("C:\\Users\\dell\\Desktop"
                                       + "\\vacationManagement.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();

    }
    public static void copyFilesVaca() throws Exception {
        FileWriter fw = new FileWriter("C:\\Users\\dell\\Desktop\\"
                                       + "vacationManagement.txt");
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
