//
//  main.cpp
//  2234
//
//  Created by 이원창 on 2021/03/12.
//

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int n, m;
int ans[3] = {0, };
int arr[50][50];
int dx[4] = {0, -1, 0, 1};
int dy[4] = {-1, 0, 1, 0};
bool visit[50][50];
int bfs(int sx, int sy){
    int cnt = 1;
    queue<pair<int, int>> q;
    
    q.push({sx, sy});
    visit[sx][sy] = true;
    while(!q.empty()){
        int bit = 1;
        int x = q.front().first;
        int y = q.front().second;

        q.pop();
        for(int i = 0; i < 4; i++){
            if(!(arr[x][y] & bit)){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                
                if(!visit[nx][ny]){
                    cnt++;
                    visit[nx][ny] = true;
                    q.push({nx, ny});
                }
            }
            bit <<= 1;
        }
    }
    
    return cnt;
}
int main(int argc, const char * argv[]) {
    cin >> m >> n;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(!visit[i][j]){
                ans[0]++;
                ans[1] = max(ans[1], bfs(i, j));
            }
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            for(int k = 1; k <= 8; k <<= 1){
                if(arr[i][j] & k){
                    memset(visit, false, sizeof(visit));
                    arr[i][j] -= k;
                    ans[2] = max(ans[2], bfs(i, j));
                    arr[i][j] += k;
                }
            }
        }
    }
    
    for(int i = 0; i < 3; i++){
        cout << ans[i] << '\n';
    }
    
    return 0;
}
