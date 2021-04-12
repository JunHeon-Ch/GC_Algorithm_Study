// bit mask
#include <iostream>
#include <cstring>

using namespace std;
const int UP = 0;
const int DOWN = 1;
const int LEFT = 2;
const int RIGHT = 3;

int a[20][20];
int temp_a[20][20];
bool c[20][20];
int n;

int main() {
    // input
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> a[i][j];
        }
    }

    // 0 -> up / 1 -> down / 2 -> left / 3 -> right
    int ans = 0, res = 0;
    for(int b = 0; b < (1 << 10); b++) {
        int move = b;
        int cnt = 5;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp_a[i][j] = a[i][j];
            }
        }
        while(cnt--) {
            memset(c, false, sizeof(c));
            int m = move & 3;
            move >>= 2;
            switch(m) {
                case UP:
                for(int j = 0; j < n; j++) {
                    for(int k = 1; k < n; k++) {
                        if(temp_a[k][j] != 0) {
                            for(int i = k; i > 0; i--) {
                                if(temp_a[i - 1][j] != 0) {
                                    if(temp_a[i - 1][j] == temp_a[i][j] && !c[i - 1][j] && !c[i][j]) {
                                        temp_a[i - 1][j] += temp_a[i][j];
                                        c[i - 1][j] = true;
                                        temp_a[i][j] = 0;
                                        c[i][j] = false;
                                    }
                                }
                                else {
                                    temp_a[i - 1][j] = temp_a[i][j];
                                    c[i - 1][j] = c[i][j];
                                    temp_a[i][j] = 0;
                                    c[i][j] = false;
                                }
                            }
                        }
                    }
                }
                break;
                case DOWN:
                for(int j = 0; j < n; j++) {
                    for(int k = n - 2; k >= 0; k--) {
                        if(temp_a[k][j] != 0) {
                            for(int i = k; i < n - 1; i++) {
                                if(temp_a[i + 1][j] != 0) {
                                    if(temp_a[i + 1][j] == temp_a[i][j] && !c[i + 1][j] && !c[i][j]) {
                                        temp_a[i + 1][j] += temp_a[i][j];
                                        c[i + 1][j] = true;
                                        temp_a[i][j] = 0;
                                        c[i][j] = false;
                                    }
                                }
                                else {
                                    temp_a[i + 1][j] = temp_a[i][j];
                                    c[i + 1][j] = c[i][j];
                                    temp_a[i][j] = 0;
                                    c[i][j] = false;
                                }
                            }
                        }
                    }
                }
                break;
                case LEFT:
                for(int i = 0; i < n; i++) {
                    for(int k = 1; k < n; k++) {
                        if(temp_a[i][k] != 0) {
                            for(int j = k; j > 0; j--) {
                                if(temp_a[i][j - 1] != 0) {
                                    if(temp_a[i][j - 1] == temp_a[i][j] && !c[i][j - 1] && !c[i][j]) {
                                        temp_a[i][j - 1] += temp_a[i][j];
                                        c[i][j - 1] = true;
                                        temp_a[i][j] = 0;
                                        c[i][j] = false;
                                    }
                                }
                                else {
                                    temp_a[i][j - 1] = temp_a[i][j];
                                    c[i][j - 1] = c[i][j];
                                    temp_a[i][j] = 0;
                                    c[i][j] = false;
                                }
                            }
                        }
                    }
                }
                break;
                case RIGHT:
                for(int i = 0; i < n; i++) {
                    for(int k = n - 2; k >= 0; k--) {
                        if(temp_a[i][k] != 0) {
                            for(int j = k; j < n - 1; j++) {
                                if(temp_a[i][j + 1] != 0) {
                                    if(temp_a[i][j + 1] == temp_a[i][j] && !c[i][j + 1] && !c[i][j]) {
                                        temp_a[i][j + 1] += temp_a[i][j];
                                        c[i][j + 1] = true;
                                        temp_a[i][j] = 0;
                                        c[i][j] = false;
                                    }
                                }
                                else {
                                    temp_a[i][j + 1] = temp_a[i][j];
                                    c[i][j + 1] = c[i][j];
                                    temp_a[i][j] = 0;
                                    c[i][j] = false;
                                }
                            }
                        }
                    }
                }
                break;
            }
            // find max element
            res = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    res = max(res, temp_a[i][j]);
                }
            }
        }

        ans = max(ans, res);
    }

    // output
    cout << ans << '\n';
    return 0;
}