//
//  main.cpp
//  17413
//
//  Created by 이원창 on 2020/12/23.
//

#include <iostream>
#include <cstring>
#include <vector>
using namespace std;
string flip(string str){
    char temp;
    for(int i = 0; i < str.length()/2; i++){
        temp = str[i];
        str[i] = str[str.length() - i - 1];
        str[str.length() - i - 1] = temp;
    }
    
    return str;
}
int main(int argc, const char * argv[]) {
    int idx = 0;
    string str = "";
    string temp = "";
    string ans = "";
    getline(cin, str);
    
    while(str[idx] != '\0'){
        if(str[idx] == '<'){
            while(true){
                temp += str[idx];
                if(str[idx++] == '>')
                    break;
            }
            ans += temp;
            temp = "";
        }
        else if(str[idx] != ' '){
            while(true){
                if(str[idx] == ' ' or str[idx] == '\0' or str[idx] == '<')
                    break;
                temp += str[idx++];
            }
            ans += flip(temp);
            temp = "";
        }
        else
            ans += str[idx++];
    }
    cout << ans << '\n';
    return 0;
}

