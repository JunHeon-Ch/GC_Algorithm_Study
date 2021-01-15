//
//  main.cpp
//  13398
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
    int arr[100001] = {0, };
    int dp[100001][2] = {0, };
    int ans = 0;
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> arr[i];
    }

    dp[1][0] = arr[1];
    ans = arr[1];
    for(int i = 2; i <= n; i++){
        dp[i][0] = max(dp[i - 1][0] + arr[i], arr[i]);
        dp[i][1] = max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
        ans = max(ans, max(dp[i][0], dp[i][1]));
    }
    
    cout << ans << '\n';
    return 0;
}
