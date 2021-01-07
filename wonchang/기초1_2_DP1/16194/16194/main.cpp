//
//  main.cpp
//  16194
//
//  Created by 이원창 on 2021/01/07.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int dp[1001] = {0, };
    int ini[1001];
    int n = 0;
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> ini[i];
        dp[i] = 10001;
    }
    
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= i; j++){
            int tmp = dp[i - j] + ini[j];
            dp[i] = min(dp[i], tmp);
        }
    }
    
    cout << dp[n] << endl;
    return 0;
}
