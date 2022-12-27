
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class Main {
    public static void Main(String[] args)
    {
    Deliver deliver = new Deliver();
    TimeStop time = new TimeStop();

    Scanner sc = new Scanner(System.in);

    System.out.printf("Enter your message (max: %s): ", deliver.maxMessage);
    String source = sc.nextLine();

    boolean key = true;
    while (key)
    {
        if (source.length()==0){
            System.out.println("Empty input, please try again");
            System.out.printf("Enter your message (max: %s): ", deliver.maxMessage);
            source = sc.nextLine();
            System.out.println();
        }
        else key = false;
    }
    if (source.length()<= deliver.maxMessage)
    {
        //time the function
        time.Start();
        deliver.deliverMessage(source);
        time.Stop();
        deliver.showMessage();
        System.out.printf("deliverred successfully %s characters!", deliver.destination.length());
        System.out.println();
        System.out.printf("Time to perform action is: %s microseconds",time.Elapse()/1000);
        System.out.println();
        System.out.printf("Buffer size: %s",deliver.maxBuffer);
        System.out.println();
        System.out.printf("Memory used: %s KB",(deliver.memoryUsedAfter- deliver.memoryUsedBefore)/1024);
        System.out.println();
    }
    else
    {
        System.out.println("your input too long, some part might not get transferred");
        //time the function
        time.Start();
        deliver.deliverMessage(source);
        time.Stop();
        deliver.showMessage();
        System.out.printf("transferred successfully %s characters!", deliver.destination.length());
        System.out.println();
        System.out.printf("Time to perform action is: %s microseconds",time.Elapse()/1000);
        System.out.println();
        System.out.printf("Buffer size: %s",deliver.maxBuffer);
        System.out.println();
        System.out.printf("Memory used: %s KB",(deliver.memoryUsedAfter- deliver.memoryUsedBefore)/1024);
        System.out.println();
    }
    }
}