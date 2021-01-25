#include <iostream>
#include <cstdio>

using namespace std;
int a[4][4];

int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            scanf("%1d", &a[i][j]);
        }
    }

    int ans = 0;
    for(int i = 0; i < (1 << n * m); i++) {
        int sum = 0;
        for(int j = 0; j < n; j++) {
            int cur = 0;
            for(int k = 0; k < m; k++) {
                int x = j * m + k;
                if((i & (1 << x)) == 0) {
                    cur = cur * 10 + a[j][k];
                }
                else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        for(int k = 0; k < m; k++) {
            int cur = 0;
            for(int j = 0; j < n; j++) {
                int x = j * m + k;
                if((i & (1 << x)) != 0) {
                    cur = cur * 10 + a[j][k];
                }
                else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        ans = max(ans, sum);
    }
    printf("%d\n", ans);

    return 0;
}