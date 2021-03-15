#include <iostream>

using namespace std;
int a[10001][3];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    a[1][0] = 1;
    a[2][0] = 1, a[2][1] = 1;
    a[3][0] = 1, a[3][1] = 1, a[3][2] = 1;
    for(int i = 4; i <= 10000; i++) {
        a[i][0] = a[i - 1][0];
        a[i][1] = a[i - 2][0] + a[i - 2][1];
        a[i][2] = a[i - 3][0] + a[i - 3][1] + a[i - 3][2];
    }
    while(t--) {
        int n;
        cin >> n;
        // output
        cout << a[n][0] + a[n][1] + a[n][2] << '\n';
    }

    return 0;
}