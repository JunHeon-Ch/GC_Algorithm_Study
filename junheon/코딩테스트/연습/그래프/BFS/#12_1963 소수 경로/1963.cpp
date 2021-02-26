#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;
vector<int> pv;
int c[10000];
bool prime[10000];

// find prime number
void isPrime() {
    for(int i = 2; i < 10000; i++) {
        if(prime[i]) continue;
        if(i >= 1000) pv.push_back(i);
        for(int j = i + i; j < 10000; j += i) {
            prime[j] = true;
        }
    }    
}

// 두 수가 한 자리수만 다른지 찾기 위함
// To find out if two numbers differ by only one digit
bool differentOnePos(int n1, int n2) {
    int cnt = 0;
    while(n1 != 0 && n2 != 0) {
        if((n1 % 10) != (n2 % 10)) {
            cnt++;
            if(cnt > 1) return false;
        }
        n1 /= 10, n2 /= 10;
    }
    return true;
}

int bfs(int s, int e) {
    int i = 0;
    while(pv[i] != s) i++;
    queue<int> q;
    q.push(i);
    memset(c, -1, sizeof(c));
    c[i] = 0;
    while(!q.empty()) {
        int si = q.front();
        q.pop();
        if(pv[si] == e) return c[si];
        for(i = 0; i < pv.size(); i++) {
            if(c[i] != -1) continue;
            if(differentOnePos(pv[i], pv[si])) {
                q.push(i);
                c[i] = c[si] + 1;
            }
        }
    }  
    return -1;
}

int main() {
    isPrime();
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int s, e;
        cin >> s >> e;
        int ans = bfs(s, e);
        if(ans == -1) {
            cout << "Impossible\n";
        }
        else {
            cout << ans << '\n';
        }
    }
    return 0;
}