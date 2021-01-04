#include <iostream>

using namespace std;

int main() {
    string x;
    cin >> x;
    int n = x.size();

    if(n % 3 == 1) {
        cout << x[0];
    }
    else if(n % 3 == 2) {
        cout << (x[0] - '0') * 2 + (x[1] - '0');
    }
    for(int i = n % 3; i < n; i += 3) {
        cout << (x[i] - '0') * 4 + (x[i + 1] - '0') * 2 + (x[i + 2] - '0');
    }

    return 0;
}