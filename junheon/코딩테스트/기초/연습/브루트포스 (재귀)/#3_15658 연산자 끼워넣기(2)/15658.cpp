#include <iostream>

using namespace std;
const int PLUS = 0;
const int MINUS = 1;
const int MUL = 2;
const int DIV = 3;
int a[11];
int c[4];
int minVal = 1000000001, maxVal = -1000000001;

int calculate(int oi, int index, int prev) {
    int res;
    switch(oi) {
        case PLUS:
        res = prev + a[index];
        break;
        case MINUS:
        res = prev - a[index];
        break;
        case MUL:
        res = prev * a[index];
        break;
        case DIV:
        res = prev / a[index];
        break;
    }
    return res;
}

void go(int n, int index, int prevRes) {
    // escape condition
    if(n == index) {
        if(minVal > prevRes) minVal = prevRes;
        if(maxVal < prevRes) maxVal = prevRes;
        return;
    }
    // Create partial sequence
    for(int i = 0; i < 4; i++) {
        if(c[i] > 0) {
            c[i]--;
            int nowRes = calculate(i, index + 1, prevRes);
            go(n, index + 1, nowRes);
            c[i]++;
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
        cin >> c[i];
    }

    go(n - 1, 0, a[0]);

    // output
    cout << maxVal << '\n';
    cout << minVal << '\n';
    return 0;
}