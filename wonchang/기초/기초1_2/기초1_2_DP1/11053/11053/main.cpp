//
//  main.cpp
//  11053
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int ans = 0;
    int dp[1001] = {0, };
    
    cin >> n;
    vector<int> v(n + 1);
    for(int i = 1; i <= n; i++){
        cin >> v[i];
        dp[i] = 1;
    }
    
    for(int i = 2; i <= n; i++){
        for(int j = 1; j < i; j++){
            if(v[i] > v[j])
                dp[i] = max(dp[i], dp[j] + 1);
        }
    }
    
    for(int i = 1; i <= n; i++){
        if(ans < dp[i])
            ans = dp[i];
    }
    
    cout << ans << '\n';
    return 0;
}
