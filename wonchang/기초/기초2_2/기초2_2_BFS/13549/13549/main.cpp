//
//  main.cpp
//  13549
//
//  Created by 이원창 on 2021/01/29.
//

#include <iostream>
#include <queue>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int k = 0;
    int dx[3] = {2, -1, 1};
    int cnt[100001] = {0, };
    bool visit[100001];
    queue<int> q;
    
    cin >> n >> k;
    q.push(n);
    visit[n] = true;
    while(!q.empty()){
        int x = q.front();
        int nx = 0;
        
        q.pop();
        for(int i = 0; i < 3; i++){
            if(i != 0)
                nx = x + dx[i];
            else
                nx = x * dx[i];
            
            if(nx < 0 || nx > 100000)
                continue;
            
            if(!visit[nx]){
                q.push(nx);
                visit[nx] = true;
                
                if(i == 0)
                    cnt[nx] = cnt[x];
                else
                    cnt[nx] = cnt[x] + 1;
            }
            
        }
    }
    
    cout << cnt[k] << '\n';
    return 0;
}
