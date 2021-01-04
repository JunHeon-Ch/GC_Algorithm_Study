#include <iostream>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    stack<int> s;
    string result;
    int t, m = 0;

    cin >> t;
    while(t--) {
        int n;
        cin >> n;

        if(n > m) {
            while(n > m) {
                s.push(++m);
                result += '+';
            }
            s.pop();
            result += '-';
        }
        else {
            if(!s.empty() && s.top() == n) {
                result += '-';
                s.pop();
            }
            else {
                cout << "NO" << '\n';
                return 0;
            }
        }
    }

    for(char c : result) {
        cout << c << '\n';
    }

    return 0;
}