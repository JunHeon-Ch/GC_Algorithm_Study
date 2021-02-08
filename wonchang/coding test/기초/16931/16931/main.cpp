//
//  main.cpp
//  16931
//
//  Created by 이원창 on 2021/02/08.
//

#include <iostream>
using namespace std;
int n = 0;
int m = 0;
int arr[100][100];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int go(int x, int y){
    int cnt = 0;
    
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        if(nx >= 0 && ny >= 0 && nx < n && ny < m){
            if(arr[nx][ny] < arr[x][y])
                cnt += (arr[x][y] - arr[nx][ny]);
        }
        else
            cnt += arr[x][y];
    }
    return cnt;
}
int main(int argc, const char * argv[]) {
    int ans = 0;
        
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            ans += go(i, j);
        }
    }
    
    ans += (2 * n * m);
    cout << ans << '\n';
    return 0;
}
