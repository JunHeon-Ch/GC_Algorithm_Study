//
//  main.cpp
//  2667
//
//  Created by 이원창 on 2021/01/28.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
int n = 0;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int arr[25][25];
bool visit[25][25];
int bfs(int x, int y, int cnt){
    queue<pair<int, int>> q;
    
    visit[x][y] = true;
    q.push(make_pair(x, y));
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;
            
            if(!visit[nx][ny] && arr[nx][ny] == 1){
                visit[nx][ny] = true;
                q.push(make_pair(nx, ny));
                cnt++;
            }
        }
    }
    
    return cnt;
}

int main(int argc, const char * argv[]) {
    vector<int> v;
    
    cin >> n;
    getchar();
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            char tmp;
            
            cin >> tmp;
            arr[i][j] = tmp - '0';
        }
        getchar();
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(!visit[i][j] && arr[i][j] == 1)
                v.push_back(bfs(i, j, 1));
        }
    }
    
    cout << v.size() << '\n';
    sort(v.begin(), v.end());
    for(int i = 0; i < v.size(); i++){
        cout << v[i] << '\n';
    }
    return 0;
}
