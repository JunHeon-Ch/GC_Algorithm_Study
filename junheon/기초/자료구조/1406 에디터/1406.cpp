#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
    stack<char> left;
    stack<char> right;

    string str;
    getline(cin, str);
    for(char c : str) {
        left.push(c);
    }

    int t;
    cin >> t;
    while(t--) {
        char cursor;
        cin >> cursor;

        if(cursor == 'L') {
            if(!left.empty()) {
                right.push(left.top());
                left.pop();
            }
        }
        else if(cursor == 'D') {
            if(!right.empty()) {
                left.push(right.top());
                right.pop();
            }
        }
        else if(cursor == 'B') {
            if(!left.empty()) {
                left.pop();
            }
        }
        else if(cursor == 'P') {
            char c;
            cin >> c;
            left.push(c);
        }
    }

    while(!left.empty()) {
        right.push(left.top());
        left.pop();
    }
    while(!right.empty()) {
        cout << right.top();
        right.pop();
    }


    return 0;
}