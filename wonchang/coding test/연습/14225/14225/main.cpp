//
//  main.cpp
//  14225
//
//  Created by 이원창 on 2021/02/11.
//

#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;
int n = 0;
int arr[21];
bool visit[21];
bool check[2000000];
void go(int start, int cnt, int sum){
    if(!check[sum]){
        check[sum] = true;
    }
    for(int i = start; i < n; i++){
        if(!visit[i]){
            visit[i] = true;
            go(i, cnt + 1, sum + arr[i]);
            visit[i] = false;
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    go(0, 0, 0);
    for(int i = 0; i < 2000000; i++){
        if(!check[i]){
            cout << i << '\n';;
            return 0;
        }
    }
    
    return 0;
}

