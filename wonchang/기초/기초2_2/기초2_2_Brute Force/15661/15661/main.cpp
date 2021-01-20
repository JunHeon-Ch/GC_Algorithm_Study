//
//  main.cpp
//  15661
//
//  Created by 이원창 on 2021/01/20.
//
#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
using namespace std;
int n = 0;
int ans = INT_MAX;
int team[20] = {0, };
int arr[20][20] = {0, };
bool visit[20];
void go(int cnt){
    if(cnt == n / 2){
        int start = 0;
        int link = 0;
        vector<int> s;
        vector<int> l;
        for(int i = 0; i < n; i++){
            if(visit[i])
                s.push_back(i);
            else
                l.push_back(i);
        }
        for(int i = 0; i < s.size(); i++){
            for(int j = i + 1; j < s.size(); j++){
                start += (arr[s[i]][s[j]] + arr[s[j]][s[i]]);
            }
        }
        for(int i = 0; i < l.size(); i++){
            for(int j = i + 1; j < l.size(); j++){
                link += (arr[l[i]][l[j]] + arr[l[j]][l[i]]);
            }
        }
        ans = min(ans, abs(start - link));
    }
    
    for(int i = 0; i < n; i++){
        if(!visit[i] && team[cnt - 1] < i){
            team[cnt] = i;
            visit[i] = true;
            go(cnt + 1);
            team[cnt] = i;
            visit[i] = false;
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        team[0] = i;
        visit[i] = true;
        go(1);
        team[0] = i;
        visit[i] = false;
    }
    
    cout << ans << '\n';
    return 0;
}
