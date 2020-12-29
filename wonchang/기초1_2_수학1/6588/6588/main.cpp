//
//  main.cpp
//  6588
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
#include <cmath>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int prime[1000001] = {1, 1, };
    int visit[1000001] = {0, };
    
    for(int i = 2; i * i <= 1000000; i++){
        if(visit[i] == 0){
            for(int j = i + i; j <= 1000000; j += i){
                prime[j] = 1;
                visit[i] = 1;
            }
        }
    }
    
    while(true){
        int n = 0;
        int idx = 3;
        int flag = 0;
        
        cin >> n;
        if(n == 0)
            break;
        
        while(idx <= n){
            if(prime[idx] == 0 && prime[n - idx] == 0){
                cout << n << " = " << idx << " + " << n - idx << '\n';
                flag = 1;
                break;
            }
            idx += 2;
        }
        if(flag == 0)
            cout << "Goldbach's conjecture is wrong.\n";
    }
    
    return 0;
}
