#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
const int PLUS = 0;
const int MINUS = 1;
const int MUL = 2;
const int DIV = 3;

int calculate(int a, int b, int op) {
    switch(op) {
        case PLUS:
        return a + b;
        case MINUS:
        return a - b;
        case MUL:
        return a * b;
        case DIV:
        return a / b;
    }
}

int main() {
    // input
    int n;
    cin >> n;
    vector<int> num(n);
    for(int i = 0; i < n; i++) {
        cin >> num[i];
    }
    vector<int> op(n - 1);
    int k = 0;
    for(int i = 0; i < 4; i++) {
        int o;
        cin >> o;
        while(o--) op[k++] = i;
    }
    sort(op.begin(), op.end());

    // using permutation
    int maxVal = -1000000001, minVal = 1000000001;
    do {
        int res = num[0];
        for(int i = 0; i < n - 1; i++) {
            res = calculate(res, num[i + 1], op[i]);
        }
        maxVal = max(maxVal, res);
        minVal = min(minVal, res);
    } while(next_permutation(op.begin(), op.end()));

    // output
    cout << maxVal << '\n';
    cout << minVal << '\n';
    return 0;
}