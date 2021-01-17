//
//  main.cpp
//  15655
//
//  Created by 이원창 on 2021/01/17.
//

#include <iostream>
#include <algorithm>
using namespace std;

bool visit[8];
int arr[8] = {0, };
int num[8] = {0, };
int n = 0;
int m = 0;
void go(int cnt){
    if(cnt == m){
        for(int i = 0; i < m; i++){
            cout << arr[i] << ' ';
        }
        cout << '\n';
    }
    else if(cnt == 0){
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                arr[cnt] = num[i];
                visit[i] = true;
                go(cnt + 1);
                visit[i] = false;
            }
        }
    }
    else{
        for(int i = 0; i < n; i++){
            if(!visit[i] && arr[cnt - 1] < num[i]){
                arr[cnt] = num[i];
                visit[i] = true;
                go(cnt + 1);
                visit[i] = false;
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    cin >> n >> m;
    
    for(int i = 0; i < n; i++){
        cin >> num[i];
    }
    
    sort(num, num + n);
    go(0);
    return 0;
}

