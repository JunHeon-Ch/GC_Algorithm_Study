//
//  main.cpp
//  16927
//
//  Created by 이원창 on 2021/02/05.
//

#include <iostream>
#include <algorithm>
int n = 0;
int m = 0;
int r = 0;
int arr[300][300];
using namespace std;
void go(){
    // Run for loop as number as rectangles
    for(int i = 0; i < min(n, m) / 2; i++){
        int bottom = n - i - 1;
        int right = m - i - 1;

        // I don't know why I write this code
        // But people say it is to reduce unnecessary loops and prevent timeout
        int idx = r % (2 * (right - i + 1) + 2 * (bottom - i + 1) - 4);
        
        while(idx--){
            // Save the first number based on current rectangle
            int tmp = arr[i][i];
            
            // Pull top row numbers to the left based on current rectangle
            for(int j = i; j < right; j++){
                arr[i][j] = arr[i][j + 1];
            }
            
            // Pull lefg column numbers to the bottom based on current rectangle
            for(int j = i; j < bottom; j++){
                arr[j][right] = arr[j + 1][right];
            }

            // Push bottom row numbers to the right based on current rectangle
            for(int j = right; j > i; j--){
                arr[bottom][j] = arr[bottom][j - 1];
            }

            // Push top column numbers to the top based on current rectangle
            for(int j = bottom; j > i; j--){
                arr[j][i] = arr[j - 1][i];
            }

            // Transfer the initially saved number
            arr[i + 1][i] = tmp;
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n >> m >> r;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    go();
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << arr[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}
