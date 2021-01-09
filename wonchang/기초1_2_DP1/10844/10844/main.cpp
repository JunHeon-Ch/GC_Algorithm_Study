//
//  main.cpp
//  10844
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long ans = 0;
    long long mod = 1000000000;
    long long dp[101][10] = {0, };
    
    cin >> n;
    for(int i = 1; i < 10; i++){
        dp[1][i] = 1;
    }
    
    dp[1][0] = 0;
    for(int i = 2; i <= n; i++){
        for(int j = 0; j < 10; j++){
            if(j == 0)
                dp[i][j] = dp[i - 1][j + 1] % mod;
            else if(j == 9)
                dp[i][j] = dp[i - 1][j - 1] % mod;
            else
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
        }
    }

    for(int i = 0; i < 10; i++){
        ans += (dp[n][i] % mod);
    }

    cout << ans % mod<< '\n';
    return 0;
}
