//
//  main.cpp
//  16926
//
//  Created by 이원창 on 2021/02/05.
//

#include <iostream>
using namespace std;
int n = 0;
int m = 0;
int r = 0;
int arr[300][300];
void go(int cnt){
    // Run for loop as number as rectangles
    for(int i = 0; i < min(n, m) / 2; i++){
        // Save the first number based on current rectangle
        int tmp = arr[i][i];
        
        // Pull top row numbers to the left based on current rectangle
        for(int j = i; j < m - i - 1; j++){
            arr[i][j] = arr[i][j + 1];
        }
        
        // Pull lefg column numbers to the bottom based on current rectangle
        for(int j = i; j < n - i - 1; j++){
            arr[j][m - i - 1] = arr[j + 1][m - i - 1];
        }

        // Push bottom row numbers to the right based on current rectangle
        for(int j = m - i - 1; j > i; j--){
            arr[n - i - 1][j] = arr[n - i - 1][j - 1];
        }
        
        // Push top column numbers to the top based on current rectangle
        for(int j = n - i - 1; j > i; j--){
            arr[j][i] = arr[j - 1][i];
        }
        
        // Transfer the initially saved number
        arr[i + 1][i] = tmp;
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m >> r;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < r; i++){
        go(0);
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << arr[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}
