//
//  main.cpp
//  12946
//
//  Created by 이원창 on 2021/02/26.
//

#include <iostream>
#include <cstring>
using namespace std;
int n = 0;
int ans = 0;
int col[50][50];
int dx[6] = {-1, -1, 0, 1, 1, 0};
int dy[6] = {0, 1, 1, 0, -1, -1};
char arr[50][50];
void go(int sx, int sy, int c){
    col[sx][sy] = c;
    ans = ans > 1 ? ans : 1;
    
    for(int i = 0; i < 6; i++){
        int nx = sx + dx[i];
        int ny = sy + dy[i];
        
        if(nx < 0 || ny < 0 || nx >= n || ny >= n)
            continue;
        
        if(arr[nx][ny] != 'X')
            continue;
        
        if(col[nx][ny] == -1)
            go(nx, ny, 1 - c);
        
        ans = ans < 2 ? 2 : ans;
        if(col[nx][ny] == c)
            ans = ans < 3 ? 3 : ans;
    }
}
int main(int argc, const char * argv[]) {
    
    cin >> n;
    getchar();
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> arr[i][j];
        }
        getchar();
    }
    
    memset(col, -1, sizeof(col));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(arr[i][j] == 'X' && col[i][j] == -1)
                go(i, j, 0);
        }
    }
    
    cout << ans << '\n';
    return 0;
}
