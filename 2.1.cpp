#include <iostream>
using namespace std;
int first(int arr[], int n, int key)
{
    int low= 0, high = n - 1;
    int result = -1;
    while (low <= high)
    {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) 
        {
            result = mid;
            high = mid - 1;
        }
        else if (arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return result;
}
int last(int arr[], int n, int key)
{
    int low = 0, high = n - 1, result = -1;
    while (low <= high) 
    {
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) 
        {
            result = mid;
            low = mid + 1;
        } 
        else if (arr[mid] < key) 
        {
            low = mid + 1;
        } 
        else 
        {
            high = mid - 1;
        }
    }
    return result;
}
int main()
{
    int n, key;
    cout<< "Enter number of elements: ";
    cin>> n;
    int arr[n];
    cout<< "Enter sorted array elements:\n";
    for (int i= 0;i<n;i++)
        cin>>arr[i];
    cout<<"Enter key: ";
    cin>>key;
    int result1= first(arr, n, key);
    if (result1==-1) 
    {
        cout<< "Key not found\n";
    }
    else
    {
        int result2= last(arr, n, key);
        cout<< "Key present\n";
        cout<< "Number of copies: " <<(result2 - result1 +1)<< endl;
    }
    return 0;
}