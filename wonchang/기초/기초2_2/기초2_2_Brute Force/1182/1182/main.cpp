//
//  main.cpp
//  1182
//
//  Created by 이원창 on 2021/01/23.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
bool visit[21];
int n = 0;
int s = 0;
int ans = 0;
vector<int> arr;
vector<int> v;
void go(int cnt, int idx, int len){
    if(cnt == len){
        int tmp = 0;
        for(int i = 0; i < len; i++){
            tmp += v[i];
        }
        if(tmp == s)
            ans++;
        
        return;
    }
    
    for(int i = idx; i < arr.size(); i++){
        if(!visit[i]){
            v.push_back(arr[i]);
            visit[i] = true;
            go(cnt + 1, i + 1, len);
            v.pop_back();
            visit[i] = false;
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> s;
    for(int i = 1; i <= n; i++){
        int tmp = 0;
        cin >> tmp;
        arr.push_back(tmp);
    }
    
    sort(arr.begin(), arr.end());
    for(int i = 1; i <= n; i++){
        go(0, 0, i);
    }
    
    cout << ans << '\n';
    return 0;
}
