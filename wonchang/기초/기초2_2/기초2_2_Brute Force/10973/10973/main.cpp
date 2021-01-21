//
//  main.cpp
//  10973
//
//  Created by 이원창 on 2021/01/19.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int idx = 0;
    int idx2 = 0;
    int arr[10000];
    
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    for(int i = n - 1; i > 0; i--){
        if(arr[i] < arr[i - 1]){
            idx = i - 1;
            break;
        }
    }
    
    int tmp = arr[idx];
    for(int i = idx + 1; i < n; i++){
        if(arr[idx] > arr[i]){
            tmp = min(tmp, arr[i]);
            idx2 = i;
        }
    }
    
    swap(arr[idx], arr[idx2]);
    sort(arr + idx + 1, arr + n, greater<int>());
    if(idx2 != 0){
        for(int i = 0; i < n; i++){
            cout << arr[i] << ' ';
        }
        cout << '\n';
    }
    else
        cout << "-1\n";
    return 0;
}
