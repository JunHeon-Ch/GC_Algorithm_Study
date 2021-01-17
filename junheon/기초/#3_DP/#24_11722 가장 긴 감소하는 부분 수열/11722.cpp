#include <iostream>
#include <algorithm>

using namespace std;
int a[1001];
int d[1001];

int main() {
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    for(int i = 1; i <= n; i++) {
        d[i] = 1;
        for(int j = 1; j < i; j++) {
            if(a[i] < a[j] && d[j] + 1 > d[i]) {
                d[i] = d[j] + 1;
            }
        }
    }
    cout << *max_element(d + 1, d + n + 1) << '\n';
    return 0;
}