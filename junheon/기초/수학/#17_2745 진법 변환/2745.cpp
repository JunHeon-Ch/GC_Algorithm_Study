#include <iostream>
#include <string>

using namespace std;

int main() {
    string n;
    int b;
    cin >> n >> b;

    int ans = 0;
    for(int i = 0; i < n.length(); i++) {
        if(n[i] - '0' >= 0 && n[i] - '0' <= 9) {
            ans = ans * b + (n[i] - '0');
        }
        else if(n[i] - 'A' >= 0 && n[i] - 'A' <= 26) {
            ans = ans * b + (n[i] - 'A' + 10);
        }
    }
    cout << ans;

    return 0;
}