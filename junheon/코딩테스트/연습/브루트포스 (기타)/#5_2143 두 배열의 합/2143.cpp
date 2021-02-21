#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int a[1000], b[1000];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int t, n, m;
    cin >> t;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    cin >> m;
    for(int i = 0; i < m; i++) {
        cin >> b[i];
    }
    // find all case in A and B
    vector<long long> sumA, sumB;
    for(int i = 0; i < n; i++) {
        long long sum = 0;
        for(int j = i; j < n; j++) {
            sum += a[j];
            sumA.push_back(sum);
        }
    }
    for(int i = 0; i < m; i++) {
        long long sum = 0;
        for(int j = i; j < m; j++) {
            sum += b[j];
            sumB.push_back(sum);
        }
    }
    sort(sumA.begin(), sumA.end());
    sort(sumB.begin(), sumB.end());
    int front = 0, rear = sumB.size() - 1;
    long long ans = 0;
    while(true) {
        if(sumA[front] + sumB[rear] > t) {
            rear--;
        }
        else if(sumA[front] + sumB[rear] < t) {
            front++;
        }
        else if(sumA[front] + sumB[rear] == t) {
            long long cntA = 1, cntB = 1;
            while(front + 1 < sumA.size() && sumA[front] == sumA[front + 1]) {
                front++; cntA++;
            }
            while(rear - 1 >= 0 && sumB[rear] == sumB[rear - 1]) {
                rear--; cntB++;
            }
            ans += cntA * cntB;
            front++; rear--;
        }
        if(front >= sumA.size() || rear < 0) break;
    }

    // output
    cout << ans << '\n';
    return 0;
}