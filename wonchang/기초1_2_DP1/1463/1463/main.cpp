//
//  main.cpp
//  1463
//
//  Created by 이원창 on 2021/01/03.
//

#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int arr[1000001];
    
    cin >> n;
    for(int i = 2; i <= n; i++){
        if(i % 3 == 0 && i % 2 == 0){
            int tmp = min(arr[i / 3], arr[i / 2]);
            arr[i] = min(tmp, arr[i - 1]) + 1;
        }
        else if(i % 3 == 0)
            arr[i] = min(arr[i / 3], arr[i - 1]) + 1;
        else if(i % 2 == 0)
            arr[i] = min(arr[i / 2], arr[i - 1]) + 1;
        else
            arr[i] = arr[i - 1] + 1;
    }

    cout << arr[n] << '\n';
    return 0;
}
