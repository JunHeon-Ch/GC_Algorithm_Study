//
//  main.cpp
//  14502
//
//  Created by 이원창 on 2021/02/26.
//

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int n = 0;
int m = 0;
int ans = 0;
int zero = 0;
int tmp[8][8];
int arr[8][8];
int virus[8][8];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
void bfs(){
    int zero = 0;
    
    memcpy(virus, tmp, sizeof(tmp));
    queue<pair<int, int>> q;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(arr[i][j] == 2)
                q.push(make_pair(i, j));
        }
    }
    
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n ||ny >= m)
                continue;
            
            if(virus[nx][ny] == 0){
                virus[nx][ny] = 2;
                q.push(make_pair(nx, ny));
            }
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(virus[i][j] == 0)
                zero++;
        }
    }
    ans = max(ans, zero);
}
void go(int cnt){
    if(cnt == 3){
        bfs();
        return;
    }
    else{
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tmp[i][j] == 0){
                    tmp[i][j] = 1;
                    go(cnt + 1);
                    tmp[i][j] = 0;
                }
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(arr[i][j] == 0){
                memcpy(tmp, arr, sizeof(arr));
                tmp[i][j] = 1;
                go(1);
                tmp[i][j] = 0;
            }
        }
    }
    
    cout << ans << '\n';
    return 0;
}
