//
//  main.cpp
//  20327
//
//  Created by 이원창 on 2021/02/08.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int r = 0;
    int arr[128][128];
    
    cin >> n >> r;
    for(int i = 0; i < pow(2, n); i++){
        for(int j = 0; j < pow(2, n); j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i < r; i++){
        int k, l;
        cin >> k >> l;
        
    }
    
    return 0;
}
