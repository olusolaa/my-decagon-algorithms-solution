import java.util.NoSuchElementException;

public class LinkList {

    Node first;
    Node last;
    int size;

    private boolean isEmpty(){
        return this.first == null;
    }

    private class Node {
        private Node next;
        private int value;

        Node(int item) {
            this.value = item;
        }
    }
    public void addLast(int value){
        Node node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last =node;
        }
        size++;
    }
    public void addFirst(int value){
        Node node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            node.next=first;
            first = node;
        }
        size++;
    }

    public int indexOf(int value){
        var count = 0;
        var current = first;
        while (current != null){
            if (current.value == value)
                return count;
            current = current.next;
            count ++;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        var second = first.next;
        first.next = null;
        first = second;
        size --;
    }

//    public void removeLast(){
//        var current = first;
//        while (current != null){
//            if (current.next == last) break;
//            current = current.next;
//
//        }
//        last = current;
//        last.next = null;
//    }

    public void removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();

        var current = first;
        if (first == last)
            first = last = null;
        else{
            while (current.next.next!= null) {
                current = current.next;
            }
            current.next = null;
            last = current;
        }
        size--;
    }

    public int size(){
        return size;
    }

    public int [] toArray(){
        int [] arr = new int[size];
        var current = first;
        var count = 0;
        while (current !=null){
            arr[count] = current.value;
            count++;
            current = current.next;
        }
        return arr;
    }

    public void reverse(){
        var prev = first;
        var current = first.next;

        while (current != null){
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        last = first;
        last.next=null;

    }

    public int kthPointer(int k) {
        if (isEmpty())
            throw new NoSuchElementException();
        var a = first;
        var b = first;
        for(int i =0; i< k-1; i++){
            b =b.next;
        }
        while (b !=last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle(){
        if (isEmpty())
            throw new IllegalStateException();
        var a = first;
        var b = first;
        while (b != last && b.next != last){
            b = b.next.next;
            a = a.next;
        }
        if (b == last)
            System.out.println( a.value);
        else System.out.println(a.value+ " " + a.next.value);
    }
}

