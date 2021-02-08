#include <iostream>

using namespace std;
int a[600][600];

int main() {
    // input
    int h, w, x, y;
    cin >> h >> w >> x >> y;
    for(int i = 0; i < h + x; i++) {
        for(int j = 0; j < w + y; j++) {
            cin >> a[i][j];
        }
    }

    // recovery array
    for(int i = 0; i < h - x; i++) {
        for(int j = 0; j < w - y; j++) {
            a[x + i][y + j] -= a[i][j];
        }
    }

    // output
    for(int i = 0; i < h; i++) {
        for(int j = 0; j < w; j++) {
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}