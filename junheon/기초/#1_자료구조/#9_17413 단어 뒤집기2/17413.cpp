#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
    stack<char> s;

    string str;
    getline(cin, str);
    str += '\n';

    bool tag = false;
    for(char c : str) {
        if(c == ' ' || c == '<' || c == '\n') {
            if(!tag) {
                while(!s.empty()) {
                    cout << s.top();
                    s.pop();
                }
            }
            if(c == '<') {
                tag = true;
            }
            cout << c;
        }
        else if(c == '>') {
            tag = false;
            cout << c;
        }
        else {
            if(!tag) {
                s.push(c);
            }
            else {
                cout << c;
            }
        }
    }

    return 0;
}