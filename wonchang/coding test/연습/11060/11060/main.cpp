//
//  main.cpp
//  11060
//
//  Created by 이원창 on 2021/03/14.
//

#include <iostream>
#include <cstring>
using namespace std;
int n = 0;
int arr[1000];
int dp[1000];
int main(int argc, const char * argv[]) {
    cin >> n;
    
    memset(dp, -1, sizeof(dp));
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    dp[0] = 0;
    for(int i = 1; i < n; i++){
        for(int j = i - 1; j >= 0; j--){
            if(arr[j] + j >= i && dp[j] != -1)
                dp[i] = dp[j] + 1;
        }
    }
    
    cout << dp[n - 1] << '\n';
    return 0;
}
