//
//  main.cpp
//  17299
//
//  Created by 이원창 on 2020/12/24.
//

#include <iostream>
#include <vector>
#include <stack>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n = 0;
    int cnt[1000001] = {0, };
    vector<int> v;
    stack<int> s;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        int temp = 0;
        cin >> temp;
        v.push_back(temp);
        cnt[temp]++;
    }

    vector <int> ans(v.size(), -1);
    for(int i = 0; i < v.size(); i++) {
        while(!s.empty() && cnt[v[s.top()]] < cnt[v[i]]) {
            ans[s.top()] = v[i];
            s.pop();
        }
        s.push(i);
    }

    for(int i = 0; i < ans.size(); i++){
        cout << ans[i] << ' ';
    }
    return 0;
}
