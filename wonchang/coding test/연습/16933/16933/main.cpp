//
//  main.cpp
//  16933
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
bool visit[1000][1000][11];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
struct tmp{
    int x;
    int y;
    int cnt;
    int dis;
    bool brok;
};
int bfs(){
    queue<tmp> q;

    visit[0][0][0] = true;
    q.push({0, 0, 0, 1, true});
    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int c = q.front().cnt;
        int d = q.front().dis;
        bool b = q.front().brok;
        
        if(x == n - 1 && y == m - 1)
            return d;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            
            if(arr[nx][ny] == 0 && !visit[nx][ny][c]){
                visit[nx][ny][c] = true;
                q.push({nx, ny, c, d + 1, !b});
            }
            else if(arr[nx][ny] == 1 && !visit[nx][ny][c + 1] && c < k){
                if(b){
                    visit[nx][ny][c + 1] = true;
                    q.push({nx, ny, c + 1, d + 1, !b});
                }
                else
                    q.push({x, y, c, d + 1, !b});
            }
        }
    }
    
    return -1;
}
int main(int argc, const char * argv[]) {
    cin >> n >> m >> k;
    
    getchar();
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            char tmp;
            
            cin >> tmp;
            arr[i][j] = tmp - '0';
        }
        getchar();
    }
    
    cout << bfs() << '\n';
    return 0;
}
