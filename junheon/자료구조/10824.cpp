#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main() {
    int a, b, c, d;
    cin >> a >> b >> c >> d;

    string s1 = to_string(a) + to_string(b);
    string s2 = to_string(c) + to_string(d);
    long n1 = stol(s1);
    long n2 = stol(s2);

    cout << n1 + n2 << '\n';

    return 0;
}