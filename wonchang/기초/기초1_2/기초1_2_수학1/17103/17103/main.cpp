//
//  main.cpp
//  17103
//
//  Created by 이원창 on 2020/12/30.
//

#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n = 0;
    int prime[1000001] = {1, 1, };
    bool visit[1000001] = {0, };
    
    for(int i = 2; i <= 1000; i++){
        if(!visit[i]){
            visit[i] = true;
            for(int j = i + i; j <= 1000000; j += i){
                prime[j] = 1;
            }
        }
    }

    cin >> n;
    for(int i = 0; i < n; i++){
        int tmp = 0;
        int idx = 1;
        int cnt = 0;
        
        cin >> tmp;
        while(idx <= tmp / 2){
            if(prime[idx] == 0 && prime[tmp - idx] == 0){
                cnt++;
            }
            idx ++;
        }
        cout << cnt << '\n';
    }
        
    return 0;
}
