//
//  main.cpp
//  14501
//
//  Created by 이원창 on 2021/01/20.
//

#include <iostream>
#include <algorithm>
using namespace std;
int n = 0;
int t[15] = {0, };
int p[15] = {0, };
int ans = 0;
void go(int cnt, int sum){
    if(cnt == n){
        ans = max(ans, sum);
        return;
    }
    else if(cnt > n)
        return;
    
    go(cnt + t[cnt], sum + p[cnt]);
    go(cnt + 1, sum);
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> t[i] >> p[i];
    }
    
    go(0, 0);
    cout << ans << '\n';
    return 0;
}
