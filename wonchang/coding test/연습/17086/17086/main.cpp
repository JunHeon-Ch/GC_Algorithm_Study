//
//  main.cpp
//  17086
//
//  Created by 이원창 on 2021/03/08.
//

#include <iostream>
#include <queue>
#include <vector>
#include <climits>
using namespace std;
int n = 0;
int m = 0;
int arr[50][50];
int dx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
queue<pair<int, int>> q;
void bfs(){
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            
            if(arr[nx][ny] == 0){
                q.push({nx, ny});
                arr[nx][ny] = arr[x][y] + 1;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
            
            if(arr[i][j] == 1)
                q.push({i, j});
        }
    }

    bfs();
    int ans = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            ans = max(ans, arr[i][j]);
        }
    }
    
    cout << ans - 1 << '\n';
    return 0;
}
