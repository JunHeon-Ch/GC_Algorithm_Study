#include <iostream>

using namespace std;
int a[10];
bool c[10];
int ans = 0;

void go(int n, int remain, int res) {
    if(remain == 2) {
        ans = max(ans, res);
        return;
    }
    for(int i = 1; i < n - 1; i++) {
        if(!c[i]) {
            c[i] = true;
            int j = i - 1;
            while(j >= 0 && c[j]) j--;
            int k = i + 1;
            while(k < n && c[k]) k++;
            go(n, remain - 1, res + a[j] * a[k]);
            c[i] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    go(n, n, 0);

    // output
    cout << ans << '\n'; 
    return 0;

}