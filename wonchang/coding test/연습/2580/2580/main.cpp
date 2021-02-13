//
//  main.cpp
//  2580
//
//  Created by 이원창 on 2021/02/13.
//

#include <iostream>
using namespace std;
int arr[9][9];
bool visitC[9][10];
bool visitR[9][10];
bool visitI[9][10];
void go(int cnt){
    if(cnt == 81){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                cout << arr[i][j] << ' ';
            }
            cout << '\n';
        }
        exit(0);
    }
    
    int x = cnt / 9;
    int y = cnt % 9;
    
    if(arr[x][y])
        go(cnt + 1);
    else{
        for(int i = 1; i <= 9; i++){
            if(!visitR[x][i] && !visitC[y][i] && !visitI[(x / 3) * 3 + (y / 3)][i]){
                arr[x][y] = i;
                visitR[x][i] = true;
                visitC[y][i] = true;
                visitI[(x / 3) * 3 + (y / 3)][i] = true;
                
                go(cnt + 1);
                
                arr[x][y] = 0;
                visitR[x][i] = false;
                visitC[y][i] = false;
                visitI[(x / 3) * 3 + (y / 3)][i] = false;
            }
        }
    }
}
int main(int argc, const char * argv[]) {
    for(int i = 0; i < 9; i++){
        int tmp = i / 3;
        for(int j = 0; j < 9; j++){
            cin >> arr[i][j];
            if(arr[i][j] != 0){
                visitR[i][arr[i][j]] = true;
                visitC[j][arr[i][j]] = true;
                visitI[tmp * 3 + j / 3][arr[i][j]] = true;
            }
        }
    }
    
    go(0);
    return 0;
}
