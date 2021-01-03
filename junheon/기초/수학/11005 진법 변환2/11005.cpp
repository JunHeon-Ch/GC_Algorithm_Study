#include <iostream>

using namespace std;

void printNo(int n) {
    if(n >= 10) {
        cout << char(n - 10 + 'A');
    }
    else {
        cout << n;
    }
}
void notation(int n, int b) {
    if(n < b) {
        printNo(n);
    }
    else {
        notation(n / b, b);
        printNo(n % b);
    }
}

int main() {
    int n, b;
    cin >> n >> b;
    notation(n, b);

    return 0;
}