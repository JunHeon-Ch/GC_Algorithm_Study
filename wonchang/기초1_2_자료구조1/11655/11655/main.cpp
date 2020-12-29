//
//  main.cpp
//  11655
//
//  Created by 이원창 on 2020/12/27.
//

#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string str = "";
    string ans = "";
    getline(cin, str);
    
    for(int i = 0; i < str.length(); i++){
        if(str[i] >= 'a' && str[i] <= 'z'){
            if(str[i] + 13 > 'z')
                ans += (str[i] - 13);
            else
                ans += (str[i] + 13);
        }
        else if(str[i] >= 'A' && str[i] <= 'Z'){
            if(str[i] + 13 > 'Z')
                ans += (str[i] - 13);
            else
                ans += (str[i] + 13);
        }
        else if(str[i] == ' ')
            ans += str[i];
        else
            ans += str[i];
    }
    
    cout << ans << '\n';
    return 0;
}
