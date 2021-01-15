#include <iostream>

using namespace std;
int d[31];

int main() {
    int n;
    cin >> n;
    d[0] = 1;
    for(int i = 2; i <= n; i++) {
        d[i] += 3 * d[i - 2];
        for(int j = 4; j <= i; j += 2) {
            d[i] += 2 * d[i - j];
        }
    }
    cout << d[n] << '\n';
    return 0;
}