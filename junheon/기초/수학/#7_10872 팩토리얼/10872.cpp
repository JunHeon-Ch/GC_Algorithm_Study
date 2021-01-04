#include <iostream>

using namespace std;

int fact[13];

int factorial(int n) {
    fact[0] = 1;

    for(int i = 1; i <= n; i++) {
        fact[i] = fact[i - 1] * i;
    }

    return fact[n];
}

int main() {
    int n;
    cin >> n;

    cout << factorial(n) << '\n';

    return 0;
}