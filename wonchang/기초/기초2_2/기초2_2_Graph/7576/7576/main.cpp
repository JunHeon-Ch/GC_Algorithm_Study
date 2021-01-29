//
//  main.cpp
//  7576
//
//  Created by 이원창 on 2021/01/28.
//

#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
int n = 0;
int m = 0;
int arr[1000][1000];
int cnt[1000][1000];
queue<pair<int, int>> q;
void bfs(){
    int dx[4] = {0, 0, 1, -1};
    int dy[4] = {1, -1, 0, 0};
    
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= m || ny >= n)
                continue;
            
            if(cnt[nx][ny] == 0 && arr[nx][ny] == 0){
                cnt[nx][ny] = cnt[x][y] + 1;
                q.push(make_pair(nx, ny));
            }
        }
    }
    
}
int main(int argc, const char * argv[]) {
    int ans = 0;
    int flag = 0;
    
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
            if(arr[i][j] == -1)
                cnt[i][j] = -1;
            else if(arr[i][j] == 0)
                flag = 1;
            else{
                q.push(make_pair(i, j));
                cnt[i][j] = 1;
            }
        }
    }
    
    
    if(flag == 0){
        cout << "0\n";
        return 0;
    }
    
    bfs();
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(cnt[i][j] == 0){
                cout << "-1\n";
                return 0;
            }
            ans = max(ans, cnt[i][j]);
        }
    }
    
    cout << ans - 1 << '\n';
    return 0;
}
