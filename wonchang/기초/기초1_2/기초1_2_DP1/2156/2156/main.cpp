//
//  main.cpp
//  2156
//
//  Created by 이원창 on 2021/01/13.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int arr[10001] = {0, };
    long long dp[10001] = {0, };
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> arr[i];
    }
    
    dp[1] = arr[1];
    for(int i = 2; i <= n; i++){
        dp[i] = max({dp[i - 1], (dp[i - 2] + arr[i]), (dp[i - 3] + arr[i] + arr[i - 1])});
    }
    cout << dp[n] << '\n';
    return 0;
}
