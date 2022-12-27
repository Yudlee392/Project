
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Yudlee
 */
public class Main {
    Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue queue = new Queue(5);
        Stack stack = new Stack(5);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice!=4){
            System.out.println("1. Send message");
            System.out.println("2. Read message");
            System.out.println("3. Show all message");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter your message: ");
                    String message = scanner.nextLine();
                    if(message.length()>250){
                        System.out.println("Message is too long");
                        System.out.println("Message must be less than 250 characters");
                    }else{
                        try{
                            System.out.println("Sending message...");
                            queue.enqueue(message);
                        }catch(Exception e){
                            System.out.println("Error: "+e.getMessage());
                        }
                    }
                    break;
                case 2:
                    try{
                        System.out.println("Reading message...");
                        String message2 = queue.deQueue();
                        System.out.println("Message: "+message2);
                    }catch(Exception e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        System.out.println("Showing all message...");
                        queue.display();
                    }catch(Exception e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
            }
        }
    }
}
