//
//  main.cpp
//  11726
//
//  Created by 이원창 on 2021/01/06.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long arr[1001] = {0, };

    cin >> n;
    arr[0] = 1;
    arr[1] = 1;
    arr[2] = 2;
    for(int i = 2; i <= n; i++){
        arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
    }
    
    cout << arr[n] << endl;
    return 0;
}
