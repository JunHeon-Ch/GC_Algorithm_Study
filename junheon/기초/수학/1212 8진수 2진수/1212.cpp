#include <iostream>
#include <algorithm>

using namespace std;

string eight[8] = {"000", "001", "010", "011", "100", "101", "110", "111"};
int main() {
    string x;
    cin >> x;
    if(x.size() == 1 && x[0] - '0' == 0) {
        cout << "0";
    }

    bool flag = true;
    for(int i = 0; i < x.size(); i++) {
        int n = x[i] - '0';
        if(flag && n < 4) {
            if(n == 0) {
                continue;
            }
            else if(n == 1) {
                cout << "1";
            }
            else if(n == 2) {
                cout << "10";
            }
            else if(n == 3) {
                cout << "11";
            }
            flag = false;
        }
        else {
            cout << eight[n];
            flag = false;
        }
    }

    return 0;
}