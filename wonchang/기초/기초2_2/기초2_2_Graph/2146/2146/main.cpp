//
//  main.cpp
//  2146
//
//  Created by 이원창 on 2021/02/02.
//

#include <iostream>
#include <climits>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
int n = 0;
int arr[100][100];
int dis[100][100];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
bool visit[100][100];
vector<pair<int, int>> v;
void island_num(int a, int b, int num){
    queue<pair<int, int>> q;
    q.push(make_pair(a, b));
    visit[a][b] = true;
    arr[a][b] = num;
    
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;
            
            if(!visit[nx][ny] && arr[nx][ny] == -1){
                visit[nx][ny] = true;
                arr[nx][ny] = num;
                q.push(make_pair(nx, ny));
            }
        }
    }
}
int bfs(int num){
    int ans = INT_MAX;
    queue<pair<int, int>> q;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(arr[i][j] == num){
                visit[i][j] = true;
                q.push(make_pair(i, j));
            }
        }
    }
    
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        for(int j = 0; j < 4; j++){
            int nx = x + dx[j];
            int ny = y + dy[j];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                if (arr[nx][ny] != 0 && arr[nx][ny] != num)
                    ans = min(ans, dis[x][y]);
                else if(!visit[nx][ny] && arr[nx][ny] == 0){
                    visit[nx][ny] = true;
                    dis[nx][ny] = dis[x][y] + 1;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
    
    return ans;
}
int main(int argc, const char * argv[]) {
    int num = 0;
    int ans = INT_MAX;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
            
            if(arr[i][j] == 1){
                v.push_back(make_pair(i, j));
                arr[i][j] = -1;
            }
        }
    }
    
    for(int i = 0; i < v.size(); i++){
        int x = v[i].first;
        int y = v[i].second;
        
        if (!visit[x][y])
            island_num(x, y, ++num);
    }
    
    for(int i = 1; i < num; i++){
        int tmp = bfs(i);

        ans = min(ans, tmp);
        memset(visit, false, sizeof(visit));
        memset(dis, 0, sizeof(dis));
    }
    
    cout << ans << '\n';
    return 0;
}
