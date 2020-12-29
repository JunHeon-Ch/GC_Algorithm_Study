#include <iostream>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;

    vector<int> arr(t);
    int cnt = 0;
    while(t--) {
        int n;
        cin >> n;

        bool flag = true;
        if(n == 1) {
            continue;
        }
        else {
            for(int j = 2; j * j <= n; j++) {
                if(n % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                cnt++;
            }
        }
    }

    cout << cnt << '\n';

    return 0;
}