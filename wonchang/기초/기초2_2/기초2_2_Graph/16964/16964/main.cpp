//
//  main.cpp
//  16964
//
//  Created by 이원창 on 2021/02/01.
//

#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
int order[100001];
bool visit[100001];
vector<int> d;
vector<int> v[100001];
void dfs(int x) {
    visit[x] = true;
    d.push_back(x);
    for (int i = 0; i < v[x].size(); i++) {
        if(!visit[v[x][i]])
            dfs(v[x][i]);
    }
}

int main(void) {
    int n = 0;
    vector<int> ans;
    
    cin >> n;
    for(int i = 0; i < n - 1; i++){
        int x, y;
        
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }
    
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        ans.push_back(x);
        order[x] = i;
    }
    
    for(int i = 1; i <= n; i++){
        sort(v[i].begin(), v[i].end(), [](const int &u, const int &v) {
            return order[u] < order[v];
        });
    }
    
    dfs(1);
    
    if(d == ans)
        cout << "1\n";
    else
        cout << "0\n";
    return 0;
}
