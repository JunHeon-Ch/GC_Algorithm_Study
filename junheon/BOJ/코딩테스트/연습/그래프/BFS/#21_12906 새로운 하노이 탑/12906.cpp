#include <iostream>
#include <queue>
#include <map>
#include <array>

using namespace std;
map<array<string, 3>, int> d;

void bfs(array<string, 3> &s) {
    queue<array<string, 3>> q;
    q.push(s);
    d[s] = 0;
    while(!q.empty()) {
        auto now = q.front();
        q.pop();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) continue;
                if(now[i].length() == 0) continue;
                array<string, 3> next(now);
                next[j].push_back(next[i].back());
                next[i].pop_back();
                if(d.count(next) == 0) {
                    d[next] = d[now] + 1;
                    q.push(next);
                }
            }
        }
    }
}

int main() {
    // input
    array<string, 3> s;
    for(int i = 0; i < 3; i++) {
        int cnt;
        cin >> cnt;
        if(cnt > 0) {
            cin >> s[i];
        } else {
            s[i] = "";
        }
    }
    // A, B, C °¹¼ö Ã£±â
    // Find the number of A, B, and C
    int cnt[3] = {0, };
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < s[i].length(); j++) {
            cnt[s[i][j] - 'A']++;
        }
    }

    bfs(s);

    // output
    array<string, 3> ans;
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < cnt[i]; j++) {
            ans[i] += (char)('A' + i);
        }
    }
    cout << d[ans] << '\n';
    return 0;
}