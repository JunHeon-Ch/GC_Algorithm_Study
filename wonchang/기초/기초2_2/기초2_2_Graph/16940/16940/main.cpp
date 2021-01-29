//
//  main.cpp
//  16940
//
//  Created by 이원창 on 2021/01/29.
//

#include <iostream>
#include <vector>
#include <queue>
#define SIZE 100001
using namespace std;
vector<int> v[SIZE];
queue<int> q;
bool visit[SIZE];
int num[SIZE], n, start[SIZE];
int bfs() {
    bool flag;
    while(!q.empty()){
        int x = q.front();
        
        q.pop();
        for(int i = start[x]; i < start[x + 1]; i++){
            flag = false;
            for(int j = 0; j < v[x].size(); j++){
                if(!visit[v[x][j]]){
                    if (num[j] == v[x][j]){
                        visit[v[x][j]] = true;
                        q.push(v[x][j]);
                        flag = true;
                    }
                }
            }
            if(!flag)
                return 0;
        }
    }
    return 1;
}
int main(int argc, const char * argv[]){
    cin >> n;
    
    for(int i = 0; i < n - 1; i++){
        int a = 0;
        int b = 0;

        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    for(int i = 1; i <= n; i++){
        cin >> num[i];
    }

    start[0] = 1;
    visit[num[1]] = true;
    for(int i = 1; i < n; i++){
        start[i] = start[i - 1];
        for(int j = 0; j < v[num[i]].size(); j++){
            if (!visit[v[num[i]][j]]) {
                start[i]++;
                visit[v[num[i]][j]] = true;
            }
        }
    }
    
    for(int i = 0; i < n; i++){
        cout << start[i] << ' ';
    }

    memset(visit, false, sizeof(visit));
//    cout << bfs() << '\n';
    return 0;
}
