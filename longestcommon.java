import java.util.Scanner;

// longest common subsequent string
public class longestcommon {

    // Function to find the length of the Longest Common Subsequence
    public static int findLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Create a 2D array to store results of subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp table in a bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, add 1 to the result of the remaining strings
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } 
                // If characters don't match, take the max of excluding current character from either string
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The bottom-right cell contains the length of the LCS for the full strings
        return dp[m][n];
    }

    public static void main(String args[]){
        // Scanner is now successfully imported!
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        
        System.out.print("Enter second string: ");
        String str2 = sc.next();
        
        int result = findLCS(str1, str2);
        
        System.out.println("Length of Longest Common Subsequence: " + result);
        
        sc.close();
    }
}