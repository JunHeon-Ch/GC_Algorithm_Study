//
//  main.cpp
//  10972
//
//  Created by 이원창 on 2021/01/19.
//

#include <iostream>
#include <algorithm>
using namespace std;
bool visit[10000];
int arr[10000];
int main(int argc, const char * argv[]) {
    int n = 0;
    int idx = 0;
    int idx2 = 0;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    for(int i = n - 1; i > 0; i--){
        if(arr[i] > arr[i - 1]){
            idx = i - 1;
            break;
        }
    }
    
    int tmp = n + 1;
    for(int i = idx + 1; i < n; i++){
        if(tmp > arr[i] && arr[idx] < arr[i]){
            tmp = arr[i];
            idx2 = i;
        }
    }
    
    swap(arr[idx], arr[idx2]);
    sort(arr + idx + 1, arr + n);
    if(idx2 != 0){
        for(int i = 0; i < n; i++){
            cout << arr[i] << ' ';
        }
        cout << '\n';
        return 0;
    }
    else
        cout << "-1\n";
    
    return 0;
}
