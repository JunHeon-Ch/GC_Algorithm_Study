//
//  main.cpp
//  16974
//
//  Created by 이원창 on 2021/02/01.
//

#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
bool flag = false;
bool visit[3001];
bool check[3001];
vector<int> v[3001];
vector<int> ans;
void dfs(int idx, int start, int cnt){
    if(idx == start && cnt >= 2){
        flag = true;
    return;
    }
    
    visit[idx] = true;
    for(int i = 0; i < v[idx].size(); i++){
        int next = v[idx][i];
        if(!visit[next])
            dfs(next, start, cnt + 1);
        else{
            if(next == start && cnt >= 2)
                dfs(next, start, cnt);
        }
        
        if(flag)
            return;
    }
}
int bfs(int num){
    int cnt = 0;
    queue<pair<int, int>> q;
    memset(visit, false, sizeof(visit));


    q.push(make_pair(num, 0));
    visit[num] = true;
    while(!q.empty()){
        int x = q.front().first;
        cnt = q.front().second;
        
        q.pop();
        if(check[x])
            return cnt;
        
        for(int i = 0; i < v[x].size(); i++){
            int nx = v[x][i];
            if(!visit[nx]){
                visit[nx] = true;
                q.push(make_pair(nx, cnt + 1));
            }
        }
    }
    
    return cnt;
}
int main(int argc, const char * argv[]) {
    int n = 0;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        int a, b;
        
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    for(int i = 1; i <= n; i++){
        memset(visit, false, sizeof(visit));
        flag = false;
        
        dfs(i, i, 0);
        if(flag)
            check[i] = true;
    }
    
    for(int i = 1; i <= n; i++){
        if(check[i])
            ans.push_back(0);
        else
            ans.push_back(bfs(i));
    }
    
    for(int i = 0; i < ans.size(); i++){
        cout << ans[i] << ' ';
    }
    cout << '\n';
    
    return 0;
}
