#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int s[20][20];

int divideTeam(int index, int n, vector<int> &left, vector<int> &right) {
    if(left.size() > n / 2 + 1) return -1;
    if(right.size() > n / 2 + 1) return -1;
    if(index == n) {
        int l = 0, r = 0;
        for(int i = 0; i < left.size(); i++) {
            for(int j = 0; j < left.size(); j++) {
                l += s[left[i]][left[j]];
            }
        }
        for(int i = 0; i < right.size(); i++) {
            for(int j = 0; j < right.size(); j++) {
                r += s[right[i]][right[j]];
            }
        }
        return abs(l - r);
    }
    int ans = -1;
    left.push_back(index);
    int l = divideTeam(index + 1, n, left, right);
    if(ans == -1 || l != -1 && ans > l) {
        ans = l;
    }
    left.pop_back();

    right.push_back(index);
    int r = divideTeam(index + 1, n, left, right);
    if(ans == -1 || r != -1 && ans > r) {
        ans = r;
    }
    right.pop_back();

    return ans;
}

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> s[i][j];
        }
    }
    vector<int> left, right;
    cout << divideTeam(0, n, left, right) << '\n';

    return 0;
}