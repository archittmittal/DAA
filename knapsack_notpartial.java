import java.util.Scanner;
import java.util.ArrayList;

public class knapsack_notpartial {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items (n): ");
        int n = sc.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter weights for " + n + " items:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println("Enter values for " + n + " items:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        System.out.print("Enter knapsack capacity (W): ");
        int W = sc.nextInt();

        // DP table
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int maxValue = dp[n][W];

        ArrayList<Integer> selectedItems = new ArrayList<>();
        int res = maxValue;
        int w = W;
        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                selectedItems.add(i);
                res = res - values[i - 1];
                w = w - weights[i - 1];
            }
        }

        System.out.println("\nSelected Items (Indices): " + selectedItems);
        System.out.println("Maximum Value: " + maxValue);

        System.out.println("\nDetails of selected items:");
        int totalWeight = 0;
        for (int index : selectedItems) {
            System.out.println("Item " + index + " - Weight: " + weights[index - 1] + ", Value: " + values[index - 1]);
            totalWeight += weights[index - 1];
        }
        System.out.println("Total Weight: " + totalWeight);

        sc.close();
    }
}
