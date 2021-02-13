//
//  main.cpp
//  9663
//
//  Created by 이원창 on 2021/02/13.
//

#include <iostream>
#include <queue>
using namespace std;
int n = 0;
int ans = 0;
int col[15];
bool visit[15][15];
bool check(int c){
    for(int i = 1; i < c; i++){
        if(col[i] == col[c])
            return false;
        if(abs(col[i] - col[c]) == abs(i - c))
            return false;
    }
    return true;
}
void go(int cnt){
    if(cnt == n)
        ans++;
    else{
        for(int i = 0; i < n; i++){
            col[cnt + 1] = i;
            if(check(cnt + 1))
                go(cnt + 1);
            else
                col[cnt + 1] = 0;
        }
    }
    col[cnt] = 0;
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        col[1] = i;
        go(1);
    }
    
    cout << ans << '\n';
    return 0;
}
