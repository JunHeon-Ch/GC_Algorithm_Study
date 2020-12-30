#include <iostream>
#include <cmath>

using namespace std;

const int MAX = 1000000;
int prime[MAX];
int pn;
bool check[MAX + 1];

void createPrimeTable() {
    for(int i = 2; i <= sqrt(MAX); i++) {
        if(!check[i]) {
            prime[pn++] = i;
            for(int j = i + i; j <= MAX; j += i) {
                check[j] = true;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    createPrimeTable();

    while(true) {
        int n;
        cin >> n;
        if(n == 0) {
            break;
        }

        int i;
        for(i = 0; i < pn; i++) {
            if(!check[n - prime[i]]) {
                cout << n << " = " << prime[i] << " + " << n - prime[i] << '\n';
                break;
            }
        }
        if(i == pn) {
            cout << "Goldbach's conjecture is wrong." << '\n';
        }
    }

    return 0;
}