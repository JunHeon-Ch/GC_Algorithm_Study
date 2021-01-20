//
//  main.cpp
//  10974
//
//  Created by 이원창 on 2021/01/19.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
bool visit[9];
vector<int> v;
void go(int n, int cnt){
    if(cnt == n){
        for(int i = 0; i < n; i++){
            cout << v[i] << ' ';
        }
        cout << '\n';
    }
    for(int i = 1; i <= n; i++){
        if(!visit[i]){
            visit[i] = true;
            v.push_back(i);
            go(n, cnt + 1);
            visit[i] = false;
            v.pop_back();
        }
    }
}
int main(int argc, const char * argv[]) {
    int n = 0;
    
    cin >> n;
    go(n, 0);
    return 0;
}
