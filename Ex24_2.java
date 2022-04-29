
import java.util.Spliterator;
import java.util.function.Consumer;

public class Ex24_2 {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("asel");
        list.add("1234");
        list.add("1234sssss");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        System.out.println(list.contains("asd"));
        System.out.println(list.contains("fffff"));
        System.out.println();
        System.out.println(list.get(3));
        System.out.println(list.get(5));
        System.out.println();
        System.out.println(list.indexOf("44556699"));
        System.out.println(list.indexOf("asdf"));
        System.out.println(list.indexOf("123"));
        System.out.println(list.indexOf("1234"));
        System.out.println();
        System.out.println(list.lastIndexOf("44556699"));
        System.out.println(list.lastIndexOf("1234"));
        System.out.println(list.lastIndexOf("1234sssssssss"));
        System.out.println();
        System.out.println(list.set(0, "987654321"));
        System.out.println(list.set(5, "tratata"));
        System.out.println(list);
    }
}
class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;
    
    public MyLinkedList() {
    }
   
    public MyLinkedList(E[] objects) {
        super(objects);
    }
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); 
        newNode.next = head; 
        head = newNode; 
        size++; 
        if (tail == null) 
            tail = head;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); 
        if (tail == null) {
            head = tail = newNode; 
        } else {
            tail.next = newNode; 
            tail = tail.next; 
        }
        size++; // Increase size
    }
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;

            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); 
            } else {
                result.append("]"); 
            }
        }
        return result.toString();
    }
    public void clear() {
        size = 0;
        head = tail = null;
    }

    public boolean contains(E e) {
        if(size == 0) {
            return false;
        } else {
            Node<E> tmp = head;
            while(tmp != null) {
                if(tmp.element.equals(e)) {
                    return true;
                } else {
                    tmp = tmp.next;
                }
            }
        }
        return false;
    }
    public E get(int index) {
        checkIndex(index);
        Node<E> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.element;
    }
    public int indexOf(E e) {
        if(size == 0) {
            return -1;
        } else {
            Node<E> tmp = head;
            int result = 0;
            while(tmp != null) {
                if(tmp.element.equals(e)) {
                    return result;
                } else {
                    tmp = tmp.next;
                    result++;
                }
            }
        }
        return -1;
    }
    public int lastIndexOf(E e) {
        if(size == 0) {
            return -1;
        } else {
            Node<E> tmp = head;
            int result = 0;
            int tmpresult = -1;
            while(tmp != null) {
                if(tmp.element.equals(e)) {
                    tmpresult = result;
                }
                tmp = tmp.next;
                result++;
            }
            return tmpresult;
        }
    }
    public E set(int index, E e) {
        checkIndex(index);
        Node<E> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.element = e;
        return e;
    }
    public java.util.Iterator<E> iterator() {
        return new

                LinkedListIterator();
    }

    @Override
    public void forEach(Consumer action) {
        super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return super.spliterator();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    private class LinkedListIterator implements java.util.Iterator<E> {
        private Node<E> current = head; 
        @Override
        public boolean hasNext() {
            return (current != null);
        }
        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

    }
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }
}