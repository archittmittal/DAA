#include <iostream>
using namespace std;
int main()
{
    int n;
    cout<<"Enter number of elements: ";
    cin>> n;
    int arr[n];
    cout << "Enter sorted elements:";
    for (int i = 0; i< n; i++)
        cin >> arr[i];
    bool found= false;
    for (int k= n - 1; k>= 2;k--)
    {
        int i= 0,j=k - 1;
        while(i< j)
        {
            int sum = arr[i] + arr[j];
            if (sum == arr[k])
            {
                cout << "Indices found:\n";
                cout << "i = " << i << ", j = " << j << ", k = " << k << endl;
                cout << "Values:" << arr[i] << " + " << arr[j]
                << " = " << arr[k] << endl;
                found = true;
                break;
            }
            else if (sum < arr[k])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        if (found)
            break;
    }
    if (!found)
        cout << "Indices not found\n";
    return 0;
}