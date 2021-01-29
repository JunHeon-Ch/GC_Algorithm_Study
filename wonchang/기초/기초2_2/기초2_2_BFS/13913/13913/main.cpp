//
//  main.cpp
//  13913
//
//  Created by 이원창 on 2021/01/29.
//

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
bool visit[100001];
int cnt[100001];
int route[100001];
queue<int> q;
vector<int> v;
int main(int argc, const char * argv[]) {
    int n = 0;
    int k = 0;
    int dx[3] = {-1, 1, 2};
    
    cin >> n >> k;
    q.push(n);
    visit[n] = true;
    while(!q.empty()){
        int x = q.front();
        int nx = 0;
        
        q.pop();
        for(int i = 0; i < 3; i++){
            if(i != 2)
                nx = x + dx[i];
            else
                nx = x * dx[i];
            
            if(nx < 0 || nx > 100000)
                continue;
            
            if(!visit[nx]){
                visit[nx] = true;
                cnt[nx] = cnt[x] + 1;
                route[nx] = x;
                q.push(nx);
            }
        }
    }
    
    v.push_back(k);
    int cur = k;
    while(cur != n){
        cur = route[cur];
        v.push_back(cur);
    }
    reverse(v.begin(), v.end());
    
    cout << cnt[k] << '\n';
    for(int i = 0; i < v.size(); i++){
        cout << v[i] << ' ';
    }
    cout << '\n';
    
    return 0;
}
