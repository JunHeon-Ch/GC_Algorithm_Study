// BFS

#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
int a[1000];
int d[1000];

int main() {
    // input
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    // operation
    memset(d, -1, sizeof(d));
    queue<int> q;
    q.push(0);
    d[0] = 0;
    while(!q.empty()) {
        int x = q.front();
        q.pop();
        for(int i = 1; i <= a[x]; i++) {
            int nx = x + i;
            if(nx >= n) continue;
            if(d[nx] != -1) continue;
            d[nx] = d[x] + 1;
            q.push(nx);
        }
    }

    // output
    cout << d[n - 1] << '\n';
    return 0;
}