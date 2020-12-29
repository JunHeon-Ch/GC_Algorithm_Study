//
//  main.cpp
//  10824
//
//  Created by 이원창 on 2020/12/27.
//

#include <iostream>
#include <cmath>
using namespace std;
long long len(long long num){
    int len = 0;
    while(num >= 1){
        num /= 10;
        len++;
    }
    return len;
}
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    long long a = 0;
    long long b = 0;
    long long c = 0;
    long long d = 0;
    long long ans = 0;
    
    cin >> a;
    cin >> b;
    cin >> c;
    cin >> d;

    ans += (a * pow(10, len(b)) + b);
    ans += (c * pow(10, len(d)) + d);
    cout << ans << '\n';
    return 0;
}
