#include<iostream>
using namespace std;
int search(int arr[], int n, int key, int &comparisons)
{
    int left=0;
    int right=n-1;
    comparisons=1;
    while(left<=right)
    {
        int mid=left +(right-left)/2;
        comparisons++;
        if(arr[mid]==key)
            return mid;
        else if(arr[mid]<key)
            left=mid+1;
        else
            right=mid-1;
    }
    return -1;
}
int main()
{
    int n,key;
    int comparisons;
    cout<<"Enter size of array: ";
    cin>>n;
    int arr[n];
    cout<<"Enter elements:";
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    cout<<"Enter key:";
    cin>>key;
    int result=search(arr,n,key,comparisons);
    if(result!=-1)
        cout<<"Key found at index "<<result+1<<endl;
    else
        cout<<"Key not found"<<endl;
    cout<<"Total comparisons:"<<comparisons<<endl;
    return 0;
}