//
//  main.cpp
//  2745
//
//  Created by 이원창 on 2021/01/03.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    string str = "";
    int n = 0;
    int idx = 1;
    long ans = 0;
    
    cin >> str >> n;
    for(int i = str.length() - 1; i >= 0; i--){
        if(str[i] >= 'A' && str[i] <= 'Z')
            ans += ((str[i] - 'A' + 10) * idx);
        else if(str[i] >= '0' && str[i] <= '9')
            ans += ((str[i] - '0') * idx);
        
        idx *= n;
    }
    cout << ans << '\n';
    return 0;
}
