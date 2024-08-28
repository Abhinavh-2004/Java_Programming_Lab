package Lab4;


import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class Linkedlist{
    Node head;
    public Linkedlist(){
        this.head = null;
    }

    public void insertAtBeginning(int x){
        if(head == null){
            Node newnode = new Node(x);
            head = newnode;
        }
        else{
            Node newnode = new Node(x);
            newnode.next = head;
            head = newnode;
        }
    }

    public void insertAtEnd(int x){
        if(head == null){
            Node newnode = new Node(x);
            head = newnode;
        }
        else{
            Node newnode = new Node(x);
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;

            }
            curr.next = newnode;
        }
    }
    public int length(Node head){
        int count = 0;
        Node temp;
        temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void insertAtPosition(int pos, int x){
        if(pos == 0){
            Node newnode = new Node(x);
            newnode.next = head;
            head = newnode;
        }
        else if(length(head) <= pos){
            System.out.println("Sorry, out of bounds");
            return;
        }
        else{
            Node temp;
            temp = head;
            int count = 1;
            while(count != pos -1){
                count++;
                temp = temp.next;
            }
            Node newnode = new Node(x);
            newnode.next = temp.next;
            temp.next = newnode;
        }
    }

    public void insertAfterNode(int value, int x){
        Node temp;
        temp = head;
        while(temp.data != value){
            if(temp.next == null){
                System.out.println("Sorry, not found");
                return;
            }
            temp = temp.next;
        }
        Node newnode = new Node(x);
        newnode.next = temp.next;
        temp.next = newnode;

    }

    public void insertBeforeNode(int value, int x){
        if(head == null){
            Node newnode = new Node(x);
            head = newnode;
        }
        else{
            Node temp;
            temp = head;
            while(temp.next.data != value){
                if(temp.next == null){
                    System.out.println("Failure, not found");
                    return;
                }

                temp = temp.next;
            }
            Node newnode = new Node(x);
            newnode.next = temp.next;
            temp.next = newnode;
        }
    }



    public void add(int x){

        Node current;
        if(head == null){
            Node root = new Node(x);
            head = root;


        }
        else {
            Node newnode = new Node(x);
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newnode;
            current = current.next;
        }
    }

    public void deleteFromBeginning(){
        if(head == null){
            System.out.println("Failure, no nodes found");
            return;
        }
        else{
            if(head.next != null){
                head = head.next;
            }
            else{
                head = null;
            }
        }
    }

    public void deleteFromEnd(){
        if(head == null){
            System.out.println("failure! invalid linked list");
            return;
        }

        if(length(head) == 1){
            head = null;
            return;
        }
        Node temp;
        temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteByValue(int deleteKey){
        if(head == null){
            System.out.println("Failure, empty ll");
            return;
        }
        else{
            Node temp;
            temp = head;
            if(temp.data == deleteKey){
                head = head.next;
                return;
            }
            while(temp.next.data != deleteKey){
                if(temp.next == null){
                    System.out.println("Failure, the key is not found");
                    return;
                }
                temp = temp.next;
            }
            if(temp.next.next == null){
                temp.next = null;
                return;
            }
            else{
                temp.next = temp.next.next;
            }
        }
    }

    public void deleteByPosition(int pos){
        if(head == null){
            System.out.println("Failure, no linked list");
            return;
        }
        if(pos == 1){
            if(head.next != null){
                head = head.next;
                return;
            }
            else{
                head = null;
                return;
            }
        }
        Node temp;
        temp = head;
        if(length(head) < pos){
            System.out.println("Failure, no such position");
            return;
        }
        int count = 1;
        while(count != pos -1){
            if(temp.next == null){
                System.out.println("Invalid");
                return;
            }
            temp = temp.next;
            count++;
        }
        if(temp.next.next == null){
            temp.next = null;
            return;
        }
        else{
            temp.next = temp.next.next;
        }

    }

    public void display(){
        Node curr = head;
        if(head == null){
            System.out.println("No nodes");
            return;
        }
        while(curr.next != null){
            System.out.printf("%d-",curr.data);
            curr = curr.next;
        }
        System.out.printf("%d",curr.data);
        System.out.printf("\n");


    }
    public void reverse2(Node curr, StringBuilder res){

        if(curr == null){
            return;
        }
        else{
            reverse2(curr.next,res);
            res.append(curr.data);
            res.append("-");
        }


    }

    public void search(int key){
        if(head == null){
            System.out.println("Failure, no linked list");
            return;
        }
        Node temp;
        temp = head;
        int index = 1;
        while(temp != null){
            if(temp.data == key){
                System.out.printf("%d found at %d\n",key,index);
                return;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("The key is not found");

    }

    public void access(int pos){
        if(head == null){
            System.out.println("No linked list!!");
            return;
        }
        if(pos > length(head)){
            System.out.println("invalid pos");
            return;
        }

        int counter = 1;
        Node temp;
        temp = head;
        while(counter < pos){
            if(temp.next != null) {
                temp = temp.next;
                counter++;
            }
            else{
                System.out.println("none found");
                return;
            }
        }
        System.out.println("The accessed value is " + temp.data);
    }

    public void countOccurrences(){
        if(head == null){
            System.out.println("No linked list");
            return;
        }
        if(length(head) == 1){
            System.out.printf("%d : %d", head.data,1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Node temp;
        temp = head;
        while(temp != null){
            if(!map.containsKey(temp.data)){
                map.put(temp.data,1);
            }
            else{
                map.put(temp.data, map.get(temp.data) + 1);
            }
            temp = temp.next;
        }

        Set<Integer> set = new HashSet<>();
        temp = head;
        while(temp != null){
            if(!set.contains(temp.data)){
                System.out.printf("%d : %d \n",temp.data, map.get(temp.data));
                set.add(temp.data);
            }
            temp = temp.next;
        }



    }

    public void reverse(){
        StringBuilder res = new StringBuilder();
        reverse2(head,res);
        res.deleteCharAt(res.length()-1);
        System.out.println(res);

    }

    public void heapSort(){
        if(head == null){
            System.out.println("No linked list");
            return;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Node temp;
        temp = head;
        while(temp != null){
            minHeap.add(temp.data);
            temp = temp.next;
        }
        List<Integer> array = new ArrayList<>();
        while(!minHeap.isEmpty()){
            array.add(minHeap.poll());
        }
        System.out.printf("The sorted linked list is\n");
        for(int i = 0; i < array.size() - 1; i++){
            System.out.printf("%d-",array.get(i));
        }
        System.out.printf("%d\n",array.get(array.size()-1));

    }

    public void removeDuplicate(){
        if(head == null){
            System.out.println("No linked list");
            return;
        }
        if(length(head) == 1){
            System.out.printf("%d",head.data);
            return;
        }

        Set<Integer> set = new HashSet<>();
        Node temp = head;
        while(temp != null){
            if(!set.contains(temp.data)) set.add(temp.data);
            temp = temp.next;
        }
        Object[] arr = set.toArray();
        for(int i = 0 ; i < arr.length -1 ; i++){
            System.out.printf("%d-",arr[i]);
        }
        System.out.printf("%d\n",arr[arr.length-1]);


    }

    public static Node concatenate(Node head1, Node head2, boolean decision){
        if(head1 != null && head2 == null){
            return head1;
        }
        if(head2 != null && head1 == null){
            return head2;
        }
        if(decision){
            Node temp = head1;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = head2;
            return head1;
        }
        else{
            Node temp = head2;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = head1;
            return head2;
        }
    }

    public static void displayHead(Node head){
        Node curr = head;
        if(head == null){
            System.out.println("No nodes");
            return;
        }
        while(curr.next != null){
            System.out.printf("%d-",curr.data);
            curr = curr.next;
        }
        System.out.printf("%d",curr.data);
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();

        list.insertAtBeginning(5);

        list.insertAtBeginning(4);
        list.insertAtEnd(10);
        list.insertAtEnd(1);
        list.insertAtPosition(2,2);
        list.insertAfterNode(10,9);
        list.insertBeforeNode(1,99);
        list.insertAtEnd(4);

        Linkedlist list2 = new Linkedlist();
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        Node res = concatenate(list.head,list2.head,false);
        displayHead(res);
        list.display();

    }


}
