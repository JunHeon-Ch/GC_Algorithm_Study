//
//  main.cpp
//  1929
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
#include <cmath>
using namespace std;
int main(int argc, const char * argv[]) {
    int m = 0;
    int n = 0;
    int visit[1000001] = {0, };
    
    cin >> m >> n;
    for(int i = 2; i <= sqrt(n); i++){
        int idx = 1;
        int tmp = 1;
        while(tmp <= n){
            tmp = (idx + 1) * i;
            visit[tmp] = 1;
            idx++;
        }
    }

    for(int i = m; i <= n; i++){
        if(visit[i] == 0 && i != 1)
            cout << i << '\n';
    }
    
    return 0;
}
