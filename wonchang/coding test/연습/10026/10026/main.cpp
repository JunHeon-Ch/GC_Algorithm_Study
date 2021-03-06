//
//  main.cpp
//  10026
//
//  Created by 이원창 on 2021/03/06.
//

#include <iostream>
#include <queue>
using namespace std;
int n = 0;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
char arr[100][100];
bool visit[100][100][2];
void bfs(int sx, int sy){
    queue<pair<int, int>> q;
    
    q.push({sx, sy});
    visit[sx][sy][0] = true;
    char c = arr[sx][sy];
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            
            if(!visit[nx][ny][0] && c == arr[nx][ny]){
                visit[nx][ny][0] = true;
                q.push({nx, ny});
            }
        }
    }
}
void bfs2(int sx, int sy){
    queue<pair<int, int>> q;
    
    q.push({sx, sy});
    visit[sx][sy][1] = true;
    char c = arr[sx][sy];
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            
            if(!visit[nx][ny][1]){
                if(arr[nx][ny] == c){
                    q.push({nx, ny});
                    visit[nx][ny][1] = true;
                }
                else if(c == 'R' && arr[nx][ny] == 'G'){
                    q.push({nx, ny});
                    visit[nx][ny][1] = true;
                }
                else if(c == 'G' && arr[nx][ny] == 'R'){
                    q.push({nx, ny});
                    visit[nx][ny][1] = true;
                }
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    int ans[2] = {0, };
    
    cin >> n;
    getchar();
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
        }
        getchar();
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(!visit[i][j][0]){
                bfs(i, j);
                ans[0]++;
            }
            if(!visit[i][j][1]){
                bfs2(i, j);
                ans[1]++;
            }
        }
    }

    cout << ans[0] << ' ' << ans[1] << '\n';
    return 0;
}
