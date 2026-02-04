#include <iostream>
using namespace std;
int main()
{
    int n, key;
    int comparison=0;
    int found=0;
    cout<<"Enter size of array:";
    cin>>n;
    int arr[n];
    cout<<"Enter elements:";
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    cout<<"Enter key:";
    cin>>key;
    for(int i=0;i<n;i++)
    {
        comparison++;
        if(arr[i]==key)
        {
            cout<<"Key found at index: "<<i+1<<endl;
            found=1;
            break;
        }
    }
    if(found==0)
        cout<<"Key not found";
    cout<<"Total comparisons: "<<comparison<<endl;
}