//
//  main.cpp
//  11653
//
//  Created by 이원창 on 2021/01/03.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int idx = 2;
    
    cin >> n;
    while(n != 1){
        if(n % idx != 0)
            idx++;
        else{
            n /= idx;
            cout << idx << '\n';
        }
    }
    return 0;
}
