#include <iostream>
#include <vector>
#include <string>

using namespace std;
bool bn[10];

int check(int c) {
    if(c == 0) {
        if(bn[c]) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
    int len = 0;
    while(c != 0) {
        if(bn[c % 10]) {
            return 0;
        }
        len++;
        c /= 10;
    }
    return len;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int num;
    cin >> num;
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int b;
        cin >> b;
        bn[b] = true;
    }

    int ans = abs(num - 100);
    for(int i = 0; i <= 1000000; i++) {
        int len = check(i);
        if(len != 0) {
            ans = min(ans, abs(num - i) + len);
        }
    }
    cout << ans << '\n';

    return 0;
}