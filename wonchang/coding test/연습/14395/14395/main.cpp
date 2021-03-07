//
//  main.cpp
//  14395
//
//  Created by 이원창 on 2021/03/06.
//

#include <iostream>
#include <queue>
#include <cstring>
#include <set>
using namespace std;
long long s = 0;
long long t = 0;
set<long long> visit;
char dx[4] = {'*', '+', '-', '/'};
long long cal(int idx, long long num){
    if(idx == 0)
        return num * num;
    else if(idx == 1)
        return num * 2;
    else if(idx == 2)
        return 0;
    else
        return 1;
}
string bfs(){
    queue<pair<int, string>> q;
    
    q.push({s, ""});
    visit.insert(s);
    while(!q.empty()){
        long long x = q.front().first;
        string op = q.front().second;
        
        if(x == t)
            return op;
        q.pop();
        for(int i = 0; i < 4; i++){
            long long nx = cal(i, x);
            string nop = op + dx[i];
                        
            if(nx > 1000000000 || nx < 0)
                continue;

            if(visit.find(nx) == visit.end()){
                visit.insert(nx);
                q.push({nx, nop});
            }
        }
    }
    
    return "-1";
}
int main(int argc, const char * argv[]) {
    cin >> s >> t;
    
    if(s == t){
        cout << "0\n";
        return 0;
    }
    
    cout << bfs() << '\n';
    return 0;
}
