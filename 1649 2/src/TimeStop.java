/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class TimeStop { 
    long start;
    long stop;
    public TimeStop(){
        start=stop=0;
    }
    public long Elapse(){
        return stop-start;
    }
    public void Start(){
        start=System.nanoTime();
    }
    public void Stop(){
        stop=System.nanoTime();
    }

}
