
package dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Completee {
    static class Node {
        int val;
        Node left;
        Node right;
        int index;

        public Node() {
        }

        public Node(int val, Node left, Node right, int index) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node{" +

                    "val=" + val + ", left=" + left + ", right=" + right + ", index=" + index + '}';
        }
    }


    static Node built_tree(int[] WN) {
        return buildTreeHelper(WN, 0);
    }

    static Node buildTreeHelper(int[] values, int i) {
        if (i >= values.length) {
            return null;
        }
        Node node = new Node(values[i], buildTreeHelper(values, 2 * i + 1), buildTreeHelper(values, 2 * i + 2), i);
        return node;
    }



    public static int recursive(Completee.Node root, int sum, int[][] edge) {
        if (root.left == null || root.right==null) {
            return sum;
        }

//        System.out.println("Root: "+ root.toString()+"\n Left: "+ root.left.toString() + "\n Right: "+ root.right.toString() + " \nindex : "+ root.index);
        int leftPart = recursive(root.left, sum + edge[root.index][root.left.index] + root.left.val, edge);
        int rightPart = recursive(root.right, sum + edge[root.index][root.right.index] + root.right.val, edge);
        return Math.min(leftPart, rightPart);

    }

    public static int greedy(Node root, int[][] WE) {
        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(root.index);
        int totalWeight = root.val;
        while (root.left != null || root.right !=null)  {

            int rigthSum = root.right.val + WE[root.index][root.right.index];
            int leftSum = root.left.val + WE[root.index][root.left.index];

            if (leftSum < rigthSum) {
                totalWeight += leftSum;
                shortestPath.add(root.left.index);
                root = root.left;

            } else {
                totalWeight += rigthSum;
                shortestPath.add(root.right.index);
                root = root.right;
            }
        }
        System.out.println("Min total weight path includes nodes " + shortestPath);

        return totalWeight;
    }

    static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);

    }

    public static int dynamic(int n, int[] WN, int[][] WE) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            if (2 * i + 1 >= n && 2 * i + 2 >= n) {  // i is a leaf
                dp[i][0] = dp[i][1] = WN[i];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int j = 2 * i + 1;
            if (j < n) {
                dp[i][0] = Math.min(dp[i][0], dp[j][0] + WE[i][j] + WN[i]);
                dp[i][1] = Math.min(dp[i][1], dp[j][1] + WE[i][j] + WN[i]);
            }

            int k = 2 * i + 2;
            if (k < n) {
                dp[i][1] = Math.min(dp[i][1], dp[k][0] + WE[i][k] + WN[i]);
                dp[i][0] = Math.min(dp[i][0], dp[k][1] + WE[i][k] + WN[i]);
            }
        }

        int minTotalWeight = Math.min(dp[0][0], dp[0][1]);
        return minTotalWeight;
    }

    private static int[][] createWE(int n, int[][] WE) {
        Random random = new Random();
        for (int i = 0; 2 * i + 2 < n; i++) {
            WE[i][2 * i + 1] = random.nextInt(1, 10);
            WE[i][2 * i + 2] = random.nextInt(1, 10);
        }
        return WE;
    }

    private static int[] generate_complete_binary_tree(int size, int[] WN) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            WN[i] = random.nextInt(20) + 1;
        }
        return WN;
    }

    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    public static void printLongArray(long[][] array) {
        for (long[] row : array) {
            for (long col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
//        int[] WN = {3, 4, 2, 6, 1, 9, 8, 8, 5};

//        int[][] WE = {
//                {0, 1, 5, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 6, 2, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 9, 3, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 6, 4},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        };
        long[][] results = new long[2][3];



        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the size of array to construct a complete binary tree ");
        int n = scan.nextInt();
        int[] WN = new int[n];
        generate_complete_binary_tree(n, WN);
        printArray(WN);
        int[][] WE = new int[n][n];
        createWE(n, WE);
        print2DArray(WE);


        Node root = built_tree(WN);
//      printTree(root);
        System.out.println("GREEDY");
        long startTime = System.nanoTime();
        System.out.println("Min total weight: " + greedy(root, WE));
        long endTime = System.nanoTime();
        long measuredTime = (endTime - startTime);
        System.out.println("---> " + measuredTime + "\n----------------------------------------------");

        System.out.println("RECURSIVE");
        long startTime2 = System.nanoTime();
        System.out.println("Min total weight: " + recursive(root, root.val, WE));
        long endTime2 = System.nanoTime();
        long measuredTime2 = (endTime2 - startTime2);
        System.out.println("---> " + measuredTime2 + "\n----------------------------------------------");

        System.out.println("DYNAMIC");
        long startTime3 = System.nanoTime();
        System.out.println("Min total weight: " + dynamic(WN.length, WN, WE));
        long endTime3 = System.nanoTime();
        long measuredTime3 = (endTime3 - startTime3);
        System.out.println("---> " + measuredTime3 + "\n----------------------------------------------");

        for (int j = 0; j < 3; j++) {
            int i = 0;
            Random random = new Random();
            int size = random.nextInt(20);
            int[] WN2 = new int[size];
            generate_complete_binary_tree(size, WN2);
            printArray(WN2);
            int[][] WE2 = new int[size][size];
            createWE(size, WE2);
            print2DArray(WE2);
            Node root2 = built_tree(WN2);

            System.out.println("RECURSIVE");
            long startTime0 = System.nanoTime();
            recursive(root2, root2.val,WE2);
            System.out.println("Min total weight: " + recursive(root2, root2.val,WE2));
            long endTime0 = System.nanoTime();
            long measuredTime0 = (endTime0 - startTime0);
            results[i][j] = measuredTime0;
            System.out.println("---> " + measuredTime0 + "\n----------------------------------------------");

            System.out.println("DYNAMIC");
            long startTime5 = System.nanoTime();
            dynamic(WN2.length, WN2, WE2);
            System.out.println("Min total weight: " + dynamic(WN2.length, WN2, WE2));
            long endTime5 = System.nanoTime();
            long measuredTime5 = (endTime5 - startTime5);
            results[i + 1][j] = measuredTime5;
            System.out.println("---> " + measuredTime5 + "\n----------------------------------------------");
        }
        System.out.println("RESULT: ");
        printLongArray(results);
    }
}
