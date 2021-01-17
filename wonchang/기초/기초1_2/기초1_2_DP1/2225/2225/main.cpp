//
//  main.cpp
//  2225
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
using namespace std;
long long mod = 1000000000;
int main(int argc, const char * argv[]) {
    int n = 0;
    int k = 0;
    long long dp[201][201] = {0, };
    
    cin >> n >> k;
    
    for(int i = 0; i <= n; i++){
        dp[1][i] = 1;
    }
    for(int i = 0; i <= k; i++){
        dp[i][0] = 1;
    }

    for(int i = 2; i <= k; i++){
        for(int j = 1; j <= n; j++){
            dp[i][j] = ((dp[i][j - 1]  + dp[i - 1][j]) % mod);
        }
    }

    cout << dp[k][n] << '\n';
    return 0;
}
