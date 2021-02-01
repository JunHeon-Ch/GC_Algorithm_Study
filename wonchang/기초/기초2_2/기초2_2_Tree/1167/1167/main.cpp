//
//  main.cpp
//  1167
//
//  Created by 이원창 on 2021/02/01.
//

#include <iostream>
#include <vector>
#include <cstring>
using namespace std;
int n = 0;
int ans = 0;
int root = 0;
bool visit[100001];
vector<pair<int, int>> v[100001];
void dfs(int idx, int dis){
    if(visit[idx])
        return;

    visit[idx] = true;
    for(int i = 0; i < v[idx].size(); i++){
        if(!visit[v[idx][i].first]){
            dfs(v[idx][i].first, dis + v[idx][i].second);
            if(ans < dis + v[idx][i].second){
                ans = dis + v[idx][i].second;
                root = v[idx][i].first;
            }
        }
    }
    visit[idx] = false;
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        int a, node, dis;
        cin >> a >> node;
        while(node != -1){
            cin >> dis;
            v[a].push_back(make_pair(node, dis));
            cin >> node;
        }
    }
    
    dfs(1, 0);
    ans = 0;
    memset(visit, false, sizeof(visit));
    
    dfs(root, 0);
    cout << ans << '\n';
    return 0;
}
