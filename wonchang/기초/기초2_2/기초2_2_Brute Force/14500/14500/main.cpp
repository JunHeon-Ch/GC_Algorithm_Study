//
//  main.cpp
//  14500
//
//  Created by 이원창 on 2021/01/17.
//

#include <iostream>
#include <algorithm>
using namespace std;
int arr[501][501] = {0, };
int ans = 0;
int main(int argc, const char * argv[]) {
    int n = 0;
    int m = 0;
    int temp = 0;
    
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m - 3; j++){
            temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
            ans = max(ans, temp);
        }
    }
    
    for(int i = 0; i < n - 3; i++){
        for(int j = 0; j < m; j++){
            temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
            ans = max(ans, temp);
        }
    }
    
    for(int i = 0; i < n - 1; i++){
        for(int j = 0; j < m - 1; j++){
            temp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1];
            ans = max(ans, temp);
        }
    }
    
    for(int i = 0; i < n - 1; i++){
        for(int j = 0; j < m - 2; j++){
            temp = arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1] + arr[i][j+2];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
            ans = max(ans, temp);

            temp = arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+1];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
            ans = max(ans, temp);

            temp = arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+2];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j];
            ans = max(ans, temp);
        }
    }
    
    for(int i = 0; i < n - 2; i++){
        for(int j = 0; j < m - 1; j++){
            temp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
            ans = max(ans, temp);

            temp = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1];
            ans = max(ans, temp);

            temp = arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i][j+1];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
            ans = max(ans, temp);

            temp = arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i+2][j];
            ans = max(ans, temp);

            temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
            ans = max(ans, temp);
        }
    }
    
    cout << ans << '\n';
    return 0;
}
