#include <iostream>
#include <vector>

using namespace std;
int s[20][20];

int calc(vector<int> &left, vector<int> &right, int n) {
    int l = 0, r = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(i == j) continue;
            l += s[left[i]][left[j]];
            r += s[right[i]][right[j]];
        }
    }

    return abs(l - r);
}

int main() {
    int  n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> s[i][j];
        }
    }
    vector<int> left, right;
    int min = -1;
    for(int i = 1; i < (1 << n); i++) {
        for(int j = 0; j < n; j++) {
            if(i & (1 << j)) {
                left.push_back(j);
            }
            else if(~i &(1 << j)) {
                right.push_back(j);
            }
        }
        if(left.size() == n / 2) {
            int c = calc(left, right, n / 2);
            if(min == -1 || min > c) {
                min = c;
            }
        }
        left.clear();
        right.clear();
    }
    cout << min << '\n';

    return 0;
}