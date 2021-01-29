//
//  main.cpp
//  1260
//
//  Created by 이원창 on 2021/01/28.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
int n = 0;
int m = 0;
int v = 0;
bool visit[1001];
vector<int> arr[1001];
vector<int> d;
vector<int> b;
void dfs(int start){
    visit[start] = true;
    cout << start << ' ';
    
    for(int i = 0; i < arr[start].size(); i++){
        if(!visit[arr[start][i]])
            dfs(arr[start][i]);
    }
}
void bfs(int start){
    queue<int> q;

    q.push(start);
    visit[start] = true;
    while(!q.empty()){
        int tmp = q.front();
        cout << tmp << ' ';
        q.pop();
        
        for(int i = 0; i < arr[tmp].size(); i++){
            if(!visit[arr[tmp][i]]){
                visit[arr[tmp][i]] = true;
                q.push(arr[tmp][i]);
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m >> v;
    for(int i = 0; i < m; i++){
        int tmp = 0;
        int tmp2 = 0;
        
        cin >> tmp >> tmp2;
        arr[tmp].push_back(tmp2);
        arr[tmp2].push_back(tmp);
    }
    
    for(int i = 1; i <= n; i++){
        sort(arr[i].begin(), arr[i].end());
    }

    dfs(v);
    cout << '\n';

    memset(visit, false, sizeof(visit));
    bfs(v);
    cout << '\n';
    
    return 0;
}
