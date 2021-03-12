// DP

#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>

using namespace std;
int a[1000];
int d[1000];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    // operation
    memset(d, -1, sizeof(d));
    d[0] = 0;
    for(int i = 1; i < n; i++) {
        vector<int> v;
        for(int j = i - 1; j >= 0; j--) {
            if(d[j] == -1) continue;
            if(j + a[j] >= i) {
                v.push_back(d[j]);
            }
        }
        if(v.size() != 0) {
            d[i] = *min_element(v.begin(), v.end()) + 1;
        }
    }

    // output
    cout << d[n - 1] << '\n';
    return 0;
}