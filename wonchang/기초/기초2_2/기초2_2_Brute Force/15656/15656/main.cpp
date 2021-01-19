//
//  main.cpp
//  15656
//
//  Created by 이원창 on 2021/01/19.
//

#include <iostream>
#include <algorithm>
using namespace std;
int ans[7];
int arr[7];
bool visit[7];
void go(int n, int m, int cnt){
    if(cnt == m){
        for(int i = 0; i < m; i++){
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    
    for(int i = 0; i < n; i++){
        ans[cnt] = arr[i];
        go(n, m, cnt + 1);
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
