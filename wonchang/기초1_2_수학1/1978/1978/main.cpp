//
//  main.cpp
//  1978
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
using namespace std;
bool prime(int num){
    for(int i = 2; i < num; i++){
        if(num % i == 0)
            return false;
    }
    return true;
}
int main(int argc, const char * argv[]) {
    int n = 0;
    int ans = 0;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        int tmp = 0;
        cin >> tmp;
        if(prime(tmp) && tmp != 1)
            ans++;
    }
    
    cout << ans << '\n';
    return 0;
}
