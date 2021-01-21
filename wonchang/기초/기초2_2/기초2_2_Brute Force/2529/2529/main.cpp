//
//  main.cpp
//  2529
//
//  Created by 이원창 on 2021/01/20.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;
int n = 0;
char sign[9];
bool visit[10];
vector<int> v;
vector<string> ans;
void go(int cnt){
    if(cnt == n + 1){
        string tmp = "";
        for(int i = 0; i < v.size(); i++){
            tmp += to_string(v[i]);
        }
        ans.push_back(tmp);
    }
    
    for(int i = 0; i < 10; i++){
        if(!visit[i]){
            if(sign[cnt - 1] == '>' && v[cnt - 1] > i){
                v.push_back(i);
                visit[i] = true;
                go(cnt + 1);
                v.pop_back();
                visit[i] = false;
            }
            else if(sign[cnt - 1] == '<' && v[cnt - 1] < i){
                v.push_back(i);
                visit[i] = true;
                go(cnt + 1);
                v.pop_back();
                visit[i] = false;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n;
    getchar();
    for(int i = 0; i < n; i++){
        cin >> sign[i];
    }

    for(int i = 0; i < 10; i++){
        v.push_back(i);
        visit[i] = true;
        go(1);
        v.pop_back();
        visit[i] = false;
    }
    
    cout << ans[ans.size() - 1] << '\n';
    cout << ans[0] << '\n';
    return 0;
}
