//
//  main.cpp
//  1707
//
//  Created by 이원창 on 2021/01/28.
//

#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
int k = 0;
int v = 0;
int e = 0;
bool color[20001];
bool visit[20001];
vector<int> arr[20001];
void bfs(int start){
    queue<int> q;
    
    q.push(start);
    visit[start] = true;
    while(!q.empty()){
        int tmp = q.front();
        q.pop();
        for(int l = 0; l < arr[tmp].size(); l++){
            int next = arr[tmp][l];
            if(!visit[next]){
                q.push(next);
                color[next] = !color[tmp];
                visit[next] = true;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> k;
    
    while(k--){
        cin >> v >> e;
        for(int i = 0; i < e; i++){
            int a = 0;
            int b = 0;
            
            cin >> a >> b;
            arr[a].push_back(b);
            arr[b].push_back(a);
        }
        
        bool flag = true;
        memset(color, false, sizeof(color));
        memset(visit, false, sizeof(visit));
        for(int i = 1; i <= v; i++){
            if(!visit[i])
                bfs(i);
        }

        for(int i = 1; i <= v; i++){
            for(int j = 0; j < arr[i].size(); j++){
                if(color[i] == color[arr[i][j]])
                    flag = false;
            }
        }

        if(flag)
            cout << "YES\n";
        else
            cout << "NO\n";
        
        for(int i = 1; i <= v; i++){
            arr[i].clear();
        }
    }
    return 0;
}
