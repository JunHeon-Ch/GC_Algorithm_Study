//
//  main.cpp
//  16928
//
//  Created by 이원창 on 2021/02/26.
//

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int m = 0;
    int arr[101] = {0, };
    int ans[101] = {0, };
    bool visit[101] = {false, };
    
    memset(visit, false, sizeof(visit));
    queue<int> q;
    
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        arr[a] = b;
    }
    
    for(int i = 0; i < m; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        arr[a] = b;
    }
    
    q.push(1);
    visit[1] = true;
    while(!q.empty()){
        int x = q.front();
        
        q.pop();
        for(int i = 1; i <= 6; i++){
            int nx = x + i;

            if(nx > 100)
                continue;
            
            if(arr[nx] != 0)
                nx = arr[nx];

            if(!visit[nx]){
                q.push(nx);
                ans[nx] = ans[x] + 1;
                visit[nx] = true;
            }
        }
    }
    
    cout << ans[100] << '\n';
    return 0;
}
