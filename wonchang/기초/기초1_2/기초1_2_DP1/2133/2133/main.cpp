//
//  main.cpp
//  2133
//
//  Created by 이원창 on 2021/01/15.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long dp[31] = {0, };
    
    cin >> n;
    dp[2] = 3;
    for(int i = 4; i <= n; i += 2){
        dp[i] = dp[i - 2] * 3;
        for(int j = 0; j <= i - 4; j += 2){
            dp[i] += (2 * dp[j]);
        }
        dp[i] += 2;
    }
    
    cout << dp[n] << '\n';
    return 0;
}
