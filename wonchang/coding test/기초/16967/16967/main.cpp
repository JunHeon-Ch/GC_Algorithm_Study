//
//  main.cpp
//  16967
//
//  Created by 이원창 on 2021/02/08.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    int idx = 0;
    int h, w, x, y;
    int arr[600][600];
    int ans[300][300];
    vector<int> v;
    
    cin >> h >> w >> x >> y;
    for(int i = 0; i < h + x; i++){
        for(int j = 0; j < w + y; j++){
            cin >> arr[i][j];
        }
    }
    
    
    for(int i = 0; i < x; i++){
        for(int j = 0; j < w; j++){
            ans[i][j] = arr[i][j];
        }
    }

    for(int i = x; i < h; i++){
        for(int j = 0; j < y; j++){
            ans[i][j] = arr[i][j];
        }
    }

    for(int i = x; i < h; i++){
        for(int j = y; j < w; j++){
            ans[i][j] = arr[i][j] - ans[i - x][j - y];
        }
    }
    
    for(int i = 0; i < h; i++){
        for(int j = 0; j < w; j++){
            cout << ans[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}
