//
//  main.cpp
//  17427
//
//  Created by 이원창 on 2021/02/04.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long ans = 0;
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        ans += (n / i) * i;
    }
    cout << ans << '\n';
    
    return 0;
}
