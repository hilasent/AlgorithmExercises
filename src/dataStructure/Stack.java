package dataStructure;

public class Stack<T> {
    private int length;
    private ListNode top;

    public Stack(){
        length = 0;
        top = null;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        this.length++;
    }

    public int pop(){
        int result = top.data;
        top = top.next;
        this.length--;
        return result;
    }

    public int peek(){
        return top.data;
    }


    public void displayStack(){
        for( int i =0 ; i < this.length; i++){

        }

    }
}
