//
//  main.cpp
//  17404
//
//  Created by 이원창 on 2021/01/15.
//

#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long ans = INT_MAX;
    long long arr[1001][3] = {0, };
    long long dp[1001][3] = {0, };
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        for(int j = 0; j < 3; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            if(i == j)
                dp[1][j] = arr[1][j];
            else
                dp[1][j] = 1000000001;
        }
        
        for(int j = 2; j <= n; j++){
            dp[j][0] = min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
            dp[j][1] = min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
            dp[j][2] = min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
        }

        for(int j = 0; j < 3; j++){
            if(i != j)
                ans = min(ans, dp[n][j]);
        }
    }

    cout << ans << '\n';
    return 0;
}
