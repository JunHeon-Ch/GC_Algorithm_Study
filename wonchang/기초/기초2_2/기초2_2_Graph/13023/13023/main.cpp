//
//  main.cpp
//  13023
//
//  Created by 이원창 on 2021/01/25.
//

#include <iostream>
#include <vector>
using namespace std;
int n = 0;
int m = 0;
bool ans = false;
bool visit[2000];
vector<int> v[2000];
void go(int cnt, int idx){
    if(cnt == 5)
        ans = true;
    
    visit[idx] = true;
    for(int i = 0; i < v[idx].size(); i++){
        if(!visit[v[idx][i]])
            go(cnt + 1, v[idx][i]);
        
        if(ans)
            return;
    }
    visit[idx] = false;
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int tmp = 0;
        int tmp2 = 0;
        cin >> tmp >> tmp2;
        v[tmp].push_back(tmp2);
        v[tmp2].push_back(tmp);
    }
    
    for(int i = 0; i < n; i++){
        go(1, i);
        if(ans){
            cout << "1\n";
            return 0;
        }
    }
    
    cout << "0\n";
    return 0;
}
