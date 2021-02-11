//
//  main.cpp
//  14500
//
//  Created by 이원창 on 2021/02/11.
//

#include <iostream>
using namespace std;
int n = 0;
int m = 0;
int ans = 0;
int arr[500][500];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int ox[4][4] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
int oy[4][4] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
bool visit[500][500];
void go(int sx, int sy, int cnt, int sum){
    if(cnt == 4){
        ans = max(ans, sum);
        return;
    }
    for(int i = 0; i < 4; i++){
        int nx = sx + dx[i];
        int ny = sy + dy[i];
        
        if(nx >= 0 && ny >= 0 && nx < n && ny < m){
            if(!visit[nx][ny]){
                visit[nx][ny] = true;
                go(nx, ny, cnt + 1, sum + arr[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }
}
// check block whether 'ㅗ' shape or not
void check_outlier(int sx, int sy){
    for(int i = 0; i < 4; i++){
        bool flag = false;
        int sum = 0;
        
        for(int j = 0; j < 4; j++){
            int nx = sx + ox[i][j];
            int ny = sy + oy[i][j];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                flag = true;
                break;
            }
            else
                sum += arr[nx][ny];
        }
        if(!flag)
            ans = max(ans, sum);
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            visit[i][j] = true;
            go(i, j, 0, 0);
            visit[i][j] = false;
            check_outlier(i, j);
        }
    }
    
    cout << ans << '\n';
    return 0;
}
