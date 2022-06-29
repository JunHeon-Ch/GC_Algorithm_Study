#include <iostream>

using namespace std;
int a[2000];
bool d[2000][2000];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
        d[i][i] = true;
    }

    // operation
    for(int k = 1; k < n; k++) {
        for(int i = 0; i + k < n; i++) {
            int l = i, r = i + k;
            if(a[l] == a[r]) {
                if(l + 1 > r - 1 || d[l + 1][r - 1]) {
                    d[l][r] = true;
                }
            }
        }
    }

    // output
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        int x, y;
        cin >> x >> y;
        x--; y--;
        cout << d[x][y] << '\n';
    }
    return 0;
}