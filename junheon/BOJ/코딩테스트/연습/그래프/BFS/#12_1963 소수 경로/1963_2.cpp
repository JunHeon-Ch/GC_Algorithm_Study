#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;
int c[10000];
bool prime[10000];

// find prime number
void isPrime() {
    for(int i = 2; i * i < 10000; i++) {
        if(prime[i]) continue;
        for(int j = i + i; j < 10000; j += i) {
            prime[j] = true;
        }
    }    
}

int bfs(int s, int e) {
    queue<int> q;
    q.push(s);
    memset(c, -1, sizeof(c));
    c[s] = 0;
    while(!q.empty()) {
        s = q.front();
        q.pop();
        if(s == e) return c[s];
        // 1의 자리부터 1000의 자리까지 모든 숫자를 바꿔보면서 소수인지 확인
        // Change every number from 1 to 1000 to see if it's a prime number.
        for(int i = 1; i <= 1000; i *= 10) {
            for(int j = 0; j < 10; j++) {
                if(i == 1000 && j == 0) continue;
                int ns = s - (s / i % 10) * i + i * j;
                if(prime[ns] || c[ns] != -1) continue;
                c[ns] = c[s] + 1;
                q.push(ns);
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
        } else {
            cout << ans << '\n';
        }
    }
    return 0;
}