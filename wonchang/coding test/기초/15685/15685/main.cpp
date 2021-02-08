//
//  main.cpp
//  15685
//
//  Created by 이원창 on 2021/02/08.
//

#include <iostream>
#include <vector>
using namespace std;
int nx = 0;
int ny = 0;
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};
bool visit[101][101];
void go(vector<int> &v){
    int size = (int)v.size();
    for(int i = size - 1; i >= 0; i--){
        int dir = (v[i] + 1) % 4;
        
        nx = nx + dx[dir];
        ny = ny + dy[dir];

        if(nx < 0 || ny < 0 || nx >= 101 || ny >= 101)
            continue;
        
        visit[nx][ny] = true;
        v.push_back(dir);
    }
}
int main(int argc, const char * argv[]) {
    int n = 0;
    int ans = 0;
    int x, y, d, g;
    vector<int> v;

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> y >> x >> d >> g;
        
        v.clear();
        visit[x][y] = true;
        
        nx = x + dx[d];
        ny = y + dy[d];
        
        if(nx < 0 || ny < 0 || nx >= 101 || ny >= 101)
            continue;
        
        v.push_back(d);
        visit[nx][ny] = true;
        for(int i = 0; i < g; i++){
            go(v);
        }
    }

    for(int i = 0; i <= 99; i++){
        for(int j = 0; j <= 99; j++){
            if(visit[i][j] && visit[i + 1][j] && visit[i][j + 1] && visit[i + 1][j + 1])
                ans++;
        }
    }
    cout << ans << '\n';
    return 0;
}
