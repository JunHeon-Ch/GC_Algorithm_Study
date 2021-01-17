#include <iostream>

using namespace std;
const int E = 15;
const int S = 28;
const int M = 19;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int e, s, m;
    cin >> e >> s >> m;

    for(int i = 1; i <= E * S * M; i++) {
        if(i - e < 0 || i - s < 0 || i - m < 0) {
            continue;
        }
        if((i - e) % E == 0 && (i - s) % S == 0 && (i - m) % M == 0) {
            cout << i << '\n';
            return 0;
        }
    }
    return 0;
}