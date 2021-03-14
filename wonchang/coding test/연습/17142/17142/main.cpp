//
//  main.cpp
//  17142
//
//  Created by 이원창 on 2021/03/14.
//

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <cstring>
#include <algorithm>
using namespace std;
int n, m;
int total = 0;
int ans = INT_MAX;
int arr[50][50];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
vector<pair<int, int>> v;
vector<pair<int, int>> virus;
queue<pair<int, int>> q;
void bfs(){
    int cnt = 0;
    int tmp = 0;
    int visit[50][50];

    memset(visit, -1, sizeof(visit));
    for(int i = 0; i < virus.size(); i++){
        q.push({virus[i].first, virus[i].second});
        visit[virus[i].first][virus[i].second] = 0;
    }
    
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;
            
            if(visit[nx][ny] == -1 && arr[nx][ny] != 1){
                q.push({nx, ny});
                visit[nx][ny] = visit[x][y] + 1;
                if(arr[nx][ny] == 0){
                    tmp = visit[nx][ny];
                    cnt++;
                }
            }
        }
    }

    if(total == cnt)
        ans = min(ans, tmp);
}
int main(int argc, const char * argv[]) {
    queue<pair<int, int>> emp;
    cin >> n >> m;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
            
            if(arr[i][j] == 2)
                v.push_back({i, j});
            
            if(arr[i][j] == 0)
                total++;
        }
    }
    
    vector<int> idx;
    for(int i = 0; i < m; i++){
        idx.push_back(1);
    }
    
    for(int i = 0; i< v.size() - m; i++){
        idx.push_back(0);
    }
    
    sort(idx.begin(), idx.end());
    do{
        virus.clear();
        for(int i = 0; i < idx.size(); i++){
            if(idx[i] == 1){
                virus.push_back({v[i].first, v[i].second});
            }
        }
        
        bfs();
    }while(next_permutation(idx.begin(), idx.end()));
    
    if(ans == INT_MAX)
        cout << "-1\n";
    else
        cout << ans << '\n';
    
    return 0;
}
