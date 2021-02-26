#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
int c[1000001];

int main() {
    int f, s, g, u, d;
    cin >> f >> s >> g >> u >> d;

    memset(c, -1, sizeof(c));
    queue<int> q;
    q.push(s);
    c[s] = 0;
    while(!q.empty()) {
        int x = q.front();
        q.pop();
        if(x == g) {
            cout << c[g] << '\n';
            return 0;
        }
        int nx = x + u;
        if(nx <= 1000000 && c[nx] == -1) {
            c[nx] = c[x] + 1;
            q.push(nx);
        }
        nx = x - d;
        if(nx >= 1 && c[nx] == -1) {
            c[nx] = c[x] + 1;
            q.push(nx);
        }
    }
    cout << "use the stairs\n";
    return 0; 
}