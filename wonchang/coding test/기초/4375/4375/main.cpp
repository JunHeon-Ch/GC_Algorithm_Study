//
//  main.cpp
//  4375
//
//  Created by 이원창 on 2021/02/04.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    while(cin >> n){
        int idx = 1;
        int tmp = 1;
        while(tmp != 0 && n != 1){
            idx++;
            tmp = tmp * 10 + 1;
            tmp %= n;
            if(tmp == 0)
                break;
        }
        cout << idx << '\n';
    }
    
    return 0;
}
