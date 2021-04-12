#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int cnt[7];
int num[7];
int ans[7];

void go(int index, int n, int m) {
    if(index == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = 0; i < n; i++) {
        ans[index] = num[i];
        go(index + 1, n, m);
    }
} 

int main() {
    int n, m;
    cin >> n >> m;
    vector<int> v(n);
    for(int i = 0; i < n; i++) {
        cin >> v[i];
    }
    sort(v.begin(), v.end());

    int k = 0;
    int x = v[0];
    for(int i = 1; i < n; i++) {
        if(x == v[i]) {
            continue;
        }
        else {
            num[k++] = x;
            x = v[i];
        }
    }
    num[k++] = x;

    go(0, k, m);

    return 0;
}