#include <iostream>

using namespace std;
const int PLUS = 0;
const int MINUS = 1;
const int MUL = 2;
const int DIV = 3;
int a[11];
int o[4];
int maxVal = -1000000001, minVal = 1000000001;

int calculate(int oi, int ai, int op) {
    int res = 0;
    switch(oi) {
        case PLUS:
        res = op + a[ai + 1];
        break;
        case MINUS:
        res = op - a[ai + 1];
        break;
        case MUL:
        res = op * a[ai + 1];
        break;
        case DIV:
        res = op / a[ai + 1];
        break;
    }
    return res;
}

void go(int n, int index, int prevRes) {
    // escape condition
    if(index == n) {
        if(maxVal < prevRes) maxVal = prevRes;
        if(minVal > prevRes) minVal = prevRes;
        return;
    }
    // Create partial sequence
    for(int i = 0; i < 4; i++) {
        if(o[i] > 0) {
            o[i]--;
            int nowRes = calculate(i, index, prevRes);
            go(n, index + 1, nowRes);
            o[i]++;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for(int i = 0; i < 4; i++) {
        cin >> o[i];
    }

    go(n - 1, 0, a[0]);

    // output
    cout << maxVal << '\n';
    cout << minVal << '\n';
    return 0;
}