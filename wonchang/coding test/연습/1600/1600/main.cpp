//
//  main.cpp
//  1600
//
//  Created by 이원창 on 2021/03/08.
//

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int k, w, h;
int arr[200][200];
int dx[12] = {0, 0, -1, 1, -2, -2, -1, -1, 1, 1, 2, 2};
int dy[12] = {-1, 1, 0, 0, -1, 1, -2, 2, -2, 2, -1, 1};
bool visit[200][200][30];
struct info{
    int x;
    int y;
    int dis;
    int horse;
};
int bfs(){
    queue<info> q;
    q.push({0, 0, 0, 0});
    
    memset(visit, false, sizeof(visit));
    visit[0][0][0] = true;
    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int d = q.front().dis;
        int hor = q.front().horse;
        
        if(x == h - 1 && y == w - 1)
            return d;
        
        q.pop();
        if(hor < k){
            for(int i = 4; i < 12; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= h || ny < 0 || ny >= w)
                    continue;
                
                if(!visit[nx][ny][hor + 1] && arr[nx][ny] == 0){
                    visit[nx][ny][hor + 1] = true;
                    q.push({nx, ny, d + 1, hor + 1});
                }
            }
        }
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= h || ny < 0 || ny >= w)
                continue;
            
            if(!visit[nx][ny][hor] && arr[nx][ny] == 0){
                visit[nx][ny][hor] = true;
                q.push({nx, ny, d + 1, hor});
            }
        }
    }
    
    return -1;
}
int main(int argc, const char * argv[]) {
    cin >> k >> w >> h;
    for(int i = 0; i < h; i++){
        for(int j = 0; j < w; j++){
            cin >> arr[i][j];
        }
    }

    cout << bfs() << '\n';
    return 0;
}
