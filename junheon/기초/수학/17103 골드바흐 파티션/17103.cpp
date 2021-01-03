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
    cout << prime.size();

    return 0;
}

// #include <iostream>
// #include <vector>
// using namespace std;
// bool check[1000001];
// int main() {
//     ios_base::sync_with_stdio(false);
//     cin.tie(nullptr);
//     vector<int> primes;
//     for (int i=2; i<=1000000; i++) {
//         if (check[i] == false) {
//             primes.push_back(i);
//             for (int j=i+i; j<=1000000; j+=i) {
//                 check[j] = true;
//             }
//         }
//     }
//     int t;
//     cin >> t;
//     while (t--) {
//         int n;
//         cin >> n;
//         int ans = 0;
//         for (int i=0; i<primes.size(); i++) {
//             if (n-primes[i] >= 2 && primes[i] <= n-primes[i]) {
//                 if (check[n-primes[i]] == false) {
//                     ans += 1;
//                 }
//             } else {
//                 break;
//             }
//         }
//         cout << ans << '\n';
//     }

//     cout << primes.size();

//     return 0;
// }