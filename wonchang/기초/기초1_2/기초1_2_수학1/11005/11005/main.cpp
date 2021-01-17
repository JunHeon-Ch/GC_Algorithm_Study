//
//  main.cpp
//  11005
//
//  Created by 이원창 on 2021/01/03.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    long n = 0;
    int b = 0;
    string ans = "";
    
    cin >> n >> b;
    while(n > 0){
        long tmp = n % b;
        if(tmp >= 10)
            ans +=( tmp + 'A' - 10);
        else
            ans += (tmp + '0');
        
        n /= b;
    }
    reverse(ans.begin(), ans.end());
    cout << ans << '\n';
    return 0;
}
