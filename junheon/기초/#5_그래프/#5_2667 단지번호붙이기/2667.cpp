// 인접 리스트를 이용한 bfs

#include <cstdio>
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
int complex[625];
int complexNum[625];
vector<int> g[625];

void bfs(int s, int cNum) {
    queue<int> q;
    complex[s] = cNum;
    complexNum[cNum]++;
    q.push(s);
    while(!q.empty()) {
        int x = q.front();
        q.pop();
        for(int i = 0; i < g[x].size(); i++) {
            int y = g[x][i];
            if(complex[y] == 0) {
                complex[y] = cNum;
                complexNum[cNum]++;
                q.push(y);
            }
        }
    }
}

int main() {
    int n;
    scanf("%d", &n);
    int a[25][25];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            scanf("%1d", &a[i][j]);
        }
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(a[i][j] == 0) continue;
            if(i < n - 1) {
                if(a[i + 1][j] == 1) {
                    g[i * n + j].push_back((i + 1) * n + j);
                    g[(i + 1) * n + j].push_back(i * n + j);
                }
            }
            if(j < n - 1) {
                if(a[i][j + 1] == 1) {
                    g[i * n + j].push_back(i * n + j + 1);
                    g[i * n + j + 1].push_back(i * n + j);
                }
            }
        }
    }

    int cnt = 0;
    for(int i = 0; i < n * n; i++) {
        if(complex[i] == 0 && a[i / n][i % n] == 1) {
            cnt++;
            bfs(i, cnt);            
        }
    }

    printf("%d\n", cnt);
    sort(complexNum + 1, complexNum + cnt + 1);
    for(int i = 1; i <= cnt; i++) {
        printf("%d\n", complexNum[i]);
    }

    return 0;
}