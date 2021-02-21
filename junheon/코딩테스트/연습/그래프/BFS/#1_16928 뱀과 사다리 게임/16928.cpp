#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
int a[101];
int c[101];

void bfs() {
    queue<int> q;
    q.push(1);
    c[1] = 0;
    while(!q.empty()) {
        int x = q.front();
        q.pop();
        for(int i = 1; i <= 6; i++) {
            int n = x + i;
            if(n > 100) continue;
            if(a[n] != 0) {
                n = a[n];
            }
            if(c[n] == -1) {
                c[n] = c[x] + 1;
                q.push(n);
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        int u, v;
        cin >> u >> v;
        a[u] = v;
    }
    for(int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        a[u] = v;
    }
    memset(c, -1, sizeof(c));
    
    bfs();

    // output
    cout << c[100] << '\n';
    return 0;
}