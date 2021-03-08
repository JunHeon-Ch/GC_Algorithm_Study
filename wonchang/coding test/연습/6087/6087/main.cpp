//
//  main.cpp
//  6087
//
//  Created by 이원창 on 2021/03/04.
//

#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
using namespace std;
int n = 0;
int m = 0;
int cnt[100][100];
char arr[100][100];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
struct Info{
    int x;
    int y;
    int dir;
    int cnt;
};
queue<Info> q;
vector<pair<int, int>> v;
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    getchar();
    
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
            cnt[i][j] = 10000;
            if(arr[i][j] == 'C'){
                v.push_back({i, j});
                arr[i][j] = '.';
            }
        }
        getchar();
    }

    q.push({v[0].first, v[0].second, -1, 0});
    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int d = q.front().dir;
        int c = q.front().cnt;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            
            if(arr[nx][ny] == '*')
                continue;
            
            if(arr[nx][ny] == '.'){
                int nc = c;
                
                if(d != -1 && d != i)
                    nc = c + 1;
                
                if(cnt[nx][ny] >= nc){
                    cnt[nx][ny] = nc;
                    q.push(Info{nx, ny, i, nc});
                }
            }
        }
    }
    
    cout << cnt[v[1].first][v[1].second] << '\n';
    return 0;
}
