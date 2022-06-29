#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    while(cin >> n) {
        if(n == 1) {
            cout << 1 << '\n';
            continue;
        }
        int res = 1;
        int cnt = 0;
        while((res * 10 + 1) % n) {   
            cnt++;
            res = (res * 10 + 1) % n;
        }
        cout << cnt + 2 << '\n';
    }
    return 0;
}