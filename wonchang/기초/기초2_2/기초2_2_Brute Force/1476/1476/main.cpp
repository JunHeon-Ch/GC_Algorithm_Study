//
//  main.cpp
//  1476
//
//  Created by 이원창 on 2021/01/15.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int e = 0;
    int s = 0;
    int m = 0;
    int i = 0;
    int y = 1;
    
    cin >> e >> s >> m;
    while(true){
        y = 28 * i + s;
        if((y - e) % 15 == 0 && (y - s) % 28 == 0 && (y - m) % 19 == 0){
            cout << y << '\n';
            break;
        }
        i++;
    }
    
    return 0;
}
