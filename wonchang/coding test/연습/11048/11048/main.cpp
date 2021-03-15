//
//  main.cpp
//  11048
//
//  Created by 이원창 on 2021/03/14.
//

#include <iostream>
using namespace std;
int n, m;
int arr[1000][1000];
int dp[1000][1000];
int dx[3] = {-1, -1, 0};
int dy[3] = {-1, 0, -1};
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    dp[0][0] = arr[0][0];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            int tmp = 0;
            for(int k = 0; k < 3; k++){
                int nx = i + dx[k];
                int ny = j + dy[k];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                
                tmp = max(tmp, dp[nx][ny]);
            }
            dp[i][j] = tmp + arr[i][j];
        }
    }
    
    cout << dp[n - 1][m - 1] << '\n';
    return 0;
}
