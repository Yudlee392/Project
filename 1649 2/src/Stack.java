/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class Stack {
    char[] arr;
    int top = -1;

    public Stack(int max){
        arr = new char[max];
    }

    public int count(){
        return top+1;
    }

    public void push(char c){
        if (top==arr.length-1)
        {
            System.out.println("stack full");
            return;
        }
        top++;
        arr[top] = c;
    }

    public char pop(){
        Character c = null;
        if (top == -1){
            System.out.println("stack empty");
            return c;
        }
        c = arr[top];
        top--;
        return c;
    }
}
