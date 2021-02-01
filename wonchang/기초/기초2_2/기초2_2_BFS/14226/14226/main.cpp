//
//  main.cpp
//  14226
//
//  Created by 이원창 on 2021/02/01.
//

#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
int s = 0;
void bfs(){
    bool visit[2000][2000];
    queue<pair<pair<int, int>, int>> q;

    visit[1][0] = true;
    q.push(make_pair(make_pair(1, 0), 0));
    while(!q.empty()){
        int m = q.front().first.first;
        int c = q.front().first.second;
        int cnt = q.front().second;
        
        q.pop();
        if(m == s){
            cout << cnt << '\n';
            return;
        }
        
        if(m > 0 && m < 2000){
            if(!visit[m][m]){
                visit[m][m] = true;
                q.push(make_pair(make_pair(m, m), cnt + 1));
            }
            
            if(!visit[m - 1][c]){
                visit[m - 1][c] = true;
                q.push(make_pair(make_pair(m - 1, c), cnt + 1));
            }
        }

        if(c > 0 && m + c < 2000){
            if(!visit[m + c][c]){
                visit[m + c][c] = true;
                q.push(make_pair(make_pair(m + c, c), cnt + 1));
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> s;
    bfs();
    return 0;
}
