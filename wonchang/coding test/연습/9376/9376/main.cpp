//
//  main.cpp
//  9376
//
//  Created by 이원창 on 2021/03/07.
//

#include <iostream>
#include <deque>
#include <cstring>
using namespace std;
int t, w, h;
int dis[102][102][3];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
char arr[102][102];
struct map {
    int x;
    int y;
    int idx;
};
deque<map> q;
void bfs(){
    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int idx = q.front().idx;
        
        q.pop_front();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= w + 2 || ny < 0 || ny >= h + 2)
                continue;
            
            if(arr[nx][ny] == '*')
                continue;
            
            if(dis[nx][ny][idx] != -1)
                continue;
            
            if(arr[nx][ny] == '.' || arr[nx][ny] == '$'){
                dis[nx][ny][idx] = dis[x][y][idx];
                q.push_front({nx, ny, idx});
            }
            else if(arr[nx][ny] == '#'){
                dis[nx][ny][idx] = dis[x][y][idx] + 1;
                q.push_back({nx, ny, idx});
            }
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    while(t--){
        q = deque<map>();
        cin >> w >> h;
        memset(dis, -1, sizeof(dis));
        int idx = 0;
        for(int i = 0; i < w + 2; i++){
            for(int j = 0; j < h + 2; j++){
                if(i == 0 || i == w + 1 || j == 0 || j == h + 1)
                    arr[i][j] = '.';
                else{
                    cin >> arr[i][j];
                    if(arr[i][j] == '$') {
                        q.push_back({i, j, idx});
                        dis[i][j][idx] = 0;
                        idx++;
                    }
                }
            }
        }
        q.push_back({0, 0, idx});
        dis[0][0][idx] = 0;
        
        bfs();
        int ans = -1;
        for(int i = 1; i <= w; i++){
            for(int j = 1; j <= h; j++){
                if(arr[i][j] == '*')
                    continue;
                
                int tmp = 0;
                for(int k = 0; k < 3; k++){
                    tmp += dis[i][j][k];
                }
                
                if(tmp < 0)
                    continue;
                
                if(arr[i][j] == '#')
                    tmp -= 2;
                
                if(ans == -1 || ans > tmp)
                    ans = tmp;
            }
        }
        cout << ans << '\n';
    }
    return 0;
}
