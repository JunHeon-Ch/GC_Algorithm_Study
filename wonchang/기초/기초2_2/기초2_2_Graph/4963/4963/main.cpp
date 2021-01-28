//
//  main.cpp
//  4963
//
//  Created by 이원창 on 2021/01/28.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
using namespace std;
int w = 0;
int h = 0;
int arr[50][50];
bool visit[50][50];
void bfs(int i, int j){
    int dx[8] = {0, 0, 1, 1, 1, -1, -1, -1};
    int dy[8] = {-1, 1, -1, 0, 1, -1, 0, 1};
    queue<pair<int, int>> q;
    
    visit[i][j] = true;
    q.push(make_pair(i, j));
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int k = 0; k < 8; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if(nx < 0 || ny < 0 || nx >= h || ny >= w)
                continue;
            
            if(!visit[nx][ny] && arr[nx][ny] == 1){
                q.push(make_pair(nx, ny));
                visit[nx][ny] = true;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> w >> h;
    while(w || h){
        memset(arr, false, sizeof(arr));
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                cin >> arr[i][j];
            }
        }
        
        int ans = 0;
        memset(visit, false, sizeof(visit));
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(!visit[i][j] && arr[i][j] == 1){
                    bfs(i, j);
                    ans++;
                }
            }
        }
        cout << ans << '\n';
        cin >> w >> h;
    }
    
    return 0;
}
