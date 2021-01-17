//
//  main.cpp
//  9095
//
//  Created by 이원창 on 2021/01/17.
//

#include <iostream>
#include <algorithm>
using namespace std;
int go(int n){
    if(n == 1)
        return 1;
    else if(n == 2)
        return 2;
    else if(n == 3)
        return 4;
    else
        return go(n - 3) + go(n - 2) + go(n - 1);
}
int main(int argc, const char * argv[]) {
    int t = 0;
    
    cin >> t;
    for(int i = 0; i < t; i++){
        int n = 0;
        
        cin >> n;
        cout << go(n) << '\n';
    }
    
    return 0;
}
