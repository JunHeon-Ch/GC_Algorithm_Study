//
//  main.cpp
//  1676
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    int cnt[2] = {0, };
    
    cin >> n;
    for(int i = 2; i <= n; i++){
        int tmp = i;
        while(tmp % 2 == 0){
            cnt[0]++;
            tmp /= 2;
        }
        
        while(tmp % 5 == 0){
            cnt[1] ++;
            tmp /= 5;
        }
    }
    
    if(cnt[0] < cnt[1])
        cout << cnt[0] << '\n';
    else
        cout << cnt[1] << '\n';
    
    return 0;
}
