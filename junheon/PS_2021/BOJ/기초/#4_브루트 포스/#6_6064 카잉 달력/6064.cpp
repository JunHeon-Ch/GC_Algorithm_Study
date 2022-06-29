#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;
    while(t--) {
        int m, n, x, y;
        cin >> m >> n >> x >> y;
        int i = 0;
        bool flag = false;
        while(m * i + x <= m * n) {
            int k = m * i + x;
            if((k - y) % n == 0) {
                cout << k << '\n';
                flag = true;
                break;
            }
            i++;
        }
        if(!flag) {
            cout << -1 << '\n';
        }
    }

    return 0;
}