//
//  main.cpp
//  1248
//
//  Created by 이원창 on 2021/01/20.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n = 0;
int arr[10] = {0, };
char sign[10][10];
bool flag = false;
bool check(int cnt){
    int sum = 0;
    for(int i = cnt; i >= 0; i--){
        sum += arr[i];
        if(sign[i][cnt] == '+' && sum <= 0)
            return false;
        else if(sign[i][cnt] == '0' && sum != 0)
            return false;
        else if(sign[i][cnt] == '-' && sum >= 0)
            return false;
    }
    
    return true;
}
void go(int cnt){
    if(flag)
        return;
    if(cnt == n){
        for(int i = 0; i < n; i++){
            cout << arr[i] << ' ';
        }
        cout << '\n';
        flag = true;
        
        return;
    }
    for(int i = -10; i < 11; i++){
        arr[cnt] = i;
        if(check(cnt))
            go(cnt + 1);
    }
}
int main(int argc, const char * argv[]) {
    cin >> n;
    getchar();
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            cin >> sign[i][j];
        }
    }
    go(0);
    return 0;
}
