//rewrite class to handle input and logic in class to increase modularity
// customer.collectInfo() + customer.displayInfo()
import java.util.*;

//customer class to create/collect/display customer data
public class Customer {
    private String name; //will only do one string for first and last name to keep data handling simpler
    private String contact; //String used because no mathematical logic needed for contact numbers
    private int roomNum;

    Scanner scanner = new Scanner(System.in); //scanner instance for user input
    public static void customer(){
        return;
    }
    //method for collecting customer name and contact
    public void collectInfo(){
        System.out.println("Enter customer name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter contact phone number: \n (Numbers only) ");
        this.contact = scanner.nextLine();
        System.out.println("Enter customer room number: ");
        this.roomNum = scanner.nextInt();
    }
    //method to display collected customer data
    public void displayInfo(){
        System.out.println("\nCustomer Info: ");
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
        System.out.println("Room Number: " + roomNum);
    }

    //getters for returning Info -> don't need setters since we have collectInfo and it's simple
    public String getContact(){
        return contact;
    }
    public String getName(){
        return name;
    }
    public int getRoomNum(){
        return roomNum;
    }

    //genRoomNum() not needed since we will assign room number

    //function to generate room number
    //will change to assign customer to desired room instead of random in future
    //room number 1-400
    //public void genRoomNum(){
    //    roomNum = (int)(Math.random() * 400) + 1;
    //}
    //getters/setters for roomNum
    //public int getRoomNum(){
    //    return roomNum;
    //}
    //public void setRoomNum(int roomNum){
    //    this.roomNum = roomNum;
    //}
}
