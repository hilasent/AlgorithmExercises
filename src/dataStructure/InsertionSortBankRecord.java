package dataStructure;

import java.util.Random;

public class InsertionSortBankRecord {
    public static class Insert {
        static void insert(int a[]) {
            int i, j, number;
            int n = a.length;
            for (i = 1; i < n; i++) {
                number = a[i];
                j = i - 1;

                while (j >= 0 && number <= a[j]) {
                    a[j + 1] = a[j];
                    j = j - 1;
                }
                a[j + 1] = number;
            }
        }

        static void printArr(int a[]) {
            int i;
            int n = a.length;
            for (i = 0; i < n; i++)
                System.out.print(a[i] + " ");
        }

        static int[] generateArrayForNumberToShıfted(int key) {
            int[] nums = new int [17];
            nums[0]= 1;
            nums[16] = ((int) Math.pow(2,16)) -1;
            for(int i=1;  i< 16; i++){
                nums[i] = i* (key / 16);
            }
            return nums;
        }


        private static int[] shiftArr(int[] arrayToBeShifted, int numberToBeShifted) {
                for (int i = 0; i < numberToBeShifted; i++) {
                    int j, last;
                    last = arrayToBeShifted[arrayToBeShifted.length-1];
                    for(j = arrayToBeShifted.length-1; j > 0; j--){
                        arrayToBeShifted[j] = arrayToBeShifted[j-1];
                    }
                    arrayToBeShifted[0] = last;
                    }
               return arrayToBeShifted;
        }

        static int getIntegerFromPow(int m, int n){
            int num = (int) Math.pow(m, n);
            return num;
        }

        private static int[] getRandomArray(int num) {
            Random rand = new Random();
            int[] randArray = new int[num];
            for (int i = 0; i < randArray.length; i++) {
                randArray[i] = rand.nextInt();
            }
            return randArray;
        }

        private static long measureAndInsert(int[] intArray) {
            long measuredTıme = 0;
            for (int i = 0; i < intArray.length; i++) {
                long startTime = System.nanoTime();
                insert(intArray);
                long endTime = System.nanoTime();
                measuredTıme = (endTime - startTime);
            }
            return measuredTıme;
        }

        public static void main(String[] args) {
            Insert i1 = new Insert();
            int num = getIntegerFromPow(2,16);
            int[] intArray = getRandomArray(num);
            insert(intArray);

            System.out.println("\n\nOriginal array - ");
            int[] numbersToBeShifted = generateArrayForNumberToShıfted(num);
            System.out.println("\nGenerated numbers for shifting array:  ");
            printArr(numbersToBeShifted);
            int[] timeToMeasured = new int[numbersToBeShifted.length];

            for(int i = 0; i < numbersToBeShifted.length; i++){
                System.out.println("\n" + numbersToBeShifted[i] + " times will be shifted: ");
                shiftArr(intArray, numbersToBeShifted[i]);
                System.out.println("\nShifted array :  " );
                timeToMeasured[i] = (int) measureAndInsert(intArray);
                System.out.println("\nMeasured time for " + numbersToBeShifted[i]);
                printArr(timeToMeasured);
            }
        }




    }
}
