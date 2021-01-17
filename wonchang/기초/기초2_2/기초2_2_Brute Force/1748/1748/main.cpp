//
//  main.cpp
//  1748
//
//  Created by 이원창 on 2021/01/17.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int ans = 0;
    string tmp = "";
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        if(i < 10)
            ans += 1;
        else if(i < 100)
            ans += 2;
        else if(i < 1000)
            ans += 3;
        else if(i < 10000)
            ans += 4;
        else if(i < 100000)
            ans += 5;
        else if(i < 1000000)
            ans += 6;
        else if(i < 10000000)
            ans += 7;
        else if(i < 100000000)
            ans += 8;
        else
            ans += 9;
    }
    
    cout << ans << '\n';;
    return 0;
}
