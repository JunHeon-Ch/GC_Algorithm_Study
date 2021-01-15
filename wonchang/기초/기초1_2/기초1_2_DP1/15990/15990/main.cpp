//
//  main.cpp
//  15990
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
#include <vector>
using namespace std;
long long dp(int n){
    long long dp[100001][4] = {0, };
    
    dp[1][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;
    for(int i = 4; i <= n; i++){
        dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
        dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
        dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
    }
    
    return (dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009;
}
int main(int argc, const char * argv[]) {
    int t = 0;
    
    cin >> t;
    for(int i = 0; i < t; i++){
        int tmp = 0;
        
        cin >> tmp;
        cout << dp(tmp) << '\n';
    }
    return 0;
}
