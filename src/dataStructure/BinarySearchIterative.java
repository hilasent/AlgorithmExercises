package dataStructure;

import java.util.Arrays;

public class BinarySearchIterative {
    public static int BinarySearch(int[] arr, int key){
        int start = 0;
        int end = arr.length-1;
        int low = arr[start];
        int high = arr[end];
        int mid = ((start+end)/2);

        while (start <= end) {
            if(key == arr[mid]){
                System.out.println("Element is found at index: " + mid);
                break;
            }

            else if(key > arr[mid]){
                start = mid+1;
                mid= (start+end) /2;
            }
            else {
                end = mid-1;
                mid= (start+end) /2;
            }
            return mid;
        }
        System.out.println("Element is not found!");
        return 0;
    }

    static void printArr(int[]a){
        for(int i =0; i < a.length; i++){
            System.out.print(a[i] + ", " );
        }

    }


    public static void main(String[] args){
        int myArr[] = {3,6,8,12,14,17,25,29,31,36,42,47,53,55,62};
        printArr(myArr);
        System.out.println("Binary Search Iterative for key: " + BinarySearch(myArr, 42));
    }
}
