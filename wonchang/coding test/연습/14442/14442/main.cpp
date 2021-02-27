//
//  main.cpp
//  14442
//
//  Created by 이원창 on 2021/02/28.
//

#include <iostream>
#include <queue>
using namespace std;
int n = 0;
int m = 0;
int k = 0;
int arr[1000][1000];
int cnt[1000][1000][10] = {0, };
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int bfs(){
    queue<pair<pair<int, int>, int>> q;
    
    q.push({{0, 0}, 0});
    cnt[0][0][0] = 1;
    while(!q.empty()){
        int x = q.front().first.first;
        int y = q.front().first.second;
        int c = q.front().second;

        if(x == n - 1 && y == m - 1)
            return cnt[x][y][c];
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
        
            if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            
            if(arr[nx][ny] == 1 && cnt[nx][ny][c] == 0 && c < k){
                cnt[nx][ny][c + 1] = cnt[x][y][c] + 1;
                q.push({{nx, ny}, c + 1});
            }
            else if(arr[nx][ny] == 0 && cnt[nx][ny][c] == 0){
                cnt[nx][ny][c] = cnt[x][y][c] + 1;
                q.push({{nx, ny}, c});
            }
        }
    }
    
    return -1;
}
int main(int argc, const char * argv[]) {
    cin >> n >> m >> k;
    
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
