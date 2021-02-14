#include <iostream>

using namespace std;
int a[20];
bool c[2000000];
int n;

void go(int selected, int sum) {
    // escape condition
    if(selected >= n) {
        c[sum] = true;
        return;
    }
    // make a choice
    go(selected + 1, sum + a[selected]);
    // don't make a choice
    go(selected + 1, sum);
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    // find the sum of the partial sequences
    go(0, 0);

    // find the smallest natural number that cannot come out as the sum of the partial sequences
    int i;
    for(i = 1; i <= 2000000; i++) {
        if(!c[i]) break;
    }
    
    // output
    cout << i << '\n';
}