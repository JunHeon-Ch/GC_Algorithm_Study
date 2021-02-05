//
//  main.cpp
//  16935
//
//  Created by 이원창 on 2021/02/04.
//

#include <iostream>
#include <vector>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int m = 0;
    int cnt = 0;
    int arr[100][100];
    int r[1000];
    
    cin >> n >> m >> cnt;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < cnt; i++){
        cin >> r[i];
    }
    
    
    return 0;
}
