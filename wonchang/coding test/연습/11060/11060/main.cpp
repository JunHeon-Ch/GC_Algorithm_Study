//
//  main.cpp
//  11060
//
//  Created by 이원창 on 2021/03/14.
//

#include <iostream>
using namespace std;
int n = 0;
int arr[1000];
int dp[1000];
int main(int argc, const char * argv[]) {
    cin >> n;
    
    for(int i = 0; i < n; i++){
        cin >> arr[i];
        dp[i] = 1001;
    }
    
    dp[0] = 0;
    for(int i = 1; i < n; i++){
        for(int j = 0; j < arr[i]; j++){
            dp[i + j] = min(dp[i] + 1, dp[i + j]);
        }
    }
    
    for(int i = 0; i < n; i++){
        cout << dp[i] << ' ';
    }
//    cout << dp[n - 1] << '\n';
    return 0;
}
