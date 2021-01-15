//
//  main.cpp
//  10872
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n = 0;
    int ans = 1;
    
    cin >> n;
    for(int i = 1; i <= n; i++){
        ans *= i;
    }
    cout << ans << '\n';
    
    return 0;
}
