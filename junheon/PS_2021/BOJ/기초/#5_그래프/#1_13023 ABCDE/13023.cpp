#include <iostream>
#include <vector>

using namespace std;
bool a[2000][2000];
vector<int> g[2000];
vector<pair<int, int>> e;

int main() {
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < m; i++) {
        int from, to;
        cin >> from >> to;
        e.push_back({from, to});
        e.push_back({to, from});
        a[from][to] = true;
        a[to][from] = true;
        g[from].push_back(to);
        g[to].push_back(from);
    }

    m *= 2;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < m; j++) {
            int A = e[i].first;
            int B = e[i].second;
            int C = e[j].first;
            int D = e[j].second;
            if(A == B || A == C || A == D || B == C || B == D || C == D) continue;

            if(!a[B][C]) continue;

            for(int E : g[D]) {
                if(A == E || B == E || C == E || D == E) continue;
                cout << 1 << '\n';
                return 0;
            }
        }
    }
    cout << 0 << '\n';

    return 0;
}