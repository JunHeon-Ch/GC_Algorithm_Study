//
//  main.cpp
//  15657
//
//  Created by 이원창 on 2021/01/19.
//

#include <iostream>
#include <algorithm>
using namespace std;
int ans[8];
int arr[8];
bool visit[8];
void go(int n, int m, int cnt){
    if(cnt == m){
        for(int i = 0; i < m; i++){
            cout << ans[i] << ' ';
        }
        cout << '\n';
    }
    else if(cnt == 0){
        for(int i = 0; i < n; i++){
            if(ans[cnt] <= arr[i]){
                ans[cnt] = arr[i];
                go(n, m, cnt + 1);
            }
        }

    }
    else{
        for(int i = 0; i < n; i++){
            if(ans[cnt - 1] <= arr[i]){
                ans[cnt] = arr[i];
                go(n, m, cnt + 1);
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    int n = 0;
    int m = 0;
    
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    sort(arr, arr + n);
    go(n, m, 0);
    
    return 0;
}
