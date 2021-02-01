//
//  main.cpp
//  11725
//
//  Created by 이원창 on 2021/02/01.
//

#include <iostream>
#include <vector>
using namespace std;
int root[100001] = {-1, -1, };
vector<int> v[100001];
void dfs(int idx){
    if(root[idx] != 0){
        for(int i = 0; i < v[idx].size(); i++){
            if(v[idx][i] != root[idx]){
                root[v[idx][i]] = idx;
                dfs(v[idx][i]);
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    int n = 0;
    
    cin >> n;
    for(int i = 1; i < n; i++){
        int a, b;
        
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    dfs(1);
    
    for(int i = 2; i <= n; i++){
        cout << root[i] << '\n';
    }
    return 0;
}
