//
//  main.cpp
//  2609
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
using namespace std;
int gcd(int a, int b){
    if(b == 0)
        return a;
    else
        return gcd(b, a % b);
}
int main(int argc, const char * argv[]) {
    int a = 0;
    int b = 0;
    int ans = 0;
    
    cin >> a >> b;
    ans = gcd(a, b);
    
    cout << ans << '\n';
    cout << a * b / ans << '\n';
    
    return 0;
}
