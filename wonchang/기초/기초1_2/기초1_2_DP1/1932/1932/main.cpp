//
//  main.cpp
//  1932
//
//  Created by 이원창 on 2021/01/13.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long arr[501][501];
    long long dp[501][501];
    long long ans = 0;
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= i; j++){
            cin >> arr[i][j];
        }
    }

    dp[1][1] = arr[1][1];
    for(int i = 2; i <= n; i++){
        for(int j = 1; j <= i; j++){
            
            dp[i][j] = arr[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j]);
        }
    }

    for(int i = 1; i <= n; i++){
        ans = max(ans, dp[n][i]);
    }
    cout << ans << '\n';

    return 0;
}
