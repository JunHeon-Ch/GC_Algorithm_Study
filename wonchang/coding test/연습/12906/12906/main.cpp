//
//  main.cpp
//  12906
//
//  Created by 이원창 on 2021/03/14.
//

#include <iostream>
#include <queue>
#include <array>
#include <map>
using namespace std;
int main(int argc, const char * argv[]) {
    int cnt[3];
    int ans_cnt[3] = {0, };
    array<string, 3> str;
    array<string, 3> ans;
    map<array<string, 3>, int> m;
    queue<array<string, 3>> q;

    for(int i = 0; i < 3; i++){
        cin >> cnt[i];
        if(cnt[i] == 0)
            str[i] = "";
        else
            cin >> str[i];
    }
    
    for(int i = 0; i < 3; i++){
        for (int j = 0; j < cnt[i]; j++) {
            ans_cnt[str[i][j] - 'A']++;
        }
    }
    
    q.push(str);
    m[str] = 0;
    while(!q.empty()){
        auto x = q.front();
        q.pop();
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j)
                    continue;
                
                if(x[i].length() == 0)
                    continue;
                
                auto nx = x;
                nx[j].push_back(nx[i].back());
                nx[i].pop_back();
                
                if(m.count(nx) == 0){
                    m[nx] = m[x] + 1;
                    q.push(nx);
                }
            }
        }
    }
    
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < ans_cnt[i]; j++){
            ans[i] += 'A' + i;
        }
    }

    cout << m[ans] << '\n';
    return 0;
}
