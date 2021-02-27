//
//  main.cpp
//  16954
//
//  Created by 이원창 on 2021/02/28.
//

#include <iostream>
#include <queue>
#include <tuple>
using namespace std;
string arr[8];
bool visit[8][8][9];
int dx[9] = {0, 0, 0, 1, 1, 1, -1, -1, -1};
int dy[9] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
int bfs(){
    queue<tuple<int, int, int>> q;
    
    q.push({7, 0, 0});
    visit[7][0][0] = true;
    
    while(!q.empty()){
        int x = 0;
        int y = 0;
        int d = 0;
        
        tie(x, y, d) = q.front();
        if(x == 0 && y == 7)
            return 1;
        
        q.pop();
        for(int i = 0; i < 9; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nd = min(d + 1, 8);
            
            if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8)
                continue;
                
            if(nx - d >= 0 && arr[nx - d][ny] == '#')
                continue;
            
            if(nx - d - 1 >= 0 && arr[nx - d - 1][ny] == '#')
                continue;
            
            if(!visit[nx][ny][nd]){
                visit[nx][ny][nd] = true;
                q.push({nx, ny, nd});
            }
        }
    }
    
    return 0;
}
int main(int argc, const char * argv[]) {
    for(int i = 0; i < 8; i++){
        cin >> arr[i];
    }
    
    cout << bfs() << '\n';
    return 0;
}
