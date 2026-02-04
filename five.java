import java.util.*;
public class five {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of characters : ");
        int n = sc.nextInt();
        char[] arr = new char[n];


     System.out.print("Enter the characters in lower case in any order : ");
        for(int i =0 ; i<n ; i++){
            arr[i] = sc.next().charAt(0);
        }
        
        int[] count = new int[26]; 
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                count[arr[i] - 'a']++;
            }
        }
        
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
            }
        }
        
        if (maxFreq > 0) {
            System.out.println("Occurrence count: " + maxFreq);
            System.out.print("Alphabet(s) with maximum occurrence: ");
            for (int i = 0; i < 26; i++) {
                if (count[i] == maxFreq) {
                    System.out.print((char) (i + 'a') + " ");
                }
            }
            System.out.println();
        } else {
             System.out.println("No valid alphabets entered.");
        }
    }
    
    
}
