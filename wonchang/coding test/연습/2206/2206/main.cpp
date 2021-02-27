//
//  main.cpp
//  2206
//
//  Created by 이원창 on 2021/02/27.
//

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int n = 0;
int m = 0;
int ans = 0;
int arr[1000][1000];
int cnt[1000][1000][2];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
bool visit[1000][1000];
queue<pair<pair<int, int>, int>> q;
int bfs(){
    q.push({{0, 0}, true});
    cnt[0][0][1] = 1;
    while(!q.empty()){
        int x = q.front().first.first;
        int y = q.front().first.second;
        int brok = q.front().second;
        
        q.pop();
        if(x == n - 1 && y == m - 1)
            return cnt[x][y][brok];
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            
            if(arr[nx][ny] == 1 && brok){
                q.push({{nx, ny}, brok - 1});
                cnt[nx][ny][brok - 1] = cnt[x][y][brok] + 1;
            }
            else if(arr[nx][ny] == 0 && cnt[nx][ny][brok] == 0){
                q.push({{nx, ny}, brok});
                cnt[nx][ny][brok] = cnt[x][y][brok] + 1;
            }
        }
    }
    
    return -1;
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    memset(cnt, 0, sizeof(cnt));
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            char tmp;
            
            cin >> tmp;
            arr[i][j] = tmp - '0';
        }
    }
    cout << bfs() << '\n';
    return 0;
}
