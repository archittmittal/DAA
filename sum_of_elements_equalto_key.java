import java.util.*;
public class sum_of_elements_equalto_key {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i = 0 ; i<n;i++){
            arr[i] = sc.nextInt();
        }

        int key = sc.nextInt();

        Arrays.sort(arr);

        int s = 0;
        int e = arr.length-1;

        while(s<e){
            int sum = arr[s] + arr[e];
            if(sum == key){
                System.out.println("The numbers are" + arr[s] + " " + arr[e]);
                break;
            }
            else if(sum>key){
                e--;
            }
            else{
                s++;
            }
        }

    }
    
}
