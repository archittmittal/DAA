import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first array
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input second array
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        // Two pointer approach
        int i = 0, j = 0;
        List<Integer> common = new ArrayList<>();

        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) {
                common.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Output result
        if (common.isEmpty()) {
            System.out.println("No common elements");
        } else {
            for (int x : common) {
                System.out.print(x + " ");
            }
        }
    }
}
