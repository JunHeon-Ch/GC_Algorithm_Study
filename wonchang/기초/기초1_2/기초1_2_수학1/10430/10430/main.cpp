//
//  main.cpp
//  10430
//
//  Created by 이원창 on 2020/12/29.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int a = 0;
    int b = 0;
    int c = 0;
    int tmp = 0;
    
    cin >> a >> b >> c;
    
    tmp = (a + b) % c;
    cout << tmp << '\n';

    tmp = ((a % c) + (b % c)) % c;
    cout << tmp << '\n';

    tmp = (a * b) % c;
    cout << tmp << '\n';

    tmp = ((a % c) * (b % c)) % c;
    cout << tmp << '\n';
    return 0;
}
