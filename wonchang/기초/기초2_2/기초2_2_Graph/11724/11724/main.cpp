//
//  main.cpp
//  11724
//
//  Created by 이원창 on 2021/01/28.
//

#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int n = 0;
int m = 0;
bool visit[1001];
vector<int> v[1001];
void bfs(int start){
    queue<int> q;
    
    q.push(start);
    visit[start] = true;
    while(!q.empty()){
        int tmp = q.front();
        
        q.pop();
        for(int i = 0; i < v[tmp].size(); i++){
            if(!visit[v[tmp][i]]){
                visit[v[tmp][i]] = true;
                q.push(v[tmp][i]);
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    int ans = 0;
    
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    for(int i = 1; i <= n; i++){
        if(!visit[i]){
            bfs(i);
            ans++;
        }
    }

    cout << ans << '\n';
    return 0;
}
