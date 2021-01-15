//
//  main.cpp
//  11727
//
//  Created by 이원창 on 2021/01/06.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int n = 0;
    long long arr[1001] = {0, };
    
    cin >> n;
    arr[1] = 1;
    arr[2] = 3;
    for(int i = 3; i <= n; i++){
        arr[i] = ((arr[i - 1] % 10007) + 2 * (arr[i - 2] % 10007)) % 10007;
    }
    
    cout << arr[n] << '\n';
    
    return 0;
}
