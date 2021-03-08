//
//  main.cpp
//  4991
//
//  Created by 이원창 on 2021/03/08.
//

#include <iostream>
#include <queue>
using namespace std;
int w, h;
int arr[20][20];
int main(int argc, const char * argv[]) {
    while(true){
        cin >> w >> h;
        
        if(w == 0 && h == 0)
            break;
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                char c;
                
                cin >> c;
                arr[i][j] = c;
            }
        }
        
        
    }
    return 0;
}
