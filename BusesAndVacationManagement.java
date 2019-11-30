package bus;

import java.util.Scanner;

public class BusesAndVacationManagement { //Begin of class.

    public static void main(String[] args) throws Exception { //Begin of main.

        Scanner input = new Scanner(System.in);

        System.out.println("            		Welcom To The"
                           + " Bus Ticket program\n		"
                           + "	--------------------------------\n");

        while (true) { //Begin of Main menu loop ..
            System.out.println("Main menu :-\n------------\nChoose"
                    + " from menu:\n1.Admin.\n2.Exit.");
            int number1 = input.nextInt();
            
            switch (number1) { //Begin of Main menu switch.

                case 1:
                    adminMenu();
                    break;
                case 2:
                    System.out.println("Goodbye.....come again.");
                    System.exit(0);
                    break;

            } //End of Main menu switch.

        } //End of Main menu loop

    } //End of main

    public static void adminMenu() throws Exception { //Begin of admin menu method.

        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();

        boolean count = true;
        while (count == true) { //Begin of Admin menu loop
            
            System.out.println("Admin menu :-\n-------------\n"
                               + "Choose from menu:\n1.Login.\n"
                               + "2.Registration.\n3.Back.");
            
            int number = input.nextInt();

            switch (number) { //Begin of Admin menu switch.

                case 1:
                    admin.loginAdmin();

                    break;

                case 2:
                    admin.registrationAdmin();

                    break;

                case 3:
                    count = false;
                    break;

            } //End of Admin menu switch.

        } //End of Admin menu loop

    }//End of admin menu method.

    public static void managementMenu() throws Exception { //Begin of management menu method.

        Scanner input = new Scanner(System.in);
        Bus bus = new Bus();
        Vacation vaca = new Vacation();
        

        int count = 1;
        while (count == 1) { //Begin of management menu loop
            
            System.out.println("Management menu :-"
                               + "\n------------------\nChoose "
                               + "from menu:\n1.Insert buses."
                               + "\n2.Update buses.\n"
                               + "3.Delete buses.\n"
                               + "4.Display buses.\n"
                               + "5.Insert vacations.\n"
                               + "6.Update vacations.\n"
                               + "7.Delete vacations\n"
                               + "8.Display vacations.\n"
                               + "9.Back.");
            
            int number = input.nextInt();

            switch (number) { //Begin of management menu switch.
                case 1:

                    bus.insertBuses();

                    break;

                case 2:
                    bus.updateBuses();

                    break;

                case 3:
                    bus.deleteBuses();

                    break;
                case 4:
                    bus.displayBuses();

                    break;
                case 5:
                    vaca.insertVaca();

                    break;
                case 6:
                    vaca.updateVaca();

                    break;
                case 7:
                    vaca.deleteVaca();

                    break;
                case 8:
                    vaca.displayVaca();

                    break;

                case 9:
                    count = -1;

                    break;

            } //End of management menu switch.

        } //End of management menu loop

    }//End of management menu method.
    
} //End of class
