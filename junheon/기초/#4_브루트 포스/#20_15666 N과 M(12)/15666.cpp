#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int ans[8];
int num[8];

void go(int index, int start, int n, int m) {
    if(index == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = start; i < n; i++) {
        ans[index] = num[i];
        go(index + 1, i, n, m);
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
    num[k++] = v[0];
    for(int i = 1; i < n; i++) {
        if(v[i - 1] == v[i]) continue;
        num[k++] = v[i];
    }

    go(0, 0, k, m);

    return 0;
}