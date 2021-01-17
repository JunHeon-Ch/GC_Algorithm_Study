//
//  main.cpp
//  14002
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int num[1001] = {0, };
int dp[1001] = {0, };
int idx[1001] = {0, };
vector<int> v;
void go(int id){
    if(id == -1)
        return;

    v.push_back(num[id]);
    go(idx[id]);
}
int main(int argc, const char * argv[]) {
    int n = 0;
    int ans = 1;
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> num[i];
        dp[i] = 1;
        idx[i] = -1;
    }
    
    for(int i = 2; i <= n; i++){
        for(int j = 1; j < i; j++){
            if(num[i] > num[j] && dp[i] < dp[j] + 1){
                dp[i] = dp[j] + 1;
                idx[i] = j;
            }
        }
        ans = max(dp[i], ans);
    }
    
    cout << ans << '\n';
    for (int i = 1; i <= n; i++) {
        if (dp[i] == ans){
            v.push_back(num[i]);
            go(idx[i]);
            break;
        }
    }
    
    sort(v.begin(), v.end());
    for (int i = 0; i < v.size(); i++) {
        cout << v[i] << " ";
    }
    cout << '\n';
    
    return 0;
}
