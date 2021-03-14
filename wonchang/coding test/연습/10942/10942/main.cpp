//
//  main.cpp
//  10942
//
//  Created by 이원창 on 2021/03/14.
//

#include <iostream>
using namespace std;
int n, m;
int arr[2000];
int dp[2000][2000];
int palindrome(int s, int e){
    for(int i = 0; i < (e - s) / 2; i++){
        if(arr[s + i] != arr[e - i])
            return 0;
    }
    return 1;
}
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
        dp[i][i] = 1;
    }
    
    for(int i = 0; i < n - 1; i++){
        if(arr[i] == arr[i + 1])
            dp[i][i + 1] = 1;
    }
    
    for(int pos = 3; pos <= n; pos++){
        for(int i = 0; i < n - pos + 1; i++){
            if(arr[i] == arr[i + pos - 1] && dp[i + 1][i + pos - 2])
                dp[i][i + pos - 1] = 1;
        }
    }
    
    cin >> m;
    for(int i = 0; i < m; i++){
        int s, e;
        
        cin >> s >> e;
        cout << dp[s - 1][e - 1] << '\n';
    }
    return 0;
}
