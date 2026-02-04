#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


void findKthElementByCountingSort(vector<int>& arr, int k) {
    int n = arr.size();
    if (k < 1 || k > n) {
        cout << "Invalid k\n";
        return;
    }
    
    int minVal = *min_element(arr.begin(), arr.end());
    int maxVal = *max_element(arr.begin(), arr.end());
    
    int range = maxVal - minVal + 1;
    
    vector<int> count(range, 0);
    
    for (int num : arr) {
        count[num - minVal]++;
    }
    
    int counter = 0;
    int kthSmallest = -1;
    for (int i = 0; i < range; i++) {
        counter += count[i];
        if (counter >= k) {
            kthSmallest = i + minVal;
            break;
        }
    }
    
    counter = 0;
    int kthLargest = -1;
    for (int i = range - 1; i >= 0; i--) {
        counter += count[i];
        if (counter >= k) {
            kthLargest = i + minVal;
            break;
        }
    }
    
    cout << "Kth smallest (Counting Sort): " << kthSmallest << endl;
    cout << "Kth largest (Counting Sort): " << kthLargest << endl;
}


int main() {
    vector<int> arr = {12, 3, 5, 7, 19, 26, 1, 8, 15, 4};
    int k = 2;
    
    cout << "Array: ";
    for (int x : arr) cout << x << " ";
    cout << "\nFinding " << k << "th smallest and largest elements\n\n";
    findKthElementByCountingSort(arr, k);
    
    return 0;
}
