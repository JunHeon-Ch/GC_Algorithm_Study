#include <vector>
#include <queue>

using namespace std;

int bfs(vector<vector<int>> p, int m, int n, vector<vector<int>> &g, int sx, int sy, int paint) {
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    int res = 0;
    queue<pair<int, int>> q;
    q.push({sx, sy});
    g[sx][sy] = paint;
    while(!q.empty()) {
        sx = q.front().first;
        sy = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(g[nx][ny] != 0) continue;
            if(p[sx][sy] != p[nx][ny]) continue;
            g[nx][ny] = paint;
            q.push({nx, ny});
        }
    }
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(g[i][j] == paint) res++;
        }
    }
    return res;
}
// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    vector<vector<int>> g(m, vector<int>(n, 0));

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(picture[i][j] == 0) continue;
            if(g[i][j] != 0) continue;
            number_of_area++;
            int res = bfs(picture, m, n, g, i, j, number_of_area);
            max_size_of_one_area = max(res, max_size_of_one_area);
        }
    }
    
    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}