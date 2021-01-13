#include <iostream>

using namespace std;
const long long DIV = 1000000009LL;
const int MAX = 1000000;
long long d[MAX + 1];

int main () {
    d[0] = 1;
    for(int i = 1; i <= MAX; i++) {
        if(i - 2 < 0) {
            d[i] = d[i - 1] % DIV; 
        }
        else if(i - 3 < 0) {
            d[i] = (d[i - 1] + d[i - 2]) % DIV;
        }
        else {
            d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % DIV;
        }
    }
    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        cout << d[n] << '\n';
    }

    return 0;
}
