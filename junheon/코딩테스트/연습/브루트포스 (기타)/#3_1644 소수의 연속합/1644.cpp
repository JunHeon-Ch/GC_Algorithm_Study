#include <iostream>
#include <vector>

using namespace std;
int main() {
    // input
    int n;
    cin >> n;
    vector<bool> check(n + 1, false);
    vector<int> prime;

    // find prime number
    for(int i = 2; i <= n; i++) {
        if(!check[i]) {
            prime.push_back(i);
            for(int j = i * i; j <= n; j += i) {
                check[j] = true;
            }
        }
    }

    // continuous sum
    int front = 0, rear = 0;
    int sum = 0, ans = 0;
    while(true) {
        if(sum >= n) {
            sum -= prime[front++];
        }
        else if(rear == prime.size()) {
            break;
        }
        else {
            sum += prime[rear++];
        }
        if(sum == n) {
            ans++;
        }
    }

    // output
    cout << ans << '\n';
    return 0;
}