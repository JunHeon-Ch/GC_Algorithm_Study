//
//  main.cpp
//  2178
//
//  Created by 이원창 on 2021/01/28.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
using namespace std;
int n = 0;
int m = 0;
int arr[100][100];
int dis[100][100];
bool visit[100][100];
void bfs(int sx, int sy){
    queue<pair<int, int>> q;

    int dx[4] = {0, 0, 1, -1};
    int dy[4] = {1, -1, 0, 0};

    visit[sx][sy] = true;
    q.push(make_pair(sx, sy));
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            
            if(!visit[nx][ny] && arr[nx][ny] == 1){
                dis[nx][ny] = dis[x][y] + 1;
                visit[nx][ny] = true;
                q.push(make_pair(nx, ny));
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    getchar();
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            char tmp;
            
            cin >> tmp;
            arr[i][j] = tmp - '0';
            dis[i][j] = 1;
        }
        getchar();
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(!visit[i][j] && arr[i][j] == 1){
                bfs(i, j);
            }
        }
    }
    
    cout << dis[n - 1][m - 1] << '\n';
    return 0;
}
