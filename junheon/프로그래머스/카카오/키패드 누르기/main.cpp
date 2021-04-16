#include <string>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;
int phone[4][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

char bfs(pair<int, int> sp, pair<int, int> lp, pair<int, int> rp, char hand) {
    int d[4][3];
    memset(d, -1, sizeof(d));    
    queue<pair<int, int>> q;
    q.push(sp);
    d[sp.first][sp.second] = 0;
    while(!q.empty()) {
        int px = q.front().first;
        int py = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = px + dx[i];
            int ny = py + dy[i];
            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 3) continue;
            if(d[nx][ny] != -1) continue;
            d[nx][ny] = d[px][py] + 1;
            q.push({nx, ny});
        }
    }

    if(d[lp.first][lp.second] == d[rp.first][rp.second]) {
        return hand;
    }
    else if(d[lp.first][lp.second] < d[rp.first][rp.second]) {
        return 'L';
    }
    else {
        return 'R';
    }
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    char h;
    if(hand == "left") h = 'L';
    else if(hand == "right") h = 'R';

    pair<int, int> lp, rp;
    lp.first = 3, lp.second = 0;
    rp.first = 3, rp.second = 2; 
    for(int n : numbers) {
        if(n == 1 || n == 4 || n == 7) {
            n--;
            lp.first = n / 3;
            lp.second = n % 3;
            answer += "L";
        }
        else if(n == 3 || n == 6 || n == 9) {
            n--;
            rp.first = n / 3;
            rp.second = n % 3;
            answer += "R";
        }
        else {
            pair<int, int> sp;
            if(n == 0) {
                sp.first = 3;
                sp.second = 1;
            } else {
                n--;
                sp.first = n / 3;
                sp.second = n % 3;
            }
            char res = bfs(sp, lp, rp, h);
            answer += res;
            if(res == 'L') {
                lp.first = sp.first;
                lp.second = sp.second;
            }
            else {
                rp.first = sp.first;
                rp.second = sp.second;
            }
        }
    }

    return answer;
}