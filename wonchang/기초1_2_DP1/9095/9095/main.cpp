//
//  main.cpp
//  9095
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
using namespace std;
long long dp(int n){
    long long dp[11];
    
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for(int i = 4; i <= n; i++){
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    
    return dp[n];
}
int main(int argc, const char * argv[]) {
    int t = 0;
    
    cin >> t;
    for(int i = 0; i < t; i++){
        int n = 0;
        cin >> n;
        cout << dp(n) << '\n';
    }
    return 0;
}
