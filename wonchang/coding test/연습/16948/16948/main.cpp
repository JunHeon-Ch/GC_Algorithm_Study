//
//  main.cpp
//  16948
//
//  Created by 이원창 on 2021/02/26.
//

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int sx, sy, fx, fy;
    int dx[6] = {-2, -2, 0, 0, 2, 2};
    int dy[6] = {-1, 1, -2, 2, -1, 1};
    int arr[200][200] = {0, };
    bool visit[200][200];
    queue<pair<int, int>> q;
    
    cin >> n >> sx >> sy >> fx >> fy;
    
    memset(visit, false, sizeof(visit));
    q.push(make_pair(sx, sy));
    visit[sx][sy] = true;
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 6; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;
            
            if(!visit[nx][ny]){
                visit[nx][ny] = true;
                arr[nx][ny] = arr[x][y] + 1;
                q.push(make_pair(nx, ny));
            }
        }
    }
    
    if(arr[fx][fy] == 0)
        arr[fx][fy] = -1;
    
    cout << arr[fx][fy] << '\n';
    return 0;
}
