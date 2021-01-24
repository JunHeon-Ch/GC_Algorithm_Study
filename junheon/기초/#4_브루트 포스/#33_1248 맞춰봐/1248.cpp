#include <iostream>

using namespace std;
int sign[10][10];
int ans[10];
int n;

bool check(int index) {
    int sum = 0;
    for(int i = index; i >= 0; i--) {
        sum += ans[i];
        if(sign[i][index] == 0) {
            if(sum != 0) return false;
        }
        else if(sign[i][index] > 0) {
            if(sum <= 0) return false;
        }
        else if(sign[i][index] < 0) {
            if(sum >= 0) return false;
        }
    }
    return true;
}

bool go(int index) {
    if(index == n) {
        return true;
    }
    if(sign[index][index] == 0) {
        ans[index] = 0;
        return check(index) && go(index + 1);
    }
    for(int i = 1; i <= 10; i++) {
        ans[index] = sign[index][index] * i;
        if(check(index) && go(index + 1)) return true;
    }
    return false;
}

int main() {
    cin >> n;
    string s;
    cin >> s;
    int k = 0;
    for(int i = 0; i < n; i++) {
        for(int j = i; j < n; j++) {
            if(s[k] == '0') sign[i][j] = 0;
            else if(s[k] == '+') sign[i][j] = 1;
            else if(s[k] == '-') sign[i][j] = -1;
            k++;
        }
    }
    go(0);
    for(int i = 0; i < n; i++) {
        cout << ans[i] << ' ';
    }
    cout << '\n';

    return 0;
}