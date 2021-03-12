//
//  main.cpp
//  4991
//
//  Created by 이원창 on 2021/03/08.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <climits>
#include <queue>
#include <vector>
using namespace std;
int w, h;
int dis[20][20];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
char arr[20][20];
bool visit[20][20];
void bfs(int sx, int sy){
    queue<pair<int, int>> q;
    visit[sx][sy] = true;
    q.push({sx, sy});
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= h || ny < 0 || ny >= w)
                continue;
            
            if(arr[nx][ny] == 'x')
                continue;
            
            if(!visit[nx][ny]){
                visit[nx][ny] = true;
                q.push({nx, ny});
                dis[nx][ny] = dis[x][y] + 1;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    while(true) {
        cin >> w >> h;
        if(w == 0 && h == 0)
            break;
        
        memset(arr, 0, sizeof(arr));
        vector<pair<int, int>> v;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                cin >> arr[i][j];
                
                if(arr[i][j] == '*')
                    v.push_back({i, j});
                else if(arr[i][j] == 'o')
                    v.insert(v.begin(), {i, j});
            }
        }
        
        int result[20][20] = {0, };
        for(int i = 0; i < v.size(); i++) {
            memset(dis, 0, sizeof(dis));
            memset(visit, false, sizeof(visit));
            bfs(v[i].first, v[i].second);
            
            for(int j = 0; j < v.size(); j++) {
                result[i][j] = dis[v[j].first][v[j].second];
            }
        }
        
        vector<int> loc(v.size() - 1);
        for(int i = 0; i < v.size() - 1; i++){
            loc[i] = i + 1;
        }
        
        int ans = INT_MAX;
        bool flag = true;
        
        do{
            int cur = result[0][loc[0]];
            if(!cur){
                flag = false;
                break;
            }
            
            for(int i = 0; i < v.size() - 2; i++){
                cur += result[loc[i]][loc[i + 1]];
            }
            
            if(ans > cur)
                ans = cur;
        }while(next_permutation(loc.begin(), loc.end()));
        
        if(!flag)
            cout << "-1\n";
        else
            cout << ans << '\n';
    }
}
