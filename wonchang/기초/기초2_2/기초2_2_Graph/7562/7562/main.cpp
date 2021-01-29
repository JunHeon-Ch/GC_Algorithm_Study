//
//  main.cpp
//  7562
//
//  Created by 이원창 on 2021/01/29.
//

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int n, fx, fy = 0;
int cnt[300][300];
int visit[300][300];
void bfs(queue<pair<int, int>> q){
    int dx[8] = {-1, 1, -2, 2, -2, 2, -1, 1};
    int dy[8] = {-2, -2, -1, -1, 1, 1, 2, 2};
    
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;
            
            if(!visit[nx][ny]){
                visit[nx][ny] = true;
                cnt[nx][ny] = cnt[x][y] + 1;
                q.push(make_pair(nx, ny));
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    int t = 0;
    
    cin >> t;
    while(t--){
        int x, y, nx, ny = 0;
        queue<pair<int, int>> q;
        
        memset(cnt, 0, sizeof(cnt));
        memset(visit, false, sizeof(visit));

        cin >> n >> x >> y >> nx >> ny;
        visit[x][y] = true;
        q.push(make_pair(x, y));
        
        bfs(q);
        cout << cnt[nx][ny] << '\n';
    }
    
    
    return 0;
}
