//
//  main.cpp
//  10799
//
//  Created by 이원창 on 2020/12/23.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    int ans = 0;
    int cnt = 0;
    string str;
    
    cin >> str;
    
    for(int i = 0; i < str.length(); i++){
        if(str[i] == '('){
            if(str[i + 1] == ')'){
                ans += cnt;
                i++;
            }
            else{
                cnt++;
                ans++;
            }
        }
        else
            cnt--;
    }

    cout << ans << '\n';
    return 0;
}
