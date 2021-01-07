#include <iostream>

using namespace std;
int cases[1001];
const int DIV = 10007;

int main() {
    int n;
    cin >> n;

    cases[1] = 1;
    cases[2] = 2;
    for(int i = 3; i <= n; i++) {
        cases[i] = (cases[i - 1] + cases[i - 2]) % DIV;
    }
    cout << cases[n] << '\n';

    return 0;
}