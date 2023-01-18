package dataStructure;

public class ShortestPathWithDynamic {
    public static void main(String[] args) {
        // Test data
        int n = 9;
        int[] WN = {3, 4, 2, 6, 1, 9, 8, 8, 5};
        int[][] WE = {
                {0, 1, 5, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 9, 3, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        // Call the minTotalWeight function
        int result = minTotalWeight(n, WN, WE);

        // Print the result
        System.out.println(result);  // Output: 22
    }
    public static int minTotalWeight(int n, int[] WN, int[][] WE) {
        // Initialize a 2D array dp of size n x 2 to store the minimum total weight for each node
        int[][] minTotalWeightEachNode = new int[n][2];
        for (int i = 0; i < n; i++) {
            minTotalWeightEachNode[i][0] = minTotalWeightEachNode[i][1] = Integer.MAX_VALUE;
        }

        // Initialize the minimum total weight for the leaves to the weight of the leaves themselves
        for (int i = 0; i < n; i++) {
            if (2 * i + 1 >= n && 2 * i + 2 >= n) {  // i is a leaf
                minTotalWeightEachNode[i][0] = minTotalWeightEachNode[i][1] = WN[i];
            }
        }

        // Calculate the minimum total weight for each node in the tree, starting from the leaves and working
        // our way up to the root
        for (int i = n - 1; i >= 0; i--) {
            // If i has a left child j, update dp[i][0] and dp[i][1]
            int j = 2 * i + 1;
            if (j < n) {
                minTotalWeightEachNode[i][0] = Math.min(minTotalWeightEachNode[i][0], minTotalWeightEachNode[j][0] + WE[i][j] + WN[i]);
                minTotalWeightEachNode[i][1] = Math.min(minTotalWeightEachNode[i][1], minTotalWeightEachNode[j][1] + WE[i][j] + WN[i]);
            }

            // If i has a right child k, update dp[i][0] and dp[i][1]
            int k = 2 * i + 2;
            if (k < n) {
                minTotalWeightEachNode[i][1] = Math.min(minTotalWeightEachNode[i][1], minTotalWeightEachNode[k][0] + WE[i][k] + WN[i]);
                minTotalWeightEachNode[i][0] = Math.min(minTotalWeightEachNode[i][0], minTotalWeightEachNode[k][1] + WE[i][k] + WN[i]);
            }
        }

        // Return the minimum of dp[0][0] and dp[0][1], which correspond to the minimum total weight
        // considering the left and right children of the root, respectively
        return Math.min(minTotalWeightEachNode[0][0], minTotalWeightEachNode[0][1]);

    }
}

