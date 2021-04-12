#include <iostream>
#include <stack>
#include <string>

using namespace std;

int precedence(char c) {
    if(c == '(') return 0;
    else if(c == '+' || c == '-') return 1;
    else return 2;
}

int main() {
    string infix;
    cin >> infix;

    string result;
    stack<char> s;

    for(char c : infix) {
        if(c >= 'A' && c <= 'Z') {
            result += c;
        }
        else {
            if(c == '(') {
                s.push(c);
            }
            else if(c == ')') {
                while(!s.empty()) {
                    if(s.top() == '(') {
                        s.pop();
                        break;
                    }
                    result += s.top();
                    s.pop();
                }
            }
            else {
                while(!s.empty() && precedence(s.top()) >= precedence(c)) {
                    result += s.top();
                    s.pop();
                }
                s.push(c);
            }
        }
    }

    while(!s.empty()) {
        result += s.top();
        s.pop();
    }

    cout << result << '\n';

    return 0;
}