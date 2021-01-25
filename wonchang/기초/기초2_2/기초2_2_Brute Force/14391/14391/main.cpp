//
//  main.cpp
//  14391
//
//  Created by 이원창 on 2021/01/23.
//

#include <iostream>
#include <algorithm>
using namespace std;
int n = 0;
int m = 0;
int ans = 0;
int arr[4][4];
bool visit[4][4];
void go(int cnt, int sum){
    int r = cnt % m;
    int c = cnt / m;
    if(cnt >= n * m){
        ans = max(ans, sum);
        return;
    }
    if(visit[c][r])
        go(cnt + 1, sum);
    else{
        int tmp = 0;
        tmp = arr[c][r];
        visit[c][r] = true;
        go(cnt + 1, sum + tmp);
        visit[c][r] = false;
        for(int i = 1; i < n - c; i++){
            int x = r;
            int y = c + i;
            tmp *= 10;
            tmp += arr[y][x];
            for(int j = 1; j <= i; j++){
                visit[c + j][x] = true;
            }
            go(cnt + 1, sum + tmp);
            for(int j = 1; j <= i; j++){
                visit[c + j][x] = false;
            }
        }
        tmp = arr[c][r];
        
        for (int i = 1; i < m - r; i++) {
            int x = r + i;
            int y = c;
            if (visit[y][x])
                return;
            tmp *= 10;
            tmp += arr[y][x];
            for(int j = 1; j <= i; j++){
                visit[y][r + j] = true;
            }
            go(cnt + 1, sum + tmp);
            for (int j = 1; j <= i; j++){
                visit[y][r + j] = false;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            char tmp;
            cin >> tmp;
            arr[i][j] = tmp - '0';
        }
    }
    
    go(0, 0);
    cout << ans << '\n';
    return 0;
}

