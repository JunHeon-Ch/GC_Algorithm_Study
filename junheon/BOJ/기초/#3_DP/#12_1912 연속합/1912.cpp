#include <iostream>
#include <algorithm>

using namespace std;
int ans[100001];

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) {
        int n;
        cin >> n;
        if(i == 0) {
            ans[i] = n;
        }
        else {
            if(ans[i - 1] + n >= n) {
                ans[i] = ans[i - 1] + n;
            }
            else {
                ans[i] = n;
            }
        }
    }
    cout << *max_element(ans, ans + t) << '\n';

    return 0;
}