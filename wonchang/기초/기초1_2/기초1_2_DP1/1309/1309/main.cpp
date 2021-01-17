//
//  main.cpp
//  1309
//
//  Created by 이원창 on 2021/01/12.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int mod = 9901;
    int dp[100001][3];

    
    cin >> n;
    dp[1][0] = 1;
    dp[1][1] = 1;
    dp[1][2] = 1;
    for(int i = 2; i <= n; i++){
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
    }
    
    cout << (dp[n][0] + dp[n][1] + dp[n][2]) % mod << '\n';
    return 0;
}
