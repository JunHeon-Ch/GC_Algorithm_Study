//
//  main.cpp
//  1697
//
//  Created by 이원창 on 2021/01/29.
//

#include <iostream>
#include <queue>
using namespace std;
bool visit[100001];
int cnt[100001];
queue<int> q;
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
            if(i == 2)
                nx = x * dx[i];
            else
                nx = x + dx[i];
            
            if(nx < 0 || nx > 100000)
                continue;
            
            if(!visit[nx]){
                cnt[nx] = cnt[x] + 1;
                visit[nx] = true;
                q.push(nx);
            }
        }
    }
    
    cout << cnt[k] << '\n';;
    return 0;
}
