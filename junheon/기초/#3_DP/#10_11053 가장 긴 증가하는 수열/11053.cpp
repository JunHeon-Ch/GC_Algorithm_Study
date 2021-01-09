#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
const int MAX = 1000;
int d[MAX];

int main() {
    int n;
    cin >> n;
    vector<int> s(n);
    for(int i = 0; i < n; i++) {
        cin >> s[i];
    }
    for(int i = 0; i < n; i++) {
        d[i] = 1;
        for(int j = 0; j < i; j++) {
            if(s[i] > s[j] && d[i] < d[j] + 1) {
                d[i] = d[j] + 1;
            }
        }
    }
    cout << *max_element(d, d + n) << '\n';

    return 0;
}