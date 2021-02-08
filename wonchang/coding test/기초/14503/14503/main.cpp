//
//  main.cpp
//  14503
//
//  Created by 이원창 on 2021/02/08.
//

#include <iostream>
#include <queue>
using namespace std;
int ans = 0;
int n, m, r, c, dir;
int arr[50][50];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int dd[4] = {3, 0, 1, 2};
int main(int argc, const char * argv[]) {
    queue<pair<pair<int, int>, int>> q;
    
    cin >> n >> m >> r >> c >> dir;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    q.push(make_pair(make_pair(r, c), dir));
    while(!q.empty()){
        int x = q.front().first.first;
        int y = q.front().first.second;
        int d = q.front().second;
        bool flag = false;

        if(arr[x][y] == 0){
            ans++;
            arr[x][y] = 2;
        }

        q.pop();
        for(int i = 0; i < 4; i++){
            int nd = (d + (3 - i)) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];
                
            if(nx < n && ny < m && nx >= 0 && ny >= 0){
                if(!arr[nx][ny]){
                    flag = true;
                    q.push(make_pair(make_pair(nx, ny), nd));
                    break;
                }
            }
        }
        if(!flag){
            int bx = x - dx[d];
            int by = y - dy[d];

            if(bx >= 0 && by >= 0 && bx < n && by < m){
                if(arr[bx][by] != 1)
                    q.push(make_pair(make_pair(bx, by), d));
                else break;
            }
        }
    }
    
    cout << ans << '\n';
    return 0;
}
