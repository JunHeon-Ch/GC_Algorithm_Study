#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;

    cin >> t;
    cin.ignore();
    while(t--) {
        string str;
        stack<char> s;

        getline(cin, str);
        str += '\n';

        for(char c : str) {
            if(c == ' ' || c == '\n') {
                while(!s.empty()) {
                    cout << s.top();
                    s.pop();
                }
                cout << c;
            }
            else {
                s.push(c);
            }
        }
    }

    return 0;
}