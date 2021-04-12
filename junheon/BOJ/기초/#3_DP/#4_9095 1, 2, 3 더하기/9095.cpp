#include <iostream>

using namespace std;
int cases[11];

int main() {
    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;

        cases[0] = cases[1] = 1;
        cases[2] = 2;
        for(int i = 3; i <= n; i++) {
            cases[i] = cases[i - 3] + cases[i - 1] + cases[i - 2];
        }
        cout << cases[n] << '\n';
    }
}