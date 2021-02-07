#include <iostream>

using namespace std;
int a[20][20];
int dVal[6];

int main() {
    // input
    int n, m, x, y, k;
    cin >> n >> m >> x >> y >> k;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    // d -> now dice / flag -> move ok?
    for(int i = 0; i < k; i++) {
        int d;
        cin >> d;
        bool flag = false;
        switch(d) {
            case 1:
            if(y < m - 1) {
                y++;
                swap(dVal[0], dVal[5]);
                swap(dVal[3], dVal[4]);
                swap(dVal[4], dVal[5]);
            } else flag = true;
            break;
            case 2:
            if(y > 0) {
                y--;
                swap(dVal[0], dVal[4]);
                swap(dVal[3], dVal[5]);
                swap(dVal[4], dVal[5]);
            } else flag = true;
            break;
            case 3:
            if(x > 0) {
                x--;
                swap(dVal[1], dVal[2]);
                swap(dVal[0], dVal[2]);
                swap(dVal[1], dVal[3]);
            } else flag = true;
            break;
            case 4:
            if(x < n - 1) {
                x++;
                swap(dVal[1], dVal[2]);
                swap(dVal[0], dVal[1]);
                swap(dVal[2], dVal[3]);
            } else flag = true;
            break;
        }
        if(!flag) {
            if(a[x][y] == 0) {
                a[x][y] = dVal[0];
            }
            else {
                dVal[0] = a[x][y];
                a[x][y] = 0;
            }
            cout << dVal[3] << '\n';
        }
    }

    return 0;
}