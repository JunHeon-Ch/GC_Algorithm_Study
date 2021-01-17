//
//  main.cpp
//  2089
//
//  Created by 이원창 on 2020/12/30.
//

#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    long n = 0;
    string ans = "";
    cin >> n;
    if(n == 0){
        cout << "0\n";
        return 0;
    }
    while(n != 0){
        if(n % -2 == 0){
            ans += '0';
            n /= -2;
        }
        else{
            ans += '1';
            n = (n - 1) / -2;
        }
    }
    
    reverse(ans.begin(), ans.end());
    cout << ans << endl;
    return 0;
}
