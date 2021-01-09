#include <iostream>

using namespace std;
const long long DIV = 1000000000;
const int DIGIT = 10;
const int MAX = 100;
long long d[MAX + 1][DIGIT];

int main() {
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        for(int j = 0; j < DIGIT; j++) {
            if(i == 1 && j != 0) {
                d[i][j] = 1;
            }
            else if(j == 0) {
                d[i][j] = d[i - 1][1] % DIV;
            }
            else if(j == 9) {
                d[i][j] = d[i - 1][8] % DIV;
            }
            else {
                d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % DIV;
            }
        }
    }
    long long ans = 0;
    for(int i = 0; i <= DIGIT; i++) {
        ans += d[n][i];
    }
    cout << ans % DIV << '\n';
    
    return 0;
}