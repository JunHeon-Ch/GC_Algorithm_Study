//
//  main.cpp
//  14499
//
//  Created by 이원창 on 2021/02/06.
//

#include <iostream>
using namespace std;
int n, m, x, y, k;
int arr[20][20];
int dx[5] = {0, 0, 0, -1, 1};
int dy[5] = {0, 1, -1, 0, 0};
struct dice{
    int top;
    int bottom;
    int left;
    int right;
    int front;
    int back;
};
dice d;
void east(){
    int tmp = d.bottom;
    d.bottom = d.right;
    d.right = d.top;
    d.top = d.left;
    d.left = tmp;
}
void west(){
    int tmp = d.bottom;
    d.bottom = d.left;
    d.left = d.top;
    d.top = d.right;
    d.right = tmp;
}
void south(){
    int tmp = d.bottom;
    d.bottom = d.front;
    d.front = d.top;
    d.top = d.back;
    d.back = tmp;
}
void north(){
    int tmp = d.bottom;
    d.bottom = d.back;
    d.back = d.top;
    d.top = d.front;
    d.front = tmp;
}
int main(int argc, const char * argv[]) {
    cin >> n >> m >> x >> y >> k;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < k; i++){
        int tmp = 0;
        cin >> tmp;
        
        int nx = x + dx[tmp];
        int ny = y + dy[tmp];
        
        if(nx < 0 || ny < 0 || nx >= n || ny >= m)
            continue;
        
        x = nx;
        y = ny;
        
        if(tmp == 1)
            east();
        else if(tmp == 2)
            west();
        else if(tmp == 3)
            north();
        else if(tmp == 4)
            south();
        
        if(arr[x][y] == 0)
            arr[x][y] = d.bottom;
        else{
            d.bottom = arr[x][y];
            arr[x][y] = 0;
        }
        cout << d.top << '\n';
    }
    
    return 0;
}
