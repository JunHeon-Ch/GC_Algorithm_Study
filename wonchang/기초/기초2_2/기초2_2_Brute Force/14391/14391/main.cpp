//
//  main.cpp
//  14391
//
//  Created by 이원창 on 2021/01/23.
//

#include <iostream>
#include <algorithm>
using namespace std;
int n = 0;
int m = 0;
int arr[4][4];
int main(int argc, const char * argv[]) {
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            char tmp;
            cin >> tmp;
            arr[i][j] = tmp - '0';
        }
    }
    
    

    return 0;
}
