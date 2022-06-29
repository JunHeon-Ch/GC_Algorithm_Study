#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int a[40];
vector<int> l, r;
int n, s;
long long ans = 0;

void goLeft(int selected, int sum) {
    if(selected >= n / 2) return;
    l.push_back(sum + a[selected]);
    if(s == sum + a[selected]) ans++;
    // select
    goLeft(selected + 1, sum + a[selected]);
    // do not select
    goLeft(selected + 1, sum);
}

void goRight(int selected, int sum) {
    if(selected >= n) return;
    r.push_back(sum + a[selected]);
    if(s == sum + a[selected]) ans++;
    // select
    goRight(selected + 1, sum + a[selected]);
    // do not select
    goRight(selected + 1, sum);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    // input
    cin >> n >> s;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    // divide left and right
    // find among left element
    goLeft(0, 0);
    // find among right element
    goRight(n / 2, 0);
    // find between left and right
    sort(l.begin(), l.end());
    sort(r.begin(), r.end());
    for(int i = 0; i < l.size(); i++) {
        int left = s - l[i];
        int lower = lower_bound(r.begin(), r.end(), left) - r.begin();
        int upper = upper_bound(r.begin(), r.end(), left) - r.begin();
        ans += upper - lower;
    }

    // output
    cout << ans << '\n'; 
    return 0;
}