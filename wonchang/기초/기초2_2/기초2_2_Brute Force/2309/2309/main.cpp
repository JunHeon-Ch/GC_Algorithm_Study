//
//  main.cpp
//  2309
//
//  Created by 이원창 on 2021/01/15.
//

#include <iostream>
#include <algorithm>
using namespace std;
int arr[9] = {0, };
bool visit[9] = {false, };
void print(int n, int m){
    for(int i = 0; i < 9; i++){
        if(visit[i])
            cout << arr[i] << '\n';
    }
}
int main(int argc, const char * argv[]) {
    int total = 0;
    
    for(int i = 0; i < 9; i++){
        cin >> arr[i];
        visit[i] = true;
        total += arr[i];
    }
    
    total -= 100;
    sort(arr, arr + 9);
    for(int i = 0; i < 9; i++){
        for(int j = i + 1; j < 9; j++){
            if((arr[i] + arr[j]) == total){
                visit[i] = false;
                visit[j] = false;
                print(i, j);
                return 0;
            }
        }
    }
    
    return 0;
}
