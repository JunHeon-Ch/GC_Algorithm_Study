//
//  main.cpp
//  2193
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long dp[90] = {0, };
    
    cin >> n;
    dp[1] = 1;
    dp[2] = 1;
    for(int i = 3; i <= n; i++){
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    cout << dp[n] << '\n';
    return 0;
}
