#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> p(n);
    for(int i = 0; i < n; i++) {
        p[i] = i + 1;
    }

    while(true) {
        for(int i = 0; i < n; i++) {
            cout << p[i] << ' ';
        }
        cout << '\n';

        int i = n - 1;
        while(i > 0 && p[i - 1] > p[i]) i--;
        if(i == 0) {
            break;
        }   

        int min_idx = i;
        for(int j = i + 1; j < n; j++) {
            if(p[i - 1] < p[j] && p[j] < p[min_idx]) {
                min_idx = j;
            }
        }
        swap(p[i - 1], p[min_idx]);
        reverse(p.begin() + i, p.end());
    }

    return 0;
}