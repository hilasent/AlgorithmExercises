package dataStructure;

import java.util.NoSuchElementException;

public class Queue {
    public ListNode rear;
    public ListNode front;
    public int length;


    public int getRear(){
        return this.rear.data;

    }

    public int getLength(){
        return this.length;

    }

    public int getFront(){
        return this.front.data;

    }

    public boolean isEmpty(){
        return this.length == 0;
    }

    public void enqueueData(int data){
        ListNode temp = new ListNode(data);
        if(this.isEmpty()){
            front = temp;
        } else {
            rear.next = temp;
        }
        this.rear = temp;
        length++;
    }

    public int dequeque(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }

}
