/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author Yudlee
 */
public interface List<E> extends Iterable<E> {
    boolean add(E element);

    boolean add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int size();

    int indexOf(E element);

    boolean contains(E element);

    boolean isEmpty();
}
