//
//  main.cpp
//  15663
//
//  Created by 이원창 on 2021/01/19.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
using namespace std;
int ans[8];
int arr[8];
bool visit[8];
vector<int> v;
set<vector<int>> s;
void go(int n, int m, int cnt){
    if(cnt == m){
        s.insert(v);
        return;
    }
    for(int i = 0; i < n; i++){
        if(!visit[i]){
            visit[i] = true;
            v.push_back(arr[i]);
            go(n, m, cnt + 1);
            visit[i] = false;
            v.pop_back();
        }
        
    }
}
int main(int argc, const char * argv[]) {
    int n = 0;
    int m = 0;
    
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    sort(arr, arr + n);
    go(n, m, 0);
    
    for(auto tmp : s){
        for(int i = 0; i < tmp.size(); i++){
            cout << tmp[i] << ' ';
        }
        cout << '\n';
    }

    return 0;
}
