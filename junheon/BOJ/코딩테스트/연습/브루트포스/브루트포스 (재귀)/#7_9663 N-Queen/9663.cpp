#include <iostream>

using namespace std;
// index -> row / queen[index] -> column
int queen[15];
int n;
int ans = 0;

void go(int cnt) {
    if(cnt == n) {
        ans++;
        return;
    }
    for(int i = 0; i < n; i++) {
        bool flag = false;
        for(int j = 0; j < cnt; j++) {
            if(queen[j] == i || abs(cnt - j) == abs(i - queen[j])) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            queen[cnt] = i;
            go(cnt + 1);
        }
    }
}
    
int main() {
    // input
    cin >> n;

    go(0);

    // output
    cout << ans << '\n';
    return 0;
}