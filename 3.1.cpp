#include <iostream>
using namespace std;

int shifts = 0, comparisons = 0;

void insertionSort(int arr[], int n) {
    shifts = 0;
    comparisons = 0;
    
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
    

        while (j >= 0 && arr[j] > key) { //short circurit property
            comparisons++; // comparison: arr[j] > key
            arr[j + 1] = arr[j]; // shifting me copy chnage hoti h and count b
            shifts++; // count shift
            j--;// no of shofts count inside while
        }
        if (j >= 0) comparisons++; // final comparison when j < 0
        arr[j + 1] = key;
        shifts++; // final insertion shift
    }
}

void displayArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    int arr[n];

    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    insertionSort(arr, n);

    cout << "Sorted array: ";
    displayArray(arr, n);
    
    cout << "\nTotal Comparisons: " << comparisons << endl;
    cout << "Total Shifts: " << shifts << endl;

    return 0;
}
/* no new space in memory  array wali not constant (inplace algo) so insertion algo is inplace algo*/
/* STable algorithm : duplicate no me, jo first pe tha voi rhega background me aur baad wala same no baad me*/

// O(n^2) // worst case , average
// O(n) // best
// space complexity of inplace algo is O(1);



