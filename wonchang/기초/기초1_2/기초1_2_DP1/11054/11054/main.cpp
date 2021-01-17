//
//  main.cpp
//  11054
//
//  Created by 이원창 on 2021/01/15.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n = 0;
    long long ans = 0;
    long long arr[1001] = {0, };
    long long dp[1001][2] = {0, };
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> arr[i];
        dp[i][0] = 1;
        dp[i][1] = 1;
    }
    
    for(int i = 1; i <= n; i++){
        for(int j = i; j <= n; j++){
            if(arr[i] < arr[j])
                dp[j][0] = max(dp[i][0] + 1, dp[j][0]);
        }
    }

    for(int i = n; i >= 1; i--){
        for(int j = i - 1; j >= 0; j--){
            if(arr[i] < arr[j])
                dp[j][1] = max(dp[i][1] + 1, dp[j][1]);
        }
    }

//    *** 이 로직 왜 틀린 지 알려줄 사람 ***
//    for(int i = 1; i <= n; i++){
//        for(int j = i; j <= n; j++){
//            if(arr[i] > arr[j])
//                dp[j][1] = max({dp[i][1] + 1, dp[i][0] + 1, dp[j][0]});
//        }
//        ans = max({ans, dp[i][0], dp[i][1]});
//    }

    for(int i = 1; i <= n; i++){
        ans = max(ans, dp[i][0] + dp[i][1]);
    }

//    cout << ans << '\n';
    cout << ans - 1 << '\n';
    return 0;
}
