//written by Christian Ray
//Created 10/29/24
// Hotel Management Program
// I know my code is interesting lol

import java.util.*;
import java.util.concurrent.TimeUnit;

//main class to execute user prompt for hotel management system
public class Main {
    public static void main(String[] args){
        //welcome cli message
        System.out.println("Welcome to Hotel California \n");
        System.out.println("Hotel Management System");

        //call directory method
        directory.getDirectory();

        //variables for user input
        //initialize scanner variable 'objSelect' to use for user choice
        Scanner objSelect = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in); // new scanner to use during case interactions
        String input; //String variable to handle user input for (y/n)
        List<Customer> customers = new ArrayList<>(); //ArrayList to store customers

        //prompt user for input //instance variable for user selection 'choice'
        System.out.println("Please type in program number: ");
        int choice = objSelect.nextInt();

        //while loop that cycles through program execution
        outer:
        while (true) {
            //switch that directs main method to execute desired program function
            //'choice' is correlated to case to execute
            //probably could be a better way to do this using ArrayList of directory but idk how lol
            switch (choice) {
                //case 1 Adding new customers
                case 1:
                    Customer newCustomer = new Customer();
                    newCustomer.collectInfo();
                    customers.add(newCustomer); //add newCustomer info to customers list
                    System.out.println("Review Customer Info: (y/n)"); //review info
                    input = s1.nextLine();
                    if (input.equals("y")) {
                        newCustomer.displayInfo();
                    }
                    break;
                //case 2 display list of all customers
                case 2:
                    //handle case if there is no customers in customers ArrayList
                    if (customers.isEmpty()) {
                        System.out.println("No current customers");
                    } else {
                        //loop through customers and print as list for user
                        System.out.println("Customers List: \n");
                        for (Customer customer : customers) {
                            customer.displayInfo();
                            System.out.println("---------------");
                        }
                    }
                    break;
                //case 3 find customers by name
                case 3:
                    //get user input
                    System.out.println("Customer Search \n");
                    System.out.println("Enter name to search: ");
                    //searchName variable to store input and compare to customers arraylist data
                    String searchName = s1.nextLine();
                    boolean found = false; //boolean for if (!found)
                    while (true) {
                        //loops through customers ArrayList
                        for (Customer customer : customers) {
                            //compares searchName to customer.getName() data
                            if (customer.getName().equalsIgnoreCase(searchName)) {
                                //sleep timer for user readability
                                try {
                                    TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException ie) {
                                    Thread.currentThread().interrupt();
                                }
                                customer.displayInfo(); //displays if found
                                found = true; //sets boolean to true to break statement
                                break;
                            }
                            else {
                                found = false;
                            }
                        }
                        if (!found) { //if searchName not found
                            System.out.println("Customer not found.");
                        }
                        //prompt user if continue to search?
                        System.out.println("\n Search again: (y/n)");
                        String yesNo = s1.nextLine();
                        //if user input y then loop through search function again
                        if (yesNo.equals("y")) {
                            System.out.println("Enter name to search: ");
                            searchName = s1.nextLine();
                        }
                        //if user n or other symbol break statement
                        else {
                            break;
                        }
                    }


                    break;
                //case 4 exit program successfully
                case 4:
                    //breaks out of switch and while loop
                    break outer;

                default: //error handling //error message
                    System.out.println("Error! Please input number of program (1-4)!");
            }

            //sleep timer to make cli more readable between programs
            //had to google how to do this
            System.out.println(" \n Returning to menu...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            //prompt user for another program selection
            //choice is reassigned new selection -> executes switch statement and case selection in loop until user quits program
            directory.getDirectory();
            System.out.println("Select a program: ");
            choice = objSelect.nextInt();
        }
        //exit message
        System.out.println("Thanks for visiting Hotel California!");
        //sleep timer for user readability
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Good bye.");
    }
}

//method for directory // less code -> call method
class directory{
    //ArrayList of available programs
    // static final variables so that variable belongs to directory class and is shared across all instances of object
    // directory does not need to change and should be consistent across instances
    private static final String [] directory = {"1. Add New Customer, 2. Display All Customers, 3. Find Customer by Name, 4. Exit"};
    private static final ArrayList<String> directList = new ArrayList<>(Arrays.asList(directory));

    public static void getDirectory(){
        System.out.println("\n Program Directory: ");
        System.out.println(directList + "\n");
    }
}
