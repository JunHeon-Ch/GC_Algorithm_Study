#include <iostream>
#include <cmath>

using namespace std;

void bNotation(int n, int b) {
    if(n < b) {
        cout << n << ' ';
    }
    else {
        bNotation(n / b, b);
        cout << n % b << ' ';
    }
}

int main() {
    int a, b;
    int n;
    cin >> a >> b;
    cin >> n;
    int ans = 0;
    while(n--) {
        int num;
        cin >> num;
        ans = ans * a + num;
    }
    bNotation(ans, b);

    return 0;
}