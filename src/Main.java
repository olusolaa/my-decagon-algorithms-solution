import java.util.*;

public class Main {


    public static void main(String[] args) {

        LinkList list = new LinkList();
       // list.addFirst(20);
       // list.addLast(30);
        //list.addLast(40);
       // list.addLast(50);
        //list.removeLast();
       // list.removeFirst();
        System.out.println(list.contains(20));
        System.out.println(list.size());

//        list.reverse();
        int [] arr = list.toArray();
        System.out.println(Arrays.toString(arr));
  //      System.out.println(list.kthPointer(0));
        list.printMiddle();

    }
}
