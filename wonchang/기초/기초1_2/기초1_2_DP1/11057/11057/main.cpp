//
//  main.cpp
//  11057
//
//  Created by 이원창 on 2021/01/12.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long dp[1001][10];
    long long ans = 0;
    
    cin >> n;
    for(int i = 0; i <= n; i++){
        dp[i][0] = 1;
    }
    
    for(int i = 1; i <= n; i++){
        for(int j = 1; j < 10; j++){
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
        }
    }
    
    for(int i = 0; i < 10; i++){
        ans += dp[n][i];
        ans %= 10007;
    }
    
    cout << ans % 10007 << '\n';
    
    return 0;
}
