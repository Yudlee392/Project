/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class Deliver {
    Runtime rt = Runtime.getRuntime();
    int maxBuffer = 50;
    int maxMessage = 10000;
    Queue buffer;
    long memoryUsedBefore;
    long memoryUsedAfter;
    String destination="";

    public Deliver()
    {
    }

    public void deliverMessage(String sourceString){
        rt.gc();
        memoryUsedBefore = rt.totalMemory() - rt.freeMemory();
        buffer = new Queue(maxBuffer);
        char[] source = sourceString.toCharArray();

        int n = 0;
        try
        {
            while(n<source.length && n<maxMessage)
            {
                while(buffer.count()<maxBuffer && n<maxMessage)
                {
                    buffer.enqueue(source[n]);
                    n++;

                    if (buffer.isFull()){
                        memoryUsedAfter = rt.totalMemory() - rt.freeMemory();
                    }
                }
//                measure
                if (memoryUsedAfter==0){
                    memoryUsedAfter = (rt.totalMemory()-rt.freeMemory());
                }
                //when buffer full push
                while(buffer.count()!=0){
                    destination += String.valueOf(buffer.dequeue());
                }
            }
        }
        catch (Exception e){
            //when error happen, push the remaining characters to destination
            while(buffer.count()!=0){
                destination += String.valueOf(buffer.dequeue());
            }
        }
    }

    public void showMessage(){
        System.out.println("This is your message:");
        System.out.println(destination);
    }
}
