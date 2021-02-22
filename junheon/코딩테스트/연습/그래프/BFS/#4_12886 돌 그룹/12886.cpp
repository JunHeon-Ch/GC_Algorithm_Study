#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;
int a, b, c, d;
bool check[1500][1500];

void bfs() {
    queue<pair<int, int>> q;
    int A = min({a, b, c});
    int B = max({a, b, c});
    q.push(make_pair(A, B));
    check[A][B] = true;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        int z = d - x - y;
        // output
        if(x == z && y == z) {
            cout << 1 << '\n';
            return;
        }
        int nx[] = {x, x, y}, ny[] = {y, z, z};
        for(int i = 0; i < 3; i++) {
            int A = nx[i], B = ny[i];
            if(A > B) {
                A -= B; B += B;
            }
            else if(A < B) {
                B -= A; A += A;
            }
            else continue;
            int C = d - A - B;
            int X = min({A, B, C});
            int Y = max({A, B, C});
            if(!check[X][Y]) {
                q.push(make_pair(X, Y));
                check[X][Y] = true;
            }
        }
    }
    
    // output
    cout << 0 << '\n';
}

int main() {
    // input
    cin >> a >> b >> c;

    // If the sum of the three is not divided into three, print 0
    d = a + b + c;
    if(d % 3 != 0) {
        cout << 0 << '\n';
    }
    else {
        bfs();
    }

    return 0;
}