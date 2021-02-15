#include <iostream>

using namespace std;
int a[100000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, s;
    cin >> n >> s;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int front = 0, rear = 0;
    int sum = 0, ans = n;
    while(true) {
        if(sum >= s) {
            sum -= a[front++];
        }
        else if(rear == n) {
            break;
        }
        else {
            sum += a[rear++];
        }
        if(sum >= s) {
            ans = min(ans, rear - front);
        }
    }

    // output
    cout << ans << '\n';
    return 0;
}