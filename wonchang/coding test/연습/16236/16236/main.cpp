//
//  main.cpp
//  16236
//
//  Created by 이원창 on 2021/02/28.
//

#include <iostream>
#include <queue>
#include <cstring>
#include <tuple>
using namespace std;
queue<tuple<int, int, int, int>> q;
int n = 0;
int c = 0;
int arr[20][20];
int cnt[20][20][20];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
int visit[20][20], shark_x, shark_y, eat_cnt, shark_size = 2;
int min_dist, min_x, min_y, ans;
void bfs(int sx, int sy){
    queue<pair<int, int>> q;

    visit[sx][sy] = 0;
    q.push({sx, sy});
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            
            if(visit[nx][ny] != -1 || arr[nx][ny] > shark_size)
                continue;
            
            visit[nx][ny] = visit[x][y] + 1;
            if(arr[nx][ny] != 0 && arr[nx][ny] < shark_size){
                if(min_dist > visit[nx][ny]){
                    min_x = nx;
                    min_y = ny;
                    min_dist = visit[nx][ny];
                }
                else if(min_dist == visit[nx][ny]){
                    if(min_x == nx){
                        if(min_y > ny){
                            min_x = nx;
                            min_y = ny;
                        }
                    }
                    else if(min_x > nx){
                        min_x = nx;
                        min_y = ny;
                    }
                }
            }
            q.push({nx, ny});
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
            if(arr[i][j] == 9){
                shark_x = i;
                shark_y = j;
                arr[i][j] = 0;
            }
        }
    }
        
    while(true){
        min_dist = 401;
        min_x = 20;
        min_y = 20;

        memset(visit, -1, sizeof(visit));
        bfs(shark_x, shark_y);
        if(min_x != 20 && min_y != 20){
            ans += visit[min_x][min_y];
            eat_cnt++;
            
            if(eat_cnt == shark_size){
                shark_size++;
                eat_cnt = 0;
            }
            arr[min_x][min_y] = 0;
            shark_x = min_x;
            shark_y = min_y;
        }
        else
            break;
    }
    
    cout << ans << '\n';
}
