package com.laba.solvd.collection;

import com.laba.solvd.exception.NegativeNumberException;
import com.laba.solvd.interfaces.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class  GenericLinkedList<T> implements List<T>, Information {
    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public int size() { //works
        return size;
    }

    @Override
    public boolean isEmpty() { //works
        return head == null;
    }

    @Override
    public boolean contains(Object obj) { //works
        Node curr = head;

        while(curr != null) {
            if(curr.data.equals(obj))
                return true;
            curr = curr.next;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() { // check
        return new Iterator<>() {
            private Node curr = head;

            public boolean hasNext() {
                return curr != null;
            }

            public T next() {
                T data = curr.data;
                curr = curr.next;
                return data;
            }

            public void remove() {
                throw new UnsupportedOperationException("Unused");
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node curr = head;

        for(int i = 0; i < size; i++) {
            arr[i] = curr.data;
            curr = curr.next;
        }

        return arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Unused");
    }

    @Override
    public boolean add(T obj) { //works
        Node newNode = new Node(obj);

        if (head == null) {
            head = newNode;
        }
        else {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(Object obj) { // check
        Node prev = head;
        Node curr = head;

        if (head.data.equals(obj)) {
            head = head.next;
            size--;
            return true;
        }

        while (curr != null) {
            if (curr.data.equals(obj)) {
                curr = curr.next;
                prev.next = curr;
                size--;
                return true;
            }

            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) { // check
        AtomicBoolean bool = new AtomicBoolean();
        bool.set(true);
        c.stream().forEach(obj -> {
            if (!contains(obj))
                bool.set(false);
        });
        return bool.get();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) { // check
        int preSize = size;
        c.stream().forEach(item -> { add(item); });
        return preSize < size;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) { // check
        try {
            if (index <= 0 || index > size)
                throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.print("Invalid index.\nProvide a valid index : ");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                try {
                    index = scanner.nextInt();
                    if (index < 0)
                        throw new IndexOutOfBoundsException();
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.out.print("Invalid index.\nProvide a valid index : ");
                }
            }
        }

        int preSize = size;
        AtomicInteger idx = new AtomicInteger(index);
        c.stream().forEach(item -> {
            add(idx.getAndIncrement(), item);
        });
        return preSize < size;
    }

    @Override
    public boolean removeAll(Collection<?> c) { // check
        int preSize = size;
        c.stream().forEach(obj -> {
            if (contains(obj))
                remove(obj);
        });
        return preSize > size;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unused");
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

    @Override
    public T get(int index) {
        Node curr = head;

        try {
            if (index <= 0 || index > size)
                throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.print("Invalid index.\nProvide a valid index : ");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                try {
                    index = scanner.nextInt();
                    if (index < 0)
                        throw new IndexOutOfBoundsException();
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.out.print("Invalid index.\nProvide a valid index : ");
                }
            }
        }

        while(index-- != 0)
            curr = curr.next;
        return curr.data;
    }

    @Override
    public T set(int index, T element) {
        Node curr = head;

        try {
            if (index <= 0 || index > size)
                throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.print("Invalid index.\nProvide a valid index : ");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                try {
                    index = scanner.nextInt();
                    if (index < 0)
                        throw new IndexOutOfBoundsException();
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.out.print("Invalid index.\nProvide a valid index : ");
                }
            }
        }

        while (index-- != 0)
            curr = curr.next;

        T temp = curr.data;
        curr.data = element;
        return temp;
    }

    @Override
    public void add(int index, T element) {
        Node prev = head;
        Node curr = head;
        Node newNode = new Node(element);

        try {
            if (index <= 0 || index > size)
                throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.print("Invalid index.\nProvide a valid index : ");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                try {
                    index = scanner.nextInt();
                    if (index < 0)
                        throw new IndexOutOfBoundsException();
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.out.print("Invalid index.\nProvide a valid index : ");
                }
            }
        }

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            while(index-- != 0) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = newNode;
            newNode.next = curr;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        Node prev = head;
        Node curr = head;

        try {
            if (index <= 0 || index > size)
                throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.print("Invalid index.\nProvide a valid index : ");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                try {
                    index = scanner.nextInt();
                    if (index < 0)
                        throw new IndexOutOfBoundsException();
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.out.print("Invalid index.\nProvide a valid index : ");
                }
            }
        }

        T temp = curr.data;
        if (index == 0)
            head = head.next;
        else {
            while (index-- != 0) {
                prev = curr;
                curr = curr.next;
            }

            temp = curr.data;
            curr = curr.next;
            prev.next = curr;
        }

        size--;
        return temp;
    }

    @Override
    public int indexOf(Object obj) {
        int index = 0;
        Node curr = head;

        while(curr != null) {
            if(curr.data.equals(obj))
                return index;
            index++;
            curr = curr.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        int index = 0;
        int lastIndex = -1;
        Node curr = head;

        while(curr != null) {
            if(curr.data.equals(obj))
                lastIndex = index;
            index++;
            curr = curr.next;
        }

        return lastIndex;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Unused");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Unused");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new GenericLinkedList<T>();
        int diff = toIndex - fromIndex;
        Node curr = head;

        Scanner scanner = new Scanner(System.in);
        try {
            if (fromIndex < 0 || fromIndex > size || toIndex < 0 || toIndex > size)
                throw new IndexOutOfBoundsException();
            if (diff < 0)
                throw new NegativeNumberException();
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Invalid index(s).\nPlease provide valid start index and end index.");
            scanner = new Scanner(System.in);
            while(true) {
                try {
                    System.out.print("From index : ");
                    fromIndex = scanner.nextInt();
                    System.out.print("From index : ");
                    toIndex = scanner.nextInt();
                    diff = toIndex - fromIndex;
                    if (fromIndex < 0 || fromIndex > size || toIndex < 0 || toIndex > size)
                        throw new IndexOutOfBoundsException();
                    if (diff < 0)
                        throw new NegativeNumberException();
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.out.print("Invalid index(s).\nPlease provide valid start index and end index.");
                } catch (NegativeNumberException ex) {
                    System.out.print("End index must be greater than start index.\nPlease provide valid start index and end index.");
                }
            }
        } catch (NegativeNumberException e) {
            System.out.print("End index must be greater than start index.\nPlease provide valid start index and end index.");
            scanner = new Scanner(System.in);
            while(true) {
                try {
                    System.out.print("From index : ");
                    fromIndex = scanner.nextInt();
                    System.out.print("From index : ");
                    toIndex = scanner.nextInt();
                    diff = toIndex - fromIndex;
                    if (fromIndex < 0 || fromIndex > size || toIndex < 0 || toIndex > size)
                        throw new IndexOutOfBoundsException();
                    if (diff < 0)
                        throw new NegativeNumberException();
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.out.print("Invalid index(s).\nPlease provide valid start index and end index.");
                } catch (NegativeNumberException ex) {
                    System.out.print("End index must be greater than start index.\nPlease provide valid start index and end index.");
                }
            }
        }

        while(fromIndex-- != 0)
            curr = curr.next;

        while(diff-- != 0) {
            subList.add(curr.data);
            curr = curr.next;
        }

        return subList;
    }

    @Override
    public void getInfo() {
        Node curr = head;
        int i = 0;
        
        if(curr == null)
            System.out.println("EMPTY LIST");

        while(curr != null) {
            System.out.println("[" + i++ + "] " + curr.data);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        return "LinkedListGeneric{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericLinkedList<?> that = (GenericLinkedList<?>) o;
        return size == that.size && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }
}
