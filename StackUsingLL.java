package Lab4;

public class StackUsingLL extends Linkedlist{

    public void push(int x){
        insertAtBeginning(x);
    }

    public void pop(){
        System.out.printf("Popped number is %d\n",head.data);
        deleteFromBeginning();
    }

    public void peek(){
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        StackUsingLL st = new StackUsingLL();
        st.push(4);
        st.push(3);
        st.push(1);
        st.display();
        st.pop();
        st.display();
    }
}
