#include <iostream>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    if(b == 0) {
        return a;
    }
    else {
        return gcd(b, a % b);
    }
}

int main() {
    int n, s;
    cin >> n >> s;

    vector<int> x(n);
    for(int i = 0; i < n; i++) {
        cin >> x[i];
        x[i] = abs(x[i] - s);
    }
    
    int g = x[0];
    for(int i = 1; i < n; i++) {
        g = gcd(g, x[i]);
    }
    cout << g << '\n';

    return 0;
}