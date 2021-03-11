#include <iostream>

using namespace std;
int d[1001];

int main() {
    int n, m, x;
    cin >> n >> m;
    while(n--) {
        for(int i = 1; i <= m; i++) {
            cin >> x;
            d[i] = max(d[i - 1], d[i]) + x;
        }
    }    
    cout << d[m] << '\n';
    return 0;
}