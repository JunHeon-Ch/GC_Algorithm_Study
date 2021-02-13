//
//  main.cpp
//  16198
//
//  Created by 이원창 on 2021/02/13.
//

#include <iostream>
#include <vector>
using namespace std;
int n = 0;
int ans = 0;
int arr[10];
vector<int> v;
void dfs(int cnt, int sum){
    ans = max(ans, sum);
    if(v.size() < 3)
        return;
    
    for(int i = 1; i < v.size() - 1; i++){
        int tmp = v[i];
        
        v.erase(v.begin() + i);
        dfs(cnt + 1, sum + v[i - 1] * v[i]);
        v.insert(v.begin() + i, tmp);
    }
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        int tmp = 0;
        
        cin >> tmp;
        v.push_back(tmp);
    }
    
    dfs(0, 0);
    cout << ans << '\n';
    return 0;
}
