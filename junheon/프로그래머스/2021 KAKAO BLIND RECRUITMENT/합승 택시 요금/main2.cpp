// 채점 결과
// 정확성: 50.0
// 효율성: 50.0
// 합계: 100.0 / 100.0

#include <string>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    s--, a--, b--;
    vector<vector<int>> d(n, vector<int>(n, -1));
    for(int i = 0; i < fares.size(); i++) {
        int u = --fares[i][0];
        int v = --fares[i][1];
        int c = fares[i][2];
        d[u][v] = d[v][u] = c;
    }
    for(int i = 0; i < n; i++) {
        d[i][i] = 0;
    }

    for(int k = 0; k < n; k++) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || i == k || j == k) continue;
                if(d[i][k] == -1 || d[k][j] == -1) continue;
                if(d[i][j] == -1 || d[i][j] > d[i][k] + d[k][j]) {
                    d[i][j] = d[i][k] + d[k][j];
                }
            }
        }
    }

    int answer = -1;
    for(int i = 0; i < n; i++) {
        if(d[s][i] == -1 || d[a][i] == -1 || d[b][i] == -1) continue;
        if(answer == -1 || answer > d[s][i] + d[a][i] + d[b][i]) {
            answer = d[s][i] + d[a][i] + d[b][i];
        }
    }
    return answer;
}