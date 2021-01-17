//
//  main.cpp
//  6064
//
//  Created by 이원창 on 2021/01/17.
//

#include <iostream>
#include <algorithm>
using namespace std;
int gcd(int a, int b){
    if(b == 0)
        return a;
    else
        return gcd(b, a % b);
}
int main(int argc, const char * argv[]) {
    int t = 0;
    int m = 0;
    int n = 0;
    int x = 0;
    int y = 0;
    
    cin >> t;
    for(int i = 0; i < t; i++){
        cin >> m >> n >> x >> y;
        int idx = 0;
        while(true){
            int year = m * idx + x;
            if((year - y) % n == 0){
                cout << year << '\n';
                break;
            }
            else if(year > (m * n / gcd(m, n))){
                cout << "-1\n";
                break;
            }
            idx++;
        }
    }
    
    return 0;
}
