#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;
int alpha[26];

int main() {
    // input
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        string str;
        cin >> str;
        for(int j = 0; j < str.length(); j++) {
            alpha[str[j] - 'A'] += pow(10, str.length() - 1 - j);
        }
    }

    // Descending order
    sort(alpha, alpha + 26, greater<int>());
    int ans = 0;
    for(int i = 0; i < 10; i++) {
        ans += alpha[i] * (9 - i);
    }

    // output
    cout << ans << '\n';
    return 0;
}