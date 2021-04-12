#include <iostream>
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
        getline(cin, str);
        str += '\n';

        int size = 0;
        for(char c : str) {
            if(c == '(') {
                size++;
            }
            else if(c == ')') {
                size--;
            }
            if(size < 0) {
                cout << "NO" << '\n';
                break;
            }
        }

        if (size == 0) {
            cout << "YES" << '\n';
        }
        else if (size > 0) {
            cout << "NO" << '\n';
        }
    }

    return 0;
}
