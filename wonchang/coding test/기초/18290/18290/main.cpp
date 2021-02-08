//
//  main.cpp
//  18290
//
//  Created by 이원창 on 2021/02/04.
//

#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;
int n = 0;
int m = 0;
int k = 0;
int ans = INT_MIN;
int arr[10][10];
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
bool visit[10][10];
bool valid(int sx, int sy){
    for(int i = 0; i < 4; i++){
        int nx = sx + dx[i];
        int ny = sy + dy[i];
    
        if(nx >= 0 && ny >= 0 && nx < n && ny < m){
            if(visit[nx][ny])
                return false;
        }
    }
    return true;
}
void go(int cnt, int sum){
    if(cnt == k){
        ans = max(ans, sum);
        return;
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(!visit[i][j]){
                if(valid(i, j)){
                    visit[i][j] = true;
                    go(cnt + 1, sum + arr[i][j]);
                    visit[i][j] = false;
                }
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m >> k;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    go(0, 0);
    cout << ans << '\n';
    return 0;
}
