//
//  main.cpp
//  14502
//
//  Created by 이원창 on 2021/02/26.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int m = 0;
    int arr[8][8];
    
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    
    return 0;
}
