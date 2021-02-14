// bitmask
// timeover
#include <iostream>

using namespace std;
int a[20];

int main() {
    int n;
    int res = 0;
    // input
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    // bitmask
    for(int i = 0; i < (1 << n); i++) {
        int sum = 0;
        for(int j = 0; j < n; j++) {
            if(i & (1 << j)) sum += a[j];
        }
        res = res | (1 << sum);
    }
    int ans = 0;
    while(res & (1 << ans)) ans++;


    // output
    cout << ans << '\n';
    return 0;
}