/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implement;

import interfaces.AbstractQueue;
import java.util.Iterator;

/**
 *
 * @author Yudlee
 */
public class Queue2<E> implements AbstractQueue<E> {
     private Node<E> head;
    private int size;
    private static class Node<E>{
        E element;
        Node<E> next;
        public Node( E element){
            this(element,null);
        }
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }
    @Override
    public void offer(E element) {
        Node<E> node = new Node<>(element);
        if(this.head == null){
            head = node;
        }else{
            Node<E> current = this.head;
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
        }
        this.size++;
    }
    @Override
    public E poll() {
        ensureNonEmpty();
        E element = this.head.element;
        if(this.size == 0) {
            this.head = null;
        } else {
            Node<E> next = this.head.next;
            this.head.next = null;
            this.head = next;
        }
        this.size--;
        return element;
    }


    public void pollAll() {
        while (!isEmpty()) {
            poll();
        }
    }


    public boolean contains(E element) {
        Node<E> current = head;
        while (current != null) {
            if (element.equals(current.element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getIndex(E element) {
        ensureNonEmpty();
        Node<E> current = head;
        int i = 0;
        while(current!=null){
            if (current.element.equals(element)) {
                return i;
            }
            i++;
            current = current.next;
        }
        return -1;
    }

    public E getItemByIndex(int index) {
        ensureNonEmpty();
        Node<E> current = head;
        int i = 0;
        while(current!=null){
            if (i == index) {
                return current.element;
            }
            i++;
            current = current.next;
        }
        return null;
    }

    // Just for String
    public ArrayList<Integer> getMultipleIndex(E element) {
        ensureNonEmpty();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node<E> current = head;
        int i = 0;
        while(current!=null){
            if (((String)current.element).contains((String)element)) {
                result.add(i);
            }
            i++;
            current = current.next;
        }
        return result;
    }

    private void ensureNonEmpty() {
        if (size == 0) throw new IllegalStateException("Stack is Empty!!! Can not poll!");
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.head.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            private Queue2.Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Object next() {
                E element = current.element;
                this.current = current.next;
                return element;
            }
        };
    }

    @Override
    public String toString() {
        Node<E> current = head;
        StringBuilder result = new StringBuilder();
        while(current!=null){
            result.append(current.element+ " \n");
            current = current.next;
        }
        return result.toString();
    }
}
