#include <iostream>

using namespace std;

int gcd(int a, int b) {
    if(b == 0) {
        return a;
    }
    else {
        return gcd(b, a % b);
    }
}

int main() {
    int t;
    cin >> t;

    while(t--) {
        int n;
        cin >> n;

        int arr[100];
        for(int i = 0; i < n; i++) {
            cin >> arr[i];
        }

        long long sum_gcd = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                sum_gcd += gcd(arr[i], arr[j]);
            }
        }
        cout << sum_gcd << '\n';
    }
    return 0;
}