#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> p(n + 1);
    vector<int> minP(n + 1);
    
    for(int i = 1; i <= n; i++) {
        cin >> p[i];
    }
    minP[0] = 0;
    for(int i = 1; i <= n; i++) {
        minP[i] = p[i];
        for(int j = 1; j <= i; j++) {
            minP[i] = min(minP[i], minP[i - j] + p[j]);
        }
    }
    cout << minP[n] << '\n';

    return 0;
}