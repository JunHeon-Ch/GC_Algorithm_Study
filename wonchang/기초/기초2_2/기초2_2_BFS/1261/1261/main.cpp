//
//  main.cpp
//  1261
//
//  Created by 이원창 on 2021/01/29.
//

#include <iostream>
#include <queue>
#include <climits>
using namespace std;
queue<pair<int, int>> q;
int main(int argc, const char * argv[]) {
    int n = 0;
    int m = 0;
    int dx[4] = {0, 0, -1, 1};
    int dy[4] = {-1, 1, 0, 0};
    int arr[100][100] = {0, };
    int dis[100][100] = {0, };
    
    cin >> m >> n;
    getchar();
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            char tmp;
            
            cin >> tmp;
            arr[i][j] = tmp - '0';
            dis[i][j] = INT_MAX;
        }
        getchar();
    }
    
    
    dis[0][0] = 1;
    q.push(make_pair(0, 0));
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            
            if(arr[nx][ny] == 1){
                if(dis[nx][ny] > dis[x][y] + 1){
                    dis[nx][ny] = dis[x][y] + 1;
                    q.push(make_pair(nx, ny));
                }
            }
            else{
                if(dis[nx][ny] > dis[x][y]){
                    dis[nx][ny] = dis[x][y];
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }

    cout << dis[n - 1][m - 1] - 1 << '\n';
    return 0;
}
