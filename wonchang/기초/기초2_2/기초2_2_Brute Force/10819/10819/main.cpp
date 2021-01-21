//
//  main.cpp
//  10819
//
//  Created by 이원창 on 2021/01/19.
//

#include <iostream>
#include <algorithm>
using namespace std;
bool visit[8];
int ans = 0;
int arr[8] = {0, };
int temp[8] = {0, };
void go(int n, int cnt){
    if(cnt == n){
        int tmp = 0;
        for(int i = 0; i < n - 1; i++){
            tmp += abs(temp[i] - temp[i + 1]);
            ans = max(ans, tmp);
        }
    }
    
    for(int i = 0; i < n; i++){
        if(!visit[i]){
            temp[cnt] = arr[i];
            visit[i] = true;
            go(n, cnt + 1);
            visit[i] = false;
        }
    }
}
int main(int argc, const char * argv[]) {
    int n = 0;

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    go(n, 0);
    cout << ans << '\n';
    
    return 0;
}
