#include <iostream>
#include <cmath>
using namespace std;
int jumpsearch(int arr[], int n, int key)
{
    int step = sqrt(n);
    int prev = 0;
    while (prev< n && arr[min(step, n) - 1] < key)
    {
        prev = step;
        step += sqrt(n);
        if (prev >= n)
            return -1;
    }
    for (int i= prev;i<min(step,n);i++)
    {
        if (arr[i]==key)
            return i;
    }
    return -1;
}
int exponentialsearch(int arr[], int n, int key)
{
    if (arr[0]==key)
        return 0;
    int i= 1;
    while (i< n && arr[i] < key)
        i = i * 2;
    for (int j= i / 2; j< n && j<= i;j++)
    {
        if (arr[j] == key)
            return j;
    }
    return -1;
}
int main()
{
    int n,key;
    cout<< "Enter number of elements: ";
    cin>> n;
    int arr[n];
    cout<< "Enter sorted elements:";
    for (int i = 0; i < n; i++)
        cin>> arr[i];
    cout<< "Enter key:";
    cin>> key;
    int result1= jumpsearch(arr, n, key);
    int result2 = exponentialsearch(arr, n, key);
    cout<< "\nJump Search:\n";
    if (result1 != -1)
        cout<< "Key found at index: "<<result1<<endl;
    else
        cout<< "Key not found\n";
    cout<<"\nExponential Search:\n";
    if (result2 != -1)
        cout<< "Key found at index: " <<result2<<endl;
    else
        cout<< "Key not found\n";
    return 0;
}