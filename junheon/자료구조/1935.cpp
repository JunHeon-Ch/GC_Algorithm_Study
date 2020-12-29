#include <iostream>
#include <iomanip>
#include <string>
#include <stack>

using namespace std;


int main() {
    int n;
    cin >> n;
    string postfix;
    cin >> postfix;
    int operand[26];
    for(int i = 0; i < n; i++) {
        cin >> operand[i];
    }

    stack<double> s;
    for(char c : postfix) {
        if(c >= 'A' && c <= 'Z') {
            s.push(double(operand[c - 'A']));
        }
        else {
            double op1 = s.top();
            s.pop();
            double op2 = s.top();
            s.pop();
            switch (c) {
            case '+':
                s.push(op2 + op1);
                break;
            case '-':
                s.push(op2 - op1);
                break;
            case '*':
                s.push(op2 * op1);
                break;      
            case '/':
                if(op1 == 0) {
                    return 0;
                }
                s.push(op2 / op1);
                break;      
            default:
                break;
            }
        }
    }
    cout << fixed << setprecision(2);
    cout << s.top() << '\n';
}