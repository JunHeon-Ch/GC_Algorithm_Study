// 인접 리스트를 이용한 dfs, bfs

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>

// g -> 그래프
// check -> 방문 여부 (0 -> 방문 x / 1 -> 방문 o / 2 -> 사이클)
// dist -> 사이클과의 거리
using namespace std;
int n;
vector<int> g[3001];
int check[3001];
int dist[3001];

// 사이클 찾기
// s -> 현재 위치 / p -> 이전 위치
// -2: 사이클이 있지만 사이클에 들어가지 않는 점
// -1: 사이클 없음
// 1~n: 사이클이 있고, 시작 점
int dfs(int s, int p) {
    if(check[s] == 1) {
        return s;
    }
    check[s] = 1;
    for(int n : g[s]) {
        if(n != p) {
            int res = dfs(n, s);
            if(res == -2) return -2;
            if(res > 0) {
                check[s] = 2;
                if(res == s) return -2;
                else return res;
            }
        }
    }
    return -1;
}

// 각 점에서 사이클까지의 거리
void bfs() {
    queue<int> q;
    for(int i = 1; i <= n; i++) {
        if(check[i] == 2) {
            dist[i] = 0;
            q.push(i);
        }
        else dist[i] = -1;
    }
    while(!q.empty()) {
        int p = q.front();
        q.pop();
        for(int n : g[p]) {
            if(dist[n] == -1) {
                q.push(n);
                dist[n] = dist[p] + 1;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for(int i = 0; i < n; i++) {
        int u, v;
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    dfs(1, -1);
    bfs();

    for(int i = 1; i <= n; i++) {
        cout << dist[i] << ' ';
    }
    cout << '\n';

    return 0;
}