#include <iostream>

using namespace std;
int a[201];
bool robot[201];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    // input
    int n, k;
    cin >> n >> k;
    n *= 2;
    for(int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    int level = 0;
    while(++level) {
        // 1. rotate belt
        int tmp = a[n];
        for(int i = n - 1; i >= 1; i--) {
            a[i + 1] = a[i];
        }
        a[1] = tmp;
        for(int i = n / 2 - 1; i >= 1; i--) {
            if(robot[i]) {
                robot[i + 1] = true;
                robot[i] = false;
            }
        }
        robot[n / 2] = false;
        
        // 2. move robot
        for(int i = n / 2 - 1; i >= 1; i--) {
            if(robot[i] && !robot[i + 1] && a[i + 1] > 0) {
                robot[i + 1] = true;
                robot[i] = false;
                a[i + 1]--;
            }
        }
        robot[n / 2] = false;

        // 3. put a robot on a belt
        if(a[1] > 0 && !robot[1]) {
            robot[1] = true;
            a[1]--;
        }

        // 4. finish
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(a[i] == 0) cnt++;
        }
        if(cnt >= k) break;
    }
    // output
    cout << level << '\n';
    return 0;
}