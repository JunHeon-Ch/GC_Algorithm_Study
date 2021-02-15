// bitmask
#include <iostream>

using namespace std;
int a[20];
bool c[2000001];

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
        c[sum] = true;
    }
    int i;
    for(i = 0; i <= 2000000; i++) {
        if(!c[i]) break;
    }

    // output
    cout << i << '\n';
    return 0;
}