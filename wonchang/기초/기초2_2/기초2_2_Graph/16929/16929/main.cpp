//
//  main.cpp
//  16929
//
//  Created by 이원창 on 2021/01/29.
//

#include <iostream>
using namespace std;
int n = 0;
int m = 0;
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
char arr[50][50];
bool visit[50][50];
bool dfs(int a, int b, int c, int d){
    if(visit[a][b])
        return true;
    
    visit[a][b] = true;
    for(int i = 0; i < 4; i++){
        int x = a + dx[i];
        int y = b + dy[i];
        
        if(!(x == c && y == d)){
            if(x >= 0 && y >= 0 && x < n && y < m && (arr[a][b] == arr[x][y])){
                if(dfs(x, y, a, b))
                    return true;
            }
        }
    }
    
    return false;
}
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    getchar();
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
        getchar();
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(visit[i][j])
                continue;
            if(dfs(i, j, -1, -1)){
                cout << "Yes\n";
                return 0;
            }
        }
    }
    
    cout << "No\n";
    return 0;
}
