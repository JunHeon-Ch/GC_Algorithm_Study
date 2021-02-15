#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, k;
    cin >> n >> k;
    vector<int> words(n);
    for(int i = 0; i < n; i++) {
        string str;
        cin >> str;
        for(char c : str) {
            words[i] = words[i] | (1 << (c - 'a'));
        }
    }
    // a, n, t, i, c
    if(k < 5) {
        cout << 0 << '\n';
        return 0;
    }

    int ans = 0;
    // bitmask
    for(int i = 0; i < (1 << 21); i++) {
        // check number of letter
        int cnt = 0;
        for(int j = 0; j < 21; j++) {
            if(i & (1 << j)) cnt++;
        }
        if(cnt != k - 5) continue;

        // making mask
        int mask = 0;
        cnt = 0;
        for(int j = 0; j < 26; j++) {
            // a, n, t, i, c
            if(j == 0 || j == 2 || j == 8 || j == 13 || j == 19) {
                mask = mask | (1 << j);
                cnt++;
            }
            else {
                if(i & (1 << (j - cnt))) {
                    mask = mask | (1 << j);
                }
            }
        }
        
        cnt = 0;
        for(int j = 0; j < n; j++) {
            if((words[j] & (1 << 26) - 1 - mask) == 0) {
                cnt++;
            }
        }
        ans = max(ans, cnt);
    }

    // output
    cout << ans << '\n';
    return 0;
}