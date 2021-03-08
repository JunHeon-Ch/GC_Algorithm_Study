//
//  main.cpp
//  5014
//
//  Created by 이원창 on 2021/03/07.
//

#include <iostream>
#include <queue>
#include <set>
using namespace std;
int f, s, g, u, d = 0;
int ans = 0;
int dx[2] = {0, };
set<int> visit;
queue<pair<int, int>> q;
int bfs(int s){
    q.push({s, 0});
    visit.insert(s);
    while(!q.empty()){
        int x = q.front().first;
        int dis = q.front().second;
        
        if(x == g)
            return dis;
        q.pop();
        for(int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int nd = dis;
                        
            if(nx <= 0 || nx > f)
                continue;
            
            if(visit.find(nx) == visit.end()){
                visit.insert(nx);
                nd = dis + 1;
                q.push({nx, dis + 1});
            }
        }
    }

    return -1;
}
int main(int argc, const char * argv[]) {
    cin >> f >> s >> g >> u >> d;
    
    dx[0] = u;
    dx[1] = -d;
    
    
    
    ans = bfs(s);
    if(ans != -1)
        cout << ans << '\n';
    else
        cout << "use the stairs\n";
    return 0;
}
