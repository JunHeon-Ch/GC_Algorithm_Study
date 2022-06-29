// 채점 결과
// 정확성: 50.0
// 효율성: 6.7
// 합계: 56.7 / 100.0

#include <string>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;
int d[200][200];

int bfs(int n, int s, int e1, int e2, int e3, vector<vector<int>> fares) {
    vector<int> d(n, -1);
    queue<int> q;
    q.push(s);
    d[s] = 0;
    while(!q.empty()) {
        s = q.front();
        q.pop();
        for(int i = 0; i < fares.size(); i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            int c = fares[i][2];
            u--, v--;
            if(u == s) {
                if(d[v] == -1 || d[v] > d[s] + c) {
                    d[v] = d[s] + c;
                    q.push(v);
                }
            }
            else if(v == s) {
                if(d[u] == -1 || d[u] > d[s] + c) {
                    d[u] = d[s] + c;
                    q.push(u);
                }
            }
        }
    }
    if(d[e1] == -1 || d[e2] == -1 || d[e3] == -1) return -1;
    return d[e1] + d[e2] + d[e3];
} 

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    s--, a--, b--;
    int answer = -1;
    for(int i = 0; i < n; i++) {
        int res = bfs(n, i, s, a, b, fares);
        if(res == -1) continue;
        if(answer == -1 || answer > res) {
            answer = res;
        }
    }
    return answer;
}