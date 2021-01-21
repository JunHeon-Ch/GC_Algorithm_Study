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

    bool flag = false;
    for(int i = n - 1; i > 0; i--) {
        if(p[i] > p[i - 1]) {
            flag = true;
            int min_idx = i;
            for(int j = i + 1; j < n; j++) {
                if(p[j] > p[i - 1] && p[j] < p[min_idx]) {
                    min_idx = j;
                }
            }
            swap(p[i - 1], p[min_idx]);
            sort(p.begin() + i, p.end());
            break;
        }
    }
    if(!flag) {
        cout << -1 << '\n';
    }
    else {
        for(int i = 0; i < n; i++) {
            cout << p[i] << ' ';
        }
        cout << '\n';
    }

    return 0;
}