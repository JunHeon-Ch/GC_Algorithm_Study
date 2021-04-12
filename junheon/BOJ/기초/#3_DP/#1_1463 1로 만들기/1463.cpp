#include <iostream>

using namespace std;
int memo[1000001];

int main() {
    int n;
    cin >> n;

    memo[1] = 0;
    for(int i = 2; i <= n; i++) {
        memo[i] = memo[i - 1] + 1;
        if(i % 3 == 0 && memo[i] > memo[i / 3] + 1) {
            memo[i] = memo[i / 3] + 1;
        }
        else if(i % 2 == 0 && memo[i] > memo[i / 2] + 1) {
            memo[i] = memo[i / 2] + 1;
        }
    }
    cout << memo[n] << '\n';
    
    return 0;
}
