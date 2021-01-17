//
//  main.cpp
//  1912
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
#include <climits>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base:: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n = 0;
    int ans = INT_MIN;
    int arr[100001] = {0, };
    int dp[100001] = {0, };
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> arr[i];
    }

    dp[1] = arr[1];
    for(int i = 2; i <= n; i++){
        dp[i] = max(dp[i - 1] + arr[i], arr[i]);
    }
    
    for(int i = 1; i <= n; i++){
        ans = max(ans, dp[i]);
    }
    
    cout << ans << '\n';
    return 0;
}
