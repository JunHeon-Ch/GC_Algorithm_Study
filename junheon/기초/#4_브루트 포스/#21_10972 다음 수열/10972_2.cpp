#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> p(n);
    for(int i = 0; i < n; i++) {
        cin >> p[i];
    }

    int i = n - 1;
    while(i > 0 && p[i - 1] > p[i]) i--;
    if(i == 0) {
        cout << -1 << '\n';
        return 0;
    }
    
    int min_idx = i;
    for(int j = i + 1; j < n; j++) {
        if(p[j] > p[i - 1] && p[j] < p[min_idx]) {
            min_idx = j;
        }
    }
    swap(p[i - 1], p[min_idx]);
    reverse(p.begin() + i, p.end());

    for(int i = 0; i < n; i++) {
        cout << p[i] << ' ';
    }
    cout << '\n';

    return 0;
}