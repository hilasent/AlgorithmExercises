package dataStructure;

import java.util.*;
class QuickSort {

    int partition(int intArray[], int lowerBound, int upperBound) {
        int pivot = intArray[lowerBound];
        int start = lowerBound;
        int end = upperBound;

        while(start < end){

            if (intArray[end] < pivot){
                intArray[lowerBound] = intArray[end];
                intArray[end] = pivot;
                lowerBound = end;

                while(start < end){
                    if(intArray[start] > pivot){
                        int temp= intArray[start];
                        intArray[start] = pivot;
                        intArray[end] = temp;
                        lowerBound = start;
                        break;
                    }
                    start++;
                }
            }
            end--;
        }
        return lowerBound;
    }
    void quick_sort(int intArray[], int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int pi = partition(intArray, lowerBound, upperBound);
            quick_sort(intArray, lowerBound, pi);
            quick_sort(intArray, pi+1, upperBound);
        }
    }


}


class Main{
    public static void main(String args[]) {
//        int intArray[] = {3,0,1,8,7,2,5,4,9,6};
//        int n = intArray.length-1;
//        QuickSort obj = new QuickSort();
//        obj.quick_sort(intArray, 0, n);

        int[] multiArraySize = getMultiArraySize();
        int[] tempArray;
        for (int i = 0; i < multiArraySize.length; i++) {
            tempArray = getRandomArray(multiArraySize[i]);
            QuickSort measurementObject = new QuickSort();
            long startTime = System.nanoTime();
            measurementObject.quick_sort(tempArray, 0, tempArray.length-1);
            long endTime = System.nanoTime();
            System.out.println("Elapsed Time for " + multiArraySize[i] + " size array in nano seconds: "+ (endTime-startTime));
            System.out.println("----------------------------------------------------------");
        }




    }

    private static int[] getRandomArray(int num) {
        Random rand = new Random();
        int[] intArray = new int[100];
        for (int i = 0; i <intArray.length ; i++) {
            intArray[i] = rand.nextInt(num);
        }
        return intArray;
    }
    static int[] getMultiArraySize(){
        int[] getMultiArraySize = new int[]{10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
        return getMultiArraySize;
    }

    private static int[] getMultiArray(int num) {
        int[] multiArray = new int[num];
        for (int i = 0; i < multiArray.length; i++) {
            multiArray[i] = i;
        }
        return multiArray;
    }
}