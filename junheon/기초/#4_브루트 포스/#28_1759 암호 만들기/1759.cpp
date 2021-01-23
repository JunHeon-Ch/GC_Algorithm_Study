#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;
char a[15];
int flag[15];

void go(string ans, int selected, int vc, int cc, int n, int m) {
    if(ans.length() == m && vc >= 1 && cc >= 2) {
        cout << ans << '\n';
        return;
    }
    if(selected >= n) return;
    if(flag[selected]) {
        go(ans + a[selected], selected + 1, vc + 1, cc, n, m);
    }
    else {
        go(ans + a[selected], selected + 1, vc, cc + 1, n, m);
    }
    go(ans, selected + 1, vc, cc, n, m);
}

int main() {
    int l, c;
    cin >> l >> c;
    string vowels = "aeiou";
    for(int i = 0; i < c; i++) {
        cin >> a[i];
    }
    sort(a, a + c);
    for(int i = 0; i < c; i++) {
        if(vowels.find(a[i]) < vowels.length()) {
            flag[i] = 1;
        }
    }
    go("", 0, 0, 0, c, l);

    return 0;
}