//
//  main.cpp
//  17425
//
//  Created by 이원창 on 2021/02/04.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n = 0;
    vector<long long> v(1000001, 1);
    long long dp[1000001] = {0, };

    for(int i = 2; i <= 1000000; i++){
        for(int j = 1; i * j <= 1000000; j++){
            v[i * j] += i;
        }
    }
    
    for(int i = 1; i <= 1000000; i++){
        dp[i] = dp[i - 1] + v[i];
    }
    
    cin >> n;
    for(int i = 0; i < n; i++){
        int tmp = 0;
        
        cin >> tmp;
        cout << dp[tmp] << '\n';
    }

    
    return 0;
}
