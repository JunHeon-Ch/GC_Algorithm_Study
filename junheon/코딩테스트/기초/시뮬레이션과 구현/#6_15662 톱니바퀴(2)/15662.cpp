#include <iostream>
#include <cstdio>

using namespace std;
int a[1001][10];

int main() {
    // input
    int t;
    scanf("%d", &t);
    for(int i = 1; i <= t; i++) {
        for(int j = 1; j <= 8; j++) {
            scanf("%1d", &a[i][j]);
        }
    }
    int k;
    scanf("%d", &k);
    for(int i = 0; i < k; i++) {
        int n, d, r;
        scanf("%d %d", &n, &d);
        int left = a[n][7];
        int right = a[n][3];
        if(d == -1) {
            for(int l = 1; l <= 8; l++) {
                a[n][l - 1] = a[n][l];
            }
            a[n][8] = a[n][0];
        }
        else if(d == 1) {
            for(int l = 8; l >= 1; l--) {
                a[n][l + 1] = a[n][l];
            }
            a[n][1] = a[n][9];
        }
        r = -d;
        for(int j = n - 1; j >= 1; j--) {
            if(left == a[j][3]) break;
            left = a[j][7];
            if(r == -1) {
                for(int l = 1; l <= 8; l++) {
                    a[j][l - 1] = a[j][l];
                }
                a[j][8] = a[j][0];
            }
            else if(r == 1) {
                for(int l = 8; l >= 1; l--) {
                    a[j][l + 1] = a[j][l];
                }
                a[j][1] = a[j][9];
            }
            r = -r;
        }
        r = -d;
        for(int j = n + 1; j <= t; j++) {
            if(right == a[j][7]) break;
            right = a[j][3];
            if(r == -1) {
                for(int l = 1; l <= 8; l++) {
                    a[j][l - 1] = a[j][l];
                }
                a[j][8] = a[j][0];
            }
            else if(r == 1) {
                for(int l = 8; l >= 1; l--) {
                    a[j][l + 1] = a[j][l];
                }
                a[j][1] = a[j][9];
            }
            r = -r;
        }
    }

    int ans = 0;
    for(int i = 1; i <= t; i++) {
        if(a[i][1] == 1) ans++;
    }
    printf("%d\n", ans);
}