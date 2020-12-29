//
//  main.cpp
//  1934
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
using namespace std;
int gcd(int a, int b){
    if(b == 0)
        return a;
    else
        return gcd(b, a % b);
}
int main(int argc, const char * argv[]) {
    int n = 0;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        int a = 0;
        int b = 0;
        cin >> a >> b;
        cout << a * b / gcd(a, b) << '\n';
    }
    
    return 0;
}
