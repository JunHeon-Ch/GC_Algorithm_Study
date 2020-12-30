//
//  main.cpp
//  2004
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    long long n = 0;
    long long m = 0;
    long long cnt[2] = {0, };
    
    cin >> n >> m;
    if(n == m || m == 0){
        cout << "0\n";
        return 0;
    }
    
    for(long long i = 2; i <= n; i *= 2){
        cnt[0] += n / i;
    }
    for(long long i = 2; i <= m; i *= 2){
        cnt[0] -= m / i;
    }
    for(long long i = 2; i <= n - m; i *= 2){
        cnt[0] -= (n - m) / i;
    }
    
    for(long long i = 5; i <= n; i *= 5){
        cnt[1] += n / i;
    }
    for(long long i = 5; i <= m; i *= 5){
        cnt[1] -= m / i;
    }
    for(long long i = 5; i <= n - m; i *= 5){
        cnt[1] -= (n - m) / i;
    }

    if(cnt[0] < cnt[1])
        cout << cnt[0] << '\n';
    else
        cout << cnt[1] << '\n';
    
    return 0;
}
