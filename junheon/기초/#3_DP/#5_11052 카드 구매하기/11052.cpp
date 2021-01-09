#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> p(n + 1);
    vector<int> maxP(n + 1);
    
    for(int i = 1; i <= n; i++) {
        cin >> p[i];
    }
    maxP[0] = 0;
    for(int i = 1; i <= n; i++) {
        maxP[i] = maxP[i - 1];
        for(int j = 0; j < i; j++) {
            maxP[i] = max(maxP[i], maxP[j] + p[i - j]);
        }
    }
    cout << maxP[n] << '\n';

    return 0;
}