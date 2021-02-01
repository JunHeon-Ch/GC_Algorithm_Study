//
//  main.cpp
//  1967
//
//  Created by 이원창 on 2021/02/01.
//

#include <iostream>
#include <vector>
using namespace std;
int ans = 0;
int root = 0;
bool visit[10001];
vector<pair<int, int>> v[10001];
void dfs(int idx, int dis){
    if(visit[idx])
        return;
    
    visit[idx] = true;
    for(int i = 0; i < v[idx].size(); i++){
        int next = v[idx][i].first;
        if(!visit[next]){
            int nd = dis + v[idx][i].second;
            dfs(next, nd);
            if(ans < nd){
                ans = nd;
                root = next;
            }
        }
    }
    visit[idx] = false;
}
int main(int argc, const char * argv[]) {
    int n = 0;
    
    cin >> n;
    for(int i = 1; i < n; i++){
        int a, b, c;
        
        cin >> a >> b >> c;
        v[a].push_back(make_pair(b, c));
        v[b].push_back(make_pair(a, c));
    }
    
    dfs(1, 0);
    ans = 0;
    dfs(root, 0);
    
    cout << ans << '\n';
    
    return 0;
}
