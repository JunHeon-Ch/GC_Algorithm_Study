//
//  main.cpp
//  11052
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long dp[1001];
    long long ini[1001];
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> ini[i];
    }
    
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= i; j++){
            long long tmp = ini[j] + dp[i - j];
            dp[i] = max(dp[i], tmp);
        }
    }
    
    cout << dp[n] << '\n';
    return 0;
}
