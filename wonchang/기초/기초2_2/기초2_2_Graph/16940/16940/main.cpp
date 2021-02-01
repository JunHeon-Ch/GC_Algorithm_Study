//
//  main.cpp
//  16940
//
//  Created by 이원창 on 2021/02/01.
//

#include <iostream>
#include <vector>
#include <queue>
#include <set>
#include <algorithm>
using namespace std;
int n;
int order[100001];
bool visit[100001];
vector<int> v[100001];
queue<int> q;
queue<int> input_q;
bool bfs(){

    int f = input_q.front();
    input_q.pop();
    if(f != 1)
        return false;


    q.push(f);
    visit[f] = true;
    while(!q.empty()){
        int x = q.front();
        
        q.pop();
        set<int> s;
        for (int next : v[x]) {
            if(!visit[next]) {
                s.insert(next);
                visit[next] = true;
            }
        }
        
        for(int i = 0; i < s.size(); i++){
            if(input_q.empty())
                return false;
            
            int node = input_q.front();
            input_q.pop();

            if(s.find(node) == s.end())
                return false;
            else
                q.push(node);
        }
    }
    return true;
  
}
int main() {
    cin >> n;
    
    for(int i = 1; i < n; i++){
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    for(int i = 1; i <= n; i++){
        int tmp = 0;
        
        cin >> tmp;
        input_q.push(tmp);
    }
        cout << bfs() << '\n';;
}
