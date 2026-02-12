public class DivideandConquer {

    public static void Printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void merge(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        merge(arr, si, mid);      // left part
        merge(arr, mid + 1, ei);  // right part

        mergefxn(arr, si, mid, ei);
    }

    public static void mergefxn(int arr[], int si, int mid, int ei) {

        int temp[] = new int[ei - si + 1];

        int i = si;       // left start
        int j = mid + 1;  // right start
        int k = 0;

        // Compare both halves
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Remaining left elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Remaining right elements
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy back to original array
        for (k = 0; k < temp.length; k++) {
            arr[si + k] = temp[k];
        }
    }

    public static void quickSort(int arr[],int si,int ei){
        if (si >= ei) {
            return;
        }

        int p_index = partition(arr,si,ei); // pivot ki value dega
        quickSort(arr,si,p_index-1); // left
        quickSort(arr,p_index+1,ei); // right
    }

    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i = si-1; // makes place for elemnts smaller than pivot
        for(int j =si ; j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
                int temp = pivot;
                arr[ei]=arr[i]; // main 
                arr[i]=temp;
                return i;


    }
// search in rotated sorted array
    public static int search(int arr[] , int tar , int si , int ei){
        int mid = si + (ei-si)/2;
        if(arr[mid]==tar){
            return mid;
        }

        // mid lies on l1
        if(arr[si]<=arr[mid]){
            //case 1 left:
            if(arr[si]<=tar && tar <=arr[mid]){
                return search(arr, tar, si, mid-1);
            }
            else{
                //case2 right
                return search(arr,tar,mid+1,ei);
            }


        }

        //lie om l 2
        else{
            //case 3 right of l2
            if(arr[mid]<=tar && tar<=arr[ei]){
                return search(arr, tar, mid+1, ei);

            }
            else{
                return search(arr, tar, si, mid-1);

            }

        }





    }

    public static void main(String[] args) {
        int arr[] = {3, 6, 9, 2, 7, 5};
        merge(arr, 0, arr.length - 1);
        Printarr(arr);
        quickSort(arr, 0, arr.length-1);
        Printarr(arr);

        int arr1 [] = {4,5,6,7,0,1,2,3};
        int target = 0;
        int tindx = search(arr1,target,0,arr1.length-1);
        System.out.println("The index is " + tindx);


    }
}