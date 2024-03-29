/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implement;
import interfaces.List;
import java.util.Arrays;
import java.util.Iterator;
/**
 *
 * @author Yudlee
 */
public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private int size;
    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E element) {
        if (this.size == this.elements.length) {
            this.elements = grow();
        }
        this.elements[this.size++] = element;
        return true;
    }
    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length *2);
    }

    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        insert(index, element);
        return true;
    }

    private void insert(int index, E element) {
        if (this.size == this.elements.length) {
            this.elements = grow();
        }
        E lastElement = this.getElement(this.size - 1);
        for (int i = this.size -1; i >index; i--) {
            this.elements[i] = this.elements[i-1];
        }
        this.elements[this.size] = lastElement;
        this.elements[index] = element;
        this.size++;
    }

    public int getIndex(E element) {
        for (int i = 0; i< size ; i++) {
            if(elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return this.getElement(index);
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = this.getElement(index);
        this.elements[index] = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        this.checkIndex(index);
        E element = this.getElement(index);
        this.elements[index] = null;
        shift(index);
        this.size--;
        ensureCapacity();
        return element;
    }

    public ArrayList<Integer> getMultipleIndex(E element) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i< size ; i++) {
            if(((String)elements[i]).contains((String)element)) {
                result.add(i);
            }
        }
        return result;
    }


    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i+1];
        }
    }

    private void ensureCapacity() {
        if (this.size < this.elements.length / 3) {
            this.elements = shrink();
        }
    }

    private Object[] shrink() {
        return Arrays.copyOf(this.elements, this.elements.length /2);
    }

    private void checkIndex(int index) {
        if(index <0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d for size: %d", index, this.size));
        }
    }

    private E getElement(int index) {
        return (E) this.elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        for (int i =0; i<elements.length; i++) {
            if (element.equals(elements[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        for (int i =0; i<elements.length; i++) {
            if (element.equals(elements[i])) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index <size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i< size ; i++) {
            result.append(elements[i]+ " \n");
        }
        return result.toString();
    }
}
