//
//  main.cpp
//  11576
//
//  Created by 이원창 on 2021/01/03.
//

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int main(int argc, const char * argv[]) {
    int a = 0;
    int b = 0;
    int m = 0;
    int mul = 0;
    long temp = 0;
    vector<int> ans;
    
    cin >> a >> b >> m;
    mul = pow(a, m - 1);
    for(int i = 0; i < m; i++){
        int tmp = 0;

        cin >> tmp;
        temp += (mul * tmp);
        mul = mul / a;
    }

    while(temp > 0){
        ans.push_back(temp % b);
        temp /= b;
    }
    
    for(int i = ans.size() - 1; i >= 0; i--){
        cout << ans[i] << ' ';
    }
    return 0;
}
