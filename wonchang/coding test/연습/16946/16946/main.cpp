//
//  main.cpp
//  16946
//
//  Created by 이원창 on 2021/02/27.
//

#include <iostream>
#include <set>
#include <vector>
#include <cstring>
using namespace std;
int n = 0;
int m = 0;
int arr[1000][1000];
int tmp[1000][1000];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
bool visit[1000][1000];
vector<int> v;
int dfs(int x, int y, int z){
    int num = 1;
    
    tmp[x][y] = z;
    visit[x][y] = true;
    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        if(nx < 0 || ny < 0 || nx >= n || ny >= m)
            continue;
        
        if(!visit[nx][ny] && !arr[nx][ny])
            num += dfs(nx, ny, z);
    }
    
    return num;
}
int main(int argc, const char * argv[]) {
    int idx = 1;
    
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            char tmp;
            
            cin >> tmp;
            arr[i][j] = tmp - '0';
        }
    }
    
    v.push_back(0);
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(arr[i][j] == 0 && !visit[i][j]) {
                v.push_back(dfs(i, j, idx));
                idx++;
            }
        }
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(arr[i][j] == 1) {
                set<int> s;
                for(int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    
                    if (ni < 0 || nj < 0 || ni >= n || nj >= m)
                        continue;
                    
                    s.insert(tmp[ni][nj]);
                }
                
                for(auto k : s){
                    arr[i][j] += v[k];
                }
            }
        }
    }
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << arr[i][j] % 10;
        }
        cout << '\n';
    }
    return 0;
}
