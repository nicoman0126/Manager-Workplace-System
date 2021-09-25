import java.util.Scanner;
import java.time.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[]args){
        Clock clock = Clock.systemDefaultZone();
        Instant processTime = clock.instant().plusSeconds(9);
        Instant switchStaff = clock.instant().plusSeconds(40);
        IKEA store = new IKEA();
        loadInOrders(store);
        sadlowercasemenu();
        Scanner object = new Scanner(System.in);
        while(true){
            if(object.hasNext()){
                while(!object.hasNextInt()){
                    object.nextLine(); // Helps clear buffers.
                    System.out.println( "Please enter in a NUMBER.");
                }
                int choice = object.nextInt();
                if(choice == 1){
                    store.getManager().addOrder(makeOrder());
                    store.assignOrder();
                    System.out.println("An order has been added.");
                        
                }
                else if(choice == 2){
                    System.out.println("These are the incomplete orders: ");
                    int index = 0;
                    while(index < store.getManager().getAssignments().size()){
                        System.out.println(store.getManager().getAssignments().get(index).toString());
                        index++;
                    }
                    System.out.println("These are the completed orders: ");
                    store.getDone();
                    index = 0;
                    while(index < store.getDone().size()){
                        System.out.println(store.getDone().get(index).toString());
                        index++;
                    }
                }
                else if(choice == 3){
                    int count = 0;
                    System.out.println("The Manager");
                    System.out.println(store.getManager().toString());
                    System.out.println("List of Employees:");
                    while (count < store.getEmployee().size()){
                        System.out.println(store.getEmployee().get(count).toString());
                        count = count + 1;
                    }
                }
                else if(choice == 4){
                    break;
                }
                else{
                    System.out.println("Please enter a number between 1 and 4.");
                }
            }
           
            if(processTime.compareTo(clock.instant()) < 0){
                store.processOrder();
                store.assignOrder();
                System.out.println("Order(s) are now processed.");
                processTime = clock.instant().plusSeconds(9);
            }
            if(switchStaff.compareTo(clock.instant()) < 0){
                store.switchStaff();
                System.out.println("The manager has changed.");
            }
            sadlowercasemenu();
        }
    }
    public static void sadlowercasemenu(){
        System.out.println("What would you like to do? 1: Add an order");
        System.out.println("2: View the completed orders");
        System.out.println("3: See who is on staff current");
        System.out.println("4: Exit program");
        //https://github.com/kamranahmedse/developer-roadmap


    }
    public static Order makeOrder(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter in customer name"); 
        System.out.print(": ");
        String customer = in.nextLine();
        while(customer == ""){
            System.out.println("Please enter in customer name"); 
            System.out.print(": ");
            customer = in.nextLine();
        } 
        System.out.println("Please enter in order name"); 
        System.out.print(": ");
        String ordername = in.nextLine();
        while(ordername == ""){
            System.out.println("Please enter in order name"); 
            System.out.print(": ");
            ordername = in.nextLine();
        }
        //in.close();
        return new Order(ordername, customer);
    }
    public static void loadInOrders(IKEA store){
        try{
            File menuFile = new File("orders.txt");
            Scanner reader = new Scanner(menuFile);
            while(reader.hasNextLine()){
                String c = reader.nextLine();
                System.out.println(c);
                String o = reader.nextLine();
                store.getManager().addOrder(new Order(o,c));
            }
        } catch(FileNotFoundException e){
            System.out.println("Unable to find file");
        }  catch(Exception e){
            System.out.println(e);
        }  
    }
}