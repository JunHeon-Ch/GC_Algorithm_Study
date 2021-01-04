#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

const int MAX = 1000000;
bool check[MAX + 1];

int main() {
    vector<int> prime;
    check[0] = check[1] = true;
    for(int i = 2; i <= MAX; i++) {
        if(!check[i]) {
            prime.push_back(i);
            for(int j = i + i; j <= MAX; j += i) {
                check[j] = true;
            }
        }
    }

    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        
        int cnt = 0;
        for(int i = 0; i < prime.size(); i++) {
            if(prime[i] <= n - prime[i]) {
                if(!check[n - prime[i]]) {
                    cnt++;
                }
            }
            else {
                break;
            }
        }
        cout << cnt << '\n';
    }

    return 0;
}