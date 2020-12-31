#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

const int MAX = 1000000;

int main() {
    bool isPrime[MAX + 1];
    fill_n(isPrime, MAX + 1, true);
    isPrime[0] = isPrime[1] = false;

    for(int i = 2; i <= sqrt(MAX); i++) {
        if(isPrime[i]) {
            for(int j = i + i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
    }

    int n, m;
    cin >> m >> n;
    for(int i = m; i <= n; i++) {
        if(isPrime[i]) {
            cout << i << '\n';
        }
    }

    return 0;
}