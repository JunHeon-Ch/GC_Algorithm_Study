//
//  main.cpp
//  10971
//
//  Created by 이원창 on 2021/01/20.
//

#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;
int n = 0;
int ini = 0;
long long ans = LONG_LONG_MAX;
long long w[10][10];
bool visit[10];
void go(int start, int cnt, long long sum){
    if(cnt == n - 1){
        if(w[start][ini] != 0)
            ans = min(ans, sum + w[start][ini]);
    }

    for(int i = 0; i < n; i++){
        if(!visit[i] && w[start][i] != 0){
            visit[i] = true;
            go(i, cnt + 1, sum + w[start][i]);
            visit[i] = false;
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> w[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        ini = i;
        visit[i] = true;
        go(i, 0, 0);
        visit[i] = false;
    }

    cout << ans << '\n';
    return 0;
}
