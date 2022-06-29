#include <iostream>
#include <algorithm>

using namespace std;
char a[50][50];

int check(int n) {
    int ans = 1;
    for(int i = 0; i < n; i++) {
        int cnt = 1;
        for(int j = 1; j < n; j++) {
            if(a[i][j] == a[i][j - 1]) {
                cnt++;
            }
            else {
                cnt = 1;
            }
            ans = max(ans, cnt);
        }
        cnt = 1;
        for(int j = 1; j < n; j++) {
            if(a[j][i] == a[j - 1][i]) {
                cnt++;
            }
            else {
                cnt = 1;
            }
            ans = max(ans, cnt);
        }
    }
    return ans;
}

int main() {
    int n;
    cin >> n;
    cin.ignore();
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> a[i][j];
        }
    }
    int ans = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(j < n - 1 && a[i][j] != a[i][j + 1]) {
                swap(a[i][j], a[i][j + 1]);
                int temp = check(n);
                ans = max(ans, temp);
                swap(a[i][j], a[i][j + 1]);
            }
            if(i < n - 1 && a[i][j] != a[i + 1][j]) {
                swap(a[i][j], a[i + 1][j]);
                int temp = check(n);
                ans = max(ans, temp);
                swap(a[i][j], a[i + 1][j]);
           }
        }
    }
    cout << ans << '\n';

    return 0;
}