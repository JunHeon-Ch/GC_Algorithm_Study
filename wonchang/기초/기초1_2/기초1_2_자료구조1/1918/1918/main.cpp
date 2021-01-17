//
//  main.cpp
//  1918
//
//  Created by 이원창 on 2020/12/25.
//

#include <iostream>
#include <stack>
using namespace std;
int main(int argc, const char *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string str = "";
    string ans = "";
    stack<char> tmp;
    cin >> str;
    
    for(int i = 0; i < str.length(); i++){
        if(str[i] == '*' || str[i] == '/') {
            while(!tmp.empty() && (tmp.top() == '*' || tmp.top() == '/')){
                ans += tmp.top();
                tmp.pop();
            }
            tmp.push(str[i]);
        }
        else if(str[i] == '(')
            tmp.push(str[i]);
        else if(str[i] == ')'){
            while (!tmp.empty() && tmp.top() != '(') {
                ans += tmp.top();
                tmp.pop();
            }
            tmp.pop();
        }
        else if(str[i] == '+' || str[i] == '-'){
            while (!tmp.empty() && tmp.top() != '('){
                ans += tmp.top();
                tmp.pop();
            }
            tmp.push(str[i]);
        }
        else
            ans += str[i];
    }
    while(!tmp.empty()){
        ans += tmp.top();
        tmp.pop();
    }
    
    cout << ans << '\n';
    return 0;
}
