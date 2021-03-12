// DP

#include <iostream>
#include <cstring>

using namespace std;
int d[1000];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    memset(d, -1, sizeof(d));
    d[0] = 0;
    for(int i = 0; i < n; i++) {
        int x;
        cin >> x;
        if(d[i] == -1) continue;
        for(int j = 1; j <= x; j++) {
            if(i + j < n) {
                if(d[i + j] > d[i] + 1 || d[i + j] == -1) {
                    d[i + j] = d[i] + 1;
                }
            }
        }
    }

    // output
    cout << d[n - 1] << '\n';
    return 0;
}