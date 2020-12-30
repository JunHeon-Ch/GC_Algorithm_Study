//
//  main.cpp
//  9613
//
//  Created by 이원창 on 2020/12/30.
//

#include <iostream>
#include <vector>
using namespace std;
long long gcd(long long a, long long b){
    if(b == 0)
        return a;
    else
        return gcd(b, a % b);
}
long long calculate(vector<long long> v){
    long long ans = 0;
    for(int i = 0; i < v.size() - 1; i++){
        for(int j = i + 1; j < v.size(); j++){
            ans += gcd(v[i], v[j]);
        }
    }
    return ans;
}
int main(int argc, const char * argv[]) {
    int n = 0;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        int m = 0;
        vector<long long> v;
        cin >> m;
        for(int j = 0; j < m; j++){
            long long tmp = 0;
            cin >> tmp;
            v.push_back(tmp);
        }
        cout << calculate(v) << '\n';
    }
    return 0;
}
