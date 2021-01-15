//
//  main.cpp
//  11055
//
//  Created by 이원창 on 2021/01/13.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long arr[1001] = {0, };
    long long dp[1001] = {0, };
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> arr[i];
        dp[i] = arr[i];
    }

    for(int i = 1; i <= n; i++){
        for(int j = i; j <= n; j++){
            if(arr[i] < arr[j])
                dp[j] = max(dp[j], dp[i] + arr[j]);
        }
    }
    
    cout << *max_element(dp, dp + n + 1) << '\n';
    return 0;
}
