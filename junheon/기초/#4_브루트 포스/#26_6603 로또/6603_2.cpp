#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    while(true) {
        int n;
        cin >> n;
        if(n == 0) return 0;
        vector<int> p(n);
        for(int i = 0; i < n; i++) {
            cin >> p[i];
        }
        vector<int> flag(n);
        for(int i = 0; i < n; i++) {
            if(i < 6) flag[i] = 1;
            else flag[i] = 2;
        }
        do {
            for(int i = 0; i < n; i++) {
                if(flag[i] == 1) {
                    cout << p[i] << ' ';
                }
            }
            cout << '\n';
        } while(next_permutation(flag.begin(), flag.end()));
        cout << '\n';
    }
    return 0;
}