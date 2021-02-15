// other people's code

#include <iostream>

using namespace std;
int a[10000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int front = 0, rear = 0;
    int ans = 0, sum = 0;
    while(true) {
        if(sum >= m)
            sum -= a[front++];
        else if(rear == n)
            break;
        else
            sum += a[rear++];
        if(sum == m)
            ans++;
    }

    // output
    cout << ans << '\n';
    return 0;
}