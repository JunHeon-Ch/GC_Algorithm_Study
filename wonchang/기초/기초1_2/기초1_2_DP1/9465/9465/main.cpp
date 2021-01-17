//
//  main.cpp
//  9465
//
//  Created by 이원창 on 2021/01/13.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int t = 0;
    long long arr[2][100001] = {0, };
    long long dp[100001][3] = {0, };

    cin >> t;
    for(int i = 0; i < t; i++){
        int n = 0;
        
        cin >> n;
        for(int j = 0; j < 2; j++){
            for(int k = 1; k <= n; k++){
                cin >> arr[j][k];
            }
        }
        
        dp[1][0] = 0;
        dp[1][1] = arr[0][1];
        dp[1][2] = arr[1][1];
    
        for(int j = 2; j <= n; j++){
            dp[j][0] = max({dp[j - 1][0], dp[j - 1][1], dp[j - 1][2]});
            dp[j][1] = max(dp[j - 1][0], dp[j - 1][2]) + arr[0][j];
            dp[j][2] = max(dp[j - 1][0], dp[j - 1][1]) + arr[1][j];
        }

        cout << max({dp[n][0], dp[n][1], dp[n][2]}) << '\n';
    }
    
    return 0;
}
