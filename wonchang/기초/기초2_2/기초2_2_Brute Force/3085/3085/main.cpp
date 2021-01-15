//
//  main.cpp
//  3085
//
//  Created by 이원창 on 2021/01/15.
//

#include <iostream>
#include <algorithm>
using namespace std;
int n = 0;
char board[51][51];
int findMax(){
    int ans = 0;
    
    for(int i = 0; i < n; i++){
        int len = 1;
        for(int j = 0; j < n - 1; j++){
            if(board[i][j] == board[i][j + 1])
                len++;
            else{
                ans = max(ans, len);
                len = 1;
            }
        }
        ans = max(ans, len);
    }
    
    for(int i = 0; i < n; i++){
        int len = 1;
        for(int j = 0; j < n - 1; j++){
            if(board[j][i] == board[j + 1][i])
                len++;
            else{
                ans = max(ans, len);
                len = 1;
            }
        }
        ans = max(ans, len);
    }
    
    return ans;
}
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int ans = 0;
    cin >> n;
    getchar();
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> board[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n - 1; j++){
            if(board[i][j] != board[i][j + 1]){
                swap(board[i][j], board[i][j + 1]);
                ans = max(ans, findMax());
                swap(board[i][j], board[i][j + 1]);
            }
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n - 1; j++){
            if(board[j][i] != board[j + 1][i]){
                swap(board[j][i], board[j + 1][i]);
                ans = max(ans, findMax());
                swap(board[j][i], board[j + 1][i]);
            }
        }
    }

    cout << ans << '\n';
    return 0;
}
