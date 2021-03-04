//
//  main.cpp
//  1963
//
//  Created by 이원창 on 2021/03/04.
//

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int t = 0;
int cnt[10000];
bool p[10000];
int to_int(string num){
    int result = 0;
    for(int i = 0; i < 4; i++){
        result = 10 * result + (num[i] - '0');
    }
    
    return result;
}
void bfs(int start, int end){
    queue<int> q;
    
    q.push(start);
    cnt[start] = 0;
    while(!q.empty()){
        int x = q.front();
        
        q.pop();
        for(int i = 0; i < 4; i++){
            string tmp = to_string(x);
            for(int j = 0; j < 10; j++){
                tmp[i] = j + '0';
                int nx = to_int(tmp);

                if(nx < 1000)
                    continue;
                
                if(cnt[nx] != -1)
                    continue;
                
                if(p[nx]){
                    cnt[nx] = cnt[x] + 1;
                    if(nx == end)
                        return;
                    q.push(nx);
                }
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    memset(p, true, sizeof(p));
    for(int i = 2; i * i < 10000; i++){
        for(int j = i * i; j < 10000; j += i){
            p[j] = false;
        }
    }
    
    for(int i = 0; i < t; i++){
        int a = 0;
        int b = 0;
        memset(cnt, -1, sizeof(cnt));

        cin >> a >> b;
        bfs(a, b);
        
        if(cnt[b] == -1)
            cout << "Impossible\n";
        else
            cout << cnt[b] << '\n';
    }
    return 0;
}
