//select criteria , works on indexes of elemennt assceding by minimum element on indexed basis instead numbers;
#include<iostream>
using namespace std;

void selectionSort(int arr[],int n){
    for(int i=0;i<n-1;i++){
        int min=i;
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[min]){
                min=j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
void displayArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main(){
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    int arr[n];
    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    selectionSort(arr , n);
    cout << "Sorted array: ";
    displayArray(arr, n);
    return 0;
}

// implace algo
// not stable algo

/*worst average  n^2;
best (sorted) n^2
sc o(1);*/

//bubble sor hw 17/1/26

// leetcode 1 35 66 121 14