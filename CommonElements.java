import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter the number of inputs in array");
        int m = sc.nextInt();
        System.out.println("Enter the first array");
        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the number of inputs in array");
        int n = sc.nextInt();
        System.out.println("Enter the second array");
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

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

        if (common.isEmpty()) {
            System.out.println("No common elements");
        } else {
            for (int x : common) {
                System.out.print(x + " ");
            }
        }
    }
}
