//
//  main.cpp
//  1149
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
#include <climits>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int ans = INT_MAX;
    int rgb[1001][3];
    int dp [1001][3];
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> rgb[i][0] >> rgb[i][1] >> rgb[i][2];
    }
    
    dp[1][0] = rgb[1][0];
    dp[1][1] = rgb[1][1];
    dp[1][2] = rgb[1][2];
    for(int i = 2; i <= n; i++){
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
    }
    
    for(int i = 0; i < 3; i++){
        ans = min(ans, dp[n][i]);
    }
    cout << ans << '\n';
    return 0;
}
