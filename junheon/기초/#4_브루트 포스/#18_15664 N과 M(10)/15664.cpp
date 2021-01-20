#include <iostream>
#include <algorithm>

using namespace std;

int cnt[8];
int num[8];
int ans[8];

void go(int index, int start, int n, int m) {
    if(index == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = start; i < n; i++) {
        if(cnt[i] > 0) {
            ans[index] = num[i];
            cnt[i]--;
            go(index + 1, i, n, m);
            cnt[i]++;
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    int a[8];
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n);

    int x = a[0];
    int c = 1;
    int k = 0;
    for(int i = 1; i < n; i++) {
        if(x == a[i]) {
            c++;
        }
        else {
            cnt[k] = c;
            num[k++] = x;
            x = a[i];
            c = 1;
        }
    }
    cnt[k] = c;
    num[k++] = x;

    go(0, 0, k, m);

    return 0;
}