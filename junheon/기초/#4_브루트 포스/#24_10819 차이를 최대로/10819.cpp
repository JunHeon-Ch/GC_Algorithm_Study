#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int calculator(vector<int> p) {
    int result = 0;
    for(int i = 1; i < p.size(); i++) {
        result += abs(p[i - 1] - p[i]);
    }

    return result;
}

int main() {
    int n;
    cin >> n;
    vector<int> p(n);
    for(int i = 0; i < n; i++) {
        cin >> p[i];
    }
    sort(p.begin(), p.end());

    int ans = 0;
    do {
        int result = calculator(p);
        ans = max(ans, result);
    } while(next_permutation(p.begin(), p.end()));

    cout << ans << '\n';

    return 0;
}