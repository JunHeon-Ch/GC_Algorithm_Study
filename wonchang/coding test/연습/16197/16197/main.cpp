//
//  main.cpp
//  16197
//
//  Created by 이원창 on 2021/02/11.
//

#include <iostream>
#include <vector>
#include <climits>
using namespace std;
int n = 0;
int m = 0;
int ans = INT_MAX;
char arr[20][20];
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
vector<pair<int, int>> v;
void dfs(pair<int, int> a, pair<int, int> b, int cnt){
    if(cnt > 10)
        return;
    
    for(int i = 0; i < 4; i++){
        int ax = a.first + dx[i];
        int ay = a.second + dy[i];
        
        int bx = b.first + dx[i];
        int by = b.second + dy[i];
    
        bool flagA = false;
        bool flagB = false;
        
        if(ax < 0 || ay < 0 || ax >= n || ay >= m)
            flagA = true;
        
        if(bx < 0 || by < 0 || bx >= n || by >= m)
            flagB = true;

        if(flagA != flagB)
            ans = min(ans, cnt);
        
        if(flagA || flagB)
            continue;
        
        if(arr[ax][ay] == '#'){
            ax = a.first;
            ay = a.second;
        }
        
        if(arr[bx][by] == '#'){
            bx = b.first;
            by = b.second;
        }
        
        dfs(make_pair(ax, ay), make_pair(bx, by), cnt + 1);
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
            if(arr[i][j] == 'o'){
                v.push_back(make_pair(i, j));
                arr[i][j] = '.';
            }
        }
    }
    
    dfs(v[0], v[1], 1);
    
    if(ans > 10)
        cout << "-1\n";
    else
        cout << ans << '\n';
    
    return 0;
}
