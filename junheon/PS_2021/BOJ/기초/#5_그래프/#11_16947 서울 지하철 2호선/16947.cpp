// ���� ����Ʈ�� �̿��� dfs, bfs

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>

// g -> �׷���
// check -> �湮 ���� (0 -> �湮 x / 1 -> �湮 o / 2 -> ����Ŭ)
// dist -> ����Ŭ���� �Ÿ�
using namespace std;
int n;
vector<int> g[3001];
int check[3001];
int dist[3001];

// ����Ŭ ã��
// s -> ���� ��ġ / p -> ���� ��ġ
// -2: ����Ŭ�� ������ ����Ŭ�� ���� �ʴ� ��
// -1: ����Ŭ ����
// 1~n: ����Ŭ�� �ְ�, ���� ��
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

// �� ������ ����Ŭ������ �Ÿ�
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