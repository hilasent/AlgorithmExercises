package dataStructure;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HospitalQuestion {
    public static int partition(int arr[], int left, int right) {
        if (left > right) {
            return left;
        }
        int start = left, end = right;
        int tmp;
        int mid = (left + right) / 2;
        int pivot = arr[(left + right) / 2];

        arr[mid] = arr[end];
        arr[end] = pivot;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr,start,i);
                start++;
            }
        }

       swap(arr,start,end);

        return start;
    }
    public static int quickSort(int[] arr, int low, int high) {
        int index;
        int pivot = arr[(low + high) / 2];
        index = partition(arr, low, high);

        if (low <= high) {
                if (index == pivot) {
                    return  quickSort(arr, index + 1, high);
                } else {
                    return  quickSort(arr, low, index - 1);
                }
        }
        return index;
    }
    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void printArr(int a[]) {
        int i;
        int n = a.length;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

    private static int[] getMultiArray(int num) {
        int[] multiArray = new int[num];
        for (int i = 0; i < multiArray.length; i++) {
            multiArray[i] = i;
        }
        return multiArray;
    }



    static int[] getMultiArraySize(){
       int[] getMultiArraySize = new int[]{10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
        return getMultiArraySize;
    }

    public static int removeAnElementFromArray(int[] arr, int index){
        for (int i = index; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        return index;
    }

    static void shuffleArray(int[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    private static void FindMissingElementAndMeasuredTime(int[] tempArray) {
        long startTime = System.nanoTime();
        quickSort(tempArray,0, tempArray.length-1);
        long endTime = System.nanoTime();
        long measuredTime = (endTime - startTime);
        System.out.println("---> " + measuredTime);
    }

    public static void main(String[] args) {
        System.out.println("For first question:\n");
        int intArray[] = {0,7,10,9,5,4,11,1,6,8,2};
        System.out.println("Array which is in first question: ");
        printArr(intArray);
        System.out.println("For first question first missing element is: " + quickSort(intArray,0, intArray.length-1));
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("\nFor second question:\n");
        int[] multiArraySize = getMultiArraySize();
        int[] tempArray;
        for (int i = 0; i < multiArraySize.length - 1; i++) {
            tempArray = getMultiArray(multiArraySize[i]);
            System.out.println("Calculation for the  " + multiArraySize[i] + " size of array: ");
            System.out.println("The element which is removed from our array: " + removeAnElementFromArray(tempArray, 5));
            shuffleArray(tempArray);
            System.out.println("After removing lets find our first missing element: : " + quickSort(tempArray, 0, tempArray.length - 1));
            FindMissingElementAndMeasuredTime(tempArray);
            System.out.println(".......................................................\n\n");
        }

    }}






