/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class Stack {
    public final int maxSize;
    public int messageTopIndex;
    public String[]messageContent;
    public Stack(int maxSize){
        this.maxSize = maxSize;
        this.messageTopIndex = -1;
        this.messageContent = new String[maxSize];
    }
    public boolean isEmpty(){
        return messageTopIndex == -1;
    }
    public boolean isFull(){
        return messageTopIndex == maxSize;
    }
    public void push(String newMessageContent){
        if (isFull()){
            System.out.println("Stack is full");
        } else {
            messageTopIndex++;
            this.messageContent[messageTopIndex] = newMessageContent;
        }
    }
    public String pop(){
        String popMess="";
        try{
            popMess = this.messageContent[this.messageTopIndex];
            this.messageTopIndex--;
        }
        catch(NullPointerException nullPointerException){
            popMess = "Stack is empty"+nullPointerException;
        }
        return popMess;
    }
}
