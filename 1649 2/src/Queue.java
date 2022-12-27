/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class Queue {
    int front=-1, rear = -1;
    int max;
    char[] arr;

    public Queue(int max){
        arr = new char[max];
        this.max=max;
    }

    boolean isFull(){
        return (rear+1)%max == front;
    }

    boolean isEmpty(){
        return (front == -1);
    }

    public int count(){
        if (front==0&&rear==max-1){
            return max;
        }
        if (isEmpty()){
            return 0;
        }
        return (2*max+rear-front+1)%max;
    }

    public void enqueue(char c){
        if (isFull()){
            return;
        }
        if (isEmpty()){
            front=rear=0;
        }
        else rear = (rear+1)%max;
        arr[rear]=c;
    }

    public char dequeue(){
        Character c = null;
        if (isEmpty()){
            return c;
        }
        c = arr[front];
        if (front==rear){
            front = rear = -1;
        }
        else front = (front+1)%max;
        return c;
    }
}
