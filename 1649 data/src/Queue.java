/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class Queue {
    protected String messageContent[];
    protected int front, rear, size, capacity;
    public Queue(int n){
        size = n;
        capacity = 0;
        messageContent = new String[size];
        front = -1;
        rear = -1;
    }
    public boolean isEmpty(){
        return front == -1;
    }
    public boolean isFull(){
        return front == 0 && rear == size - 1;
    }
    public int getSize(){
        return capacity;
    }
    public void enqueue(String message){
        if(rear==1){
            front = 0;
            rear = 0;
            messageContent[rear] = message;
        }
        else if(rear+1>=size){
            throw new IndexOutOfBoundsException("Queue is full");
        }else if(rear+1<size){
            rear++;
            messageContent[rear] = message;
        }
        capacity++;
    }
    public String deQueue(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Queue is empty");
        }else{
            capacity--;
            String message = messageContent[front];
            if(front==rear){
                front = -1;
                rear = -1;
            }else{
                front++;
            }
            return message;
        }
    }
    public void display(){
        if(isEmpty()||capacity==0){
            System.out.println("Queue is empty");
            return;
        }else{
            for(int i=front;i<=rear;i++){
                System.out.println(messageContent[i]);
            }
        }
    }
}
