#include <iostream>
#include <cmath>
#include <cstring>

using namespace std;
int a[130][130];
int ans[130][130];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, r;
    cin >> n >> r;
    int nMax = pow(2, n);
    for(int i = 0; i < nMax; i++) {
        for(int j = 0; j < nMax; j++) {
            cin >> a[i][j];
        }
    }    

    // operation
    for(int o = 0; o < r; o++) {
        int k, l;
        cin >> k >> l;
        int lVal = pow(2, l);
        switch(k) {
            case 1:
            for(k = 0; k < nMax; k += lVal) {
                for(int i = k, c = 0; i < k + lVal; i++, c++) {
                    for(int j = 0; j < nMax; j++) {
                        ans[i][j] = a[k + lVal - 1 - c][j];
                    }
                }
            }
            break;
            case 2:
            for(k = 0; k < nMax; k += lVal) {
                for(int j = k, c = 0; j < k + lVal; j++, c++) {
                    for(int i = 0; i < nMax; i++) {
                        ans[i][j] = a[i][k + lVal - 1 - c];
                    }
                }
            }
            break;
            case 3:
            for(k = 0; k < nMax; k += lVal) {
                for(int i = k; i < k + lVal; i++) {
                    for(l = 0; l < nMax; l += lVal) {
                        for(int j = l; j < l + lVal; j++) {
                            ans[j - l + k][l + lVal - 1 + k - i] = a[i][j];
                        }
                    }
                }
            }
            break;
            case 4:
            for(k = 0; k < nMax; k += lVal) {
                for(int i = k; i < k + lVal; i++) {
                    for(l = 0; l < nMax; l += lVal) {
                        for(int j = l; j < l + lVal; j++) {
                            ans[k + lVal - 1 + l - j][i - k + l] = a[i][j];
                            
                        }
                    }
                }
            }
            break;
            case 5:
            for(k = 0; k < nMax; k += lVal) {
                for(int i = k, c = 0; i < k + lVal; i++, c++) {
                    for(int j = 0; j < nMax; j++) {
                        ans[nMax - k - lVal + c][j] = a[i][j];
                    }
                }
            }
            break;
            case 6:
            for(k = 0; k < nMax; k += lVal) {
                for(int j = k, c = 0; j < k + lVal; j++, c++) {
                    for(int i = 0; i < nMax; i++) {
                        ans[i][nMax - k - lVal + c] = a[i][j];
                    }
                }
            }
            break;
            case 7:
            for(k = 0; k < nMax; k += lVal) {
                for(l = 0; l < nMax; l += lVal) {
                    for(int i = 0; i < lVal; i++) {
                        for(int j = 0; j < lVal; j++) {
                            ans[l + i][nMax - lVal - k + j] = a[k + i][l + j];
                        }
                    }
                }
            }
            break;
            case 8:
            for(k = 0; k < nMax; k += lVal) {
                for(l = 0; l < nMax; l += lVal) {
                    for(int i = 0; i < lVal; i++) {
                        for(int j = 0; j < lVal; j++) {
                            ans[nMax - lVal - l + i][k + j] = a[k + i][l + j];
                        }
                    }
                }
            }
            break;
        }
        memcpy(a, ans, sizeof(ans));
    }
    // output
    for(int i = 0; i < nMax; i++) {
        for(int j = 0; j < nMax; j++) {
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}