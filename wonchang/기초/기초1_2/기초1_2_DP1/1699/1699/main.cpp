//
//  main.cpp
//  1699
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
#include <cmath>
#include <climits>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long dp[100001] = {0, };
    
    cin >> n;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
        long long sq = (int)sqrt(i);
        dp[i] = INT_MAX;
        if(sq == sqrt(i))
            dp[i] = 1;
        else{
            for(int j = 1; j <= sq; j++){
                dp[i] = min(dp[j * j] + dp[i - (j * j)], dp[i]);
            }
        }
    }
    
    cout << dp[n] << '\n';
    return 0;
}
