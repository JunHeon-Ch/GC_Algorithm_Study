#include <iostream>
#include <queue>
#include <map>
#include <algorithm>

using namespace std;
map<long long, bool> c;

int main() {
    // input
    long long s, t;
    cin >> s >> t;
    
    // s와 t가 같은 경우
    // If s and t are equal
    if(s == t) {
        cout << 0 << '\n';
        return 0;
    }
    // s를 t로 바꾸는 프로세스
    // the process of replacing s with t
    bool flag = false;
    queue<pair<long long, string>> q;
    q.push(make_pair(s, ""));
    while(!q.empty()) {
        s = q.front().first;
        string op = q.front().second;
        q.pop();
        if(s == t) {
            cout << op << '\n';
            return 0;
        }
        long long res = s * s;
        if(res <= t && c.find(res) == c.end()) {
            q.push(make_pair(res, op + "*"));
            c[res] = true;
        }
        res = s + s;
        if(res <= t && c.find(res) == c.end()) {
            q.push(make_pair(res, op + "+"));
            c[res] = true;
        }
        if(!flag) {
            q.push(make_pair(1, op + "/"));
            flag = true;
        }
    }
    // 바꿀 수 없는 경우
    // If can't replacement
    cout << -1 << '\n';
    return 0;
}