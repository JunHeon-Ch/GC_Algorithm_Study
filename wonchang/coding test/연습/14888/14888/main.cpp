//
//  main.cpp
//  14888
//
//  Created by 이원창 on 2021/02/11.
//

#include <iostream>
#include <climits>
#include <vector>
using namespace std;
int n = 0;
int op[4];
long long arr[100];
long long maxAns = LONG_LONG_MIN;
long long minAns = LONG_LONG_MAX;
long long cal(int idx, int num, int op){
    long long tmp = 0;
    if(op == 0)
        tmp = num + arr[idx + 1];
    else if(op == 1)
        tmp = num - arr[idx + 1];
    else if(op == 2)
        tmp = num * arr[idx + 1];
    else
        tmp = num / arr[idx + 1];
    
    return tmp;
}
void go(int cnt, long long num){
    if(cnt == n - 1){
        maxAns = max(maxAns, num);
        minAns = min(minAns, num);
        return;
    }
    
    for(int i = 0; i < 4; i++){
        if(op[i] != 0){
            op[i]--;
            go(cnt + 1, cal(cnt, num, i));
            op[i]++;
        }
    }
}
int main(int argc, const char * argv[]) {
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    for(int i = 0; i < 4; i++){
        cin >> op[i];
    }
    
    go(0, arr[0]);
    cout << maxAns << '\n';
    cout << minAns << '\n';
    return 0;
}


